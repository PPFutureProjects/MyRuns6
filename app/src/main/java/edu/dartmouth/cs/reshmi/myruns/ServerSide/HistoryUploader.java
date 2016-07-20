package edu.dartmouth.cs.reshmi.myruns.ServerSide;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.dartmouth.cs.reshmi.myruns.ExerciseDataSource;
import edu.dartmouth.cs.reshmi.myruns.ExerciseEntry;
import edu.dartmouth.cs.reshmi.myruns.MainActivity;


public class HistoryUploader {
    private static final String TAG = "HistoryUploader";

    private Context mContext;

    public HistoryUploader(Context context) {
        this.mContext = context.getApplicationContext();
    }


    public void syncBackend() {
        new AsyncTask<Void, Void, String>() {

            @Override
            protected String doInBackground(Void... args) {
                Log.d(TAG, "syncing");
                // Fetch all ExerciseEntries
                ExerciseDataSource mDatastore = new ExerciseDataSource(mContext);
                try {
                    mDatastore.open();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                List<ExerciseEntry> allEntries = mDatastore.getAllEntries();

                JSONArray entriesArray = new JSONArray();
                // Create a JSONArray of all these entries
                for (ExerciseEntry entry : allEntries) {
                    entriesArray.put(entry.toJSONObject());
                }

                // Set up the params and send the data to the sync servlet.
                // Only one key, value pair - the value is the JSONArray
                String syncResult = "Successfully Synced";
                try {
                    Map<String, String> params = new HashMap<>();
                    params.put("JSON", entriesArray.toString());
                    ServerUtil.post(MainActivity.SERVER_ADDR + "/sync.do", params);
                    Log.d(TAG, "Posted sync");
                } catch (IOException e) {
                    syncResult = "Sync failed: " + e.getCause();
                }

                return syncResult;
            }

            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);

                Log.d(TAG, result);
                Toast.makeText(mContext, result, Toast.LENGTH_SHORT).show();
            }
        }.execute();
    }


}
