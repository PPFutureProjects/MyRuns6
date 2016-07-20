package edu.dartmouth.cs.reshmi.myruns.ServerSide;

import android.app.IntentService;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import com.google.android.gms.gcm.GoogleCloudMessaging;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import edu.dartmouth.cs.reshmi.myruns.DisplayEntryActivity;
import edu.dartmouth.cs.reshmi.myruns.ExerciseDataSource;

/**
 * Modified by Reshmi Suresh
 *
 *
 * Created by Varun on 2/18/16.
 */
public class GcmIntentService extends IntentService {
    private ExerciseDataSource dataSource;

    public GcmIntentService() {
        super("GcmIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Bundle extras = intent.getExtras();
        GoogleCloudMessaging gcm = GoogleCloudMessaging.getInstance(this);
        // The getMessageType() intent parameter must be the intent you received
        // in your BroadcastReceiver.
        String messageType = gcm.getMessageType(intent);

        if (extras != null && !extras.isEmpty()) {  // has effect of unparcelling Bundle
            // Since we're not using two way messaging, this is all we really to check for
            if (GoogleCloudMessaging.MESSAGE_TYPE_MESSAGE.equals(messageType)) {
                Logger.getLogger("GCM_RECEIVED").log(Level.INFO, extras.toString());
                String message = extras.getString("message");
                String [] del = message.split(":");
                dataSource = new ExerciseDataSource(this);
                try {
                    dataSource.open();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                if(del.length==2){
                    if(del[0].equals("Delete")){
                        dataSource.deleteExerciseEntry(Integer.parseInt(del[1]));
                    }
                }
            }
        }
        GcmBroadcastReceiver.completeWakefulIntent(intent);
    }

    protected void showToast(final String message) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
            }
        });
    }
}