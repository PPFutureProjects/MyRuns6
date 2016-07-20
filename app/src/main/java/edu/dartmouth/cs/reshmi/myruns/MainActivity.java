package edu.dartmouth.cs.reshmi.myruns;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.Toast;

import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import edu.dartmouth.cs.reshmi.myruns.registration.Registration;
import edu.dartmouth.cs.reshmi.myruns.view.SlidingTabLayout;

/**
 * This is the Main Activity that gets called when the app opens.
 * It displays a tabbed view Activity where the user can slide between StartFragment,
 * HistoryFragment and SettingsFragment.
 *
 * @author Reshmi Suresh
 */
public class MainActivity extends Activity
{
    public static String SERVER_ADDR = "https://carbide-team-130107.appspot.com/";

    private SlidingTabLayout slidingTabLayout;
    private ViewPager viewPager;
    private ArrayList<Fragment> fragments;
    private MyRunsViewPagerAdapter myViewPagerAdapter;

    private HistoryFragment mHistoryTabFragment;
    private StartFragment mStartTabFragment;
    private SettingsFragment mSettingsTabFragment;


    /**
     * The onCreate method just initializes the different fragments and adds them
     * to the ViewPagerAdapter.
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set the SlidingTabLayout and ViewPager defined in main layout.
        slidingTabLayout = (SlidingTabLayout) findViewById(R.id.tab);
        viewPager = (ViewPager) findViewById(R.id.viewpager);

        // Create a fragment list of our three main fragments in order.
        mHistoryTabFragment = new HistoryFragment();
        mSettingsTabFragment = new SettingsFragment();
        mStartTabFragment = new StartFragment();

        fragments = new ArrayList<Fragment>();
        fragments.add(mStartTabFragment);
        fragments.add(mHistoryTabFragment);
        fragments.add(mSettingsTabFragment);

        // Use our custom sublcass of FragmentPagerAdapter to bind the SlidingTabLayout and
        // ViewPager together.
        myViewPagerAdapter = new MyRunsViewPagerAdapter(this.getFragmentManager(), fragments);
        viewPager.setAdapter(myViewPagerAdapter);

        // Equally space tabs
        slidingTabLayout.setDistributeEvenly(true);
        slidingTabLayout.setViewPager(viewPager);

        // Refresh the HistoryFragment each time the page is selected
        slidingTabLayout.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                switch (position){

                    case 1:
                        mHistoryTabFragment.updateHistoryEntries();
                        break;
                    default:
                        break;
                }            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
        });
        new GcmRegistrationAsyncTask(this).execute();

    }
    class GcmRegistrationAsyncTask extends AsyncTask<Void, Void, String> {
        private Registration regService = null;
        private GoogleCloudMessaging gcm;
        private Context context;

        // TODO: change to your own sender ID to Google Developers Console project number, as per instructions above
        private static final String SENDER_ID = "398854165513";

        public GcmRegistrationAsyncTask(Context context) {
            this.context = context;
        }

        @Override
        protected String doInBackground(Void... params) {
            if (regService == null) {
                Registration.Builder builder = new Registration.Builder(AndroidHttp.newCompatibleTransport(),
                        new AndroidJsonFactory(), null)
                        // Need setRootUrl and setGoogleClientRequestInitializer only for local testing,
                        // otherwise they can be skipped
                        .setRootUrl(SERVER_ADDR+"/_ah/api/")
                        .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                            @Override
                            public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest)
                                    throws IOException {
                                abstractGoogleClientRequest.setDisableGZipContent(true);
                            }
                        });
                // end of optional local run code

                regService = builder.build();
            }

            String msg = "";
            try {
                if (gcm == null) {
                    gcm = GoogleCloudMessaging.getInstance(context);
                }
                String regId = gcm.register(SENDER_ID);
                msg = "Device registered, registration ID=" + regId;

                // You should send the registration ID to your server over HTTP,
                // so it can use GCM/HTTP or CCS to send messages to your app.
                // The request to your server should be authenticated if your app
                // is using accounts.
                regService.register(regId).execute();

            } catch (IOException ex) {
                ex.printStackTrace();
                msg = "Error: " + ex.getMessage();
            }
            return msg;
        }

        @Override
        protected void onPostExecute(String msg) {
            Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
            Logger.getLogger("REGISTRATION").log(Level.INFO, msg);
        }
    }
}
