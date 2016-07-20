package edu.dartmouth.cs.reshmi.myruns;

import android.Manifest;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;

import meapsoft.FFT;

public class TrackingService extends Service implements LocationListener, SensorEventListener {
    private ExerciseEntry mEntry;
    private final IBinder binder = new TrackingServiceBinder();
    private int mInputType;
    private LocationManager mLocationManager;
    private boolean mIsStarted;
    private NotificationManager mNotificationManager;

    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private int mServiceTaskType;
    private OnSensorChangedTask mAsyncTask;
    private boolean asyncExists = false;
    private static ArrayBlockingQueue<Double> mAccBuffer;

    @Override
    public void onLocationChanged(Location location) {
        if (mEntry != null && location!=null) {
            //On location updates, add new location to exercise entry object and send broadcast
            //for the mapsactivity to draw the trace.
            mEntry.insertLocation(location);
            sendUpdate();
        }
    }


    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    @Override
    public void onSensorChanged(SensorEvent event)
    {
        if (event.sensor.getType() == Sensor.TYPE_LINEAR_ACCELERATION) {

            double m = Math.sqrt(event.values[0] * event.values[0]
                    + event.values[1] * event.values[1] + event.values[2]
                    * event.values[2]);

            // Inserts the specified element into this queue if it is possible
            // to do so immediately without violating capacity restrictions,
            // returning true upon success and throwing an IllegalStateException
            // if no space is currently available. When using a
            // capacity-restricted queue, it is generally preferable to use
            // offer.

            try {
                mAccBuffer.add(new Double(m));
            } catch (IllegalStateException e) {

                // Exception happens when reach the capacity.
                // Doubling the buffer. ListBlockingQueue has no such issue,
                // But generally has worse performance
                ArrayBlockingQueue<Double> newBuf = new ArrayBlockingQueue<Double>(
                        mAccBuffer.size() * 2);

                mAccBuffer.drainTo(newBuf);
                mAccBuffer = newBuf;
                mAccBuffer.add(new Double(m));
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    public class TrackingServiceBinder extends Binder {
        public ExerciseEntry getExerciseEntry() {
            return mEntry;
        }

        TrackingService getService() {
            return TrackingService.this;
        }

    }

    @Override
    public void onCreate() {
        mIsStarted = false;

        super.onCreate();

        mAccBuffer = new ArrayBlockingQueue<Double>(
                Globals.ACCELEROMETER_BUFFER_CAPACITY);
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        start(intent);

        return START_NOT_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        start(intent);
        return binder;
    }

    @Override
    public void onDestroy() {


        cancelLocationUpdates();
        if (asyncExists){
            mAsyncTask.cancel(true);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mSensorManager.unregisterListener(this);

        }
        mNotificationManager.cancelAll();
        mIsStarted = false;
        super.onDestroy();
    }

    private void start(Intent intent) {
        if (mIsStarted) {
            return;
        }
        mIsStarted = true;

        initializeNotification();

        startLocationUpdate();

        mEntry = new ExerciseEntry();
        mEntry.setmActivityType(intent.getExtras().getString(Globals.EXTRA_MESSAGE_ACTIVITY));
        if (mEntry.getmActivityType().equals("unknown")) {
            mEntry.setmInputType("Automatic");
            startSensors();
        } else {
            mEntry.setmInputType("GPS");
        }
    }

    private void startSensors()
    {
        asyncExists = true;
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mAccelerometer = mSensorManager
                .getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);

        mSensorManager.registerListener(this, mAccelerometer,
                SensorManager.SENSOR_DELAY_FASTEST);

        mAsyncTask = new OnSensorChangedTask();
        mAsyncTask.execute();

    }

    private void initializeNotification() {
        Intent mapDisplayIntent = new Intent(getApplicationContext(), MainActivity.class);
        mapDisplayIntent.setAction(Intent.ACTION_MAIN);
        mapDisplayIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        mapDisplayIntent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        PendingIntent mapDisplayPendingIntent = PendingIntent.getActivity(getBaseContext(),
                0, mapDisplayIntent, 0);

        // Setup and show notification
        Notification trackNotification = new Notification.Builder(this)
                .setContentTitle("MyRuns")
                .setContentText("Recording your path now. Click to view.")
                .setSmallIcon(R.drawable.icon)
                .setContentIntent(mapDisplayPendingIntent)
                .build();

        // Set the flags to signify ongoing event
        trackNotification.flags |= Notification.FLAG_ONGOING_EVENT;

        // Start notification
        mNotificationManager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        mNotificationManager.notify(5, trackNotification);
    }

    private void startLocationUpdate() {

        // Setup criteria for location manager
        Criteria criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_FINE);
        criteria.setAltitudeRequired(true);
        criteria.setBearingRequired(false);
        criteria.setSpeedRequired(true);
        criteria.setCostAllowed(true);
        criteria.setPowerRequirement(Criteria.POWER_LOW);

        mLocationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        String provider = mLocationManager.getBestProvider(criteria, true);
        Log.d(Globals.TAG, "Provider: " + provider);

        // Auto-generated permission check
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat
                .checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }

        // Start requesting location updates
        mLocationManager.requestLocationUpdates(provider, 0, 0, TrackingService.this);
    }
    private void sendUpdate() {
        Intent intent = new Intent(
                MapsActivity.LocationUpdateReceiver.class.getName());
        intent.putExtra("update", true);
        this.sendBroadcast(intent);

    }
    private void cancelLocationUpdates() {
        // Auto-generated permission check
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mLocationManager.removeUpdates(this);
    }

    private class OnSensorChangedTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... arg0) {

            ArrayList<Double> featVect = new ArrayList<Double>(
                    Globals.ACCELEROMETER_BLOCK_CAPACITY + 1);
            int blockSize = 0;
            FFT fft = new FFT(Globals.ACCELEROMETER_BLOCK_CAPACITY);
            double[] accBlock = new double[Globals.ACCELEROMETER_BLOCK_CAPACITY];
            double[] re = accBlock;
            double[] im = new double[Globals.ACCELEROMETER_BLOCK_CAPACITY];

            double max = Double.MIN_VALUE;

            while (true) {
                try {
                    // need to check if the AsyncTask is cancelled or not in the while loop
                    if (isCancelled () == true)
                    {
                        return null;
                    }

                    // Dumping buffer
                    accBlock[blockSize++] = mAccBuffer.take().doubleValue();

                    if (blockSize == Globals.ACCELEROMETER_BLOCK_CAPACITY) {
                        blockSize = 0;

                        // time = System.currentTimeMillis();
                        max = .0;
                        for (double val : accBlock) {
                            if (max < val) {
                                max = val;
                            }
                        }

                        fft.fft(re, im);

                        for (int i = 0; i < re.length; i++) {
                            double mag = Math.sqrt(re[i] * re[i] + im[i]
                                    * im[i]);
                            featVect.add(Double.valueOf(mag));
                            im[i] = .0; // Clear the field
                        }

                        // Append max after frequency component
                        featVect.add(Double.valueOf(max));
                        int classifiedValue = (int) WekaClassifier
                                .classify(featVect.toArray());
                        String activityId = "Other";
                        switch(classifiedValue){
                            case 0:
                                activityId = "Standing";
                                break;
                            case 1:
                                activityId = "Walking";
                                break;
                            case 2:
                                activityId = "Running";
                                break;
                        }
                        featVect.clear();
                        mEntry.setmActivityType(activityId);
                        //To save a list of inferred activities for majority voting. Majority
                        //voting happening in MapsActivity onSaveClicked()
                        mEntry.addmActivityCount(activityId);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
