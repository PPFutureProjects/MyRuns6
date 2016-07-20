package edu.dartmouth.cs.reshmi.myruns;

import com.google.appengine.labs.repackaged.org.json.JSONArray;
import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONObject;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.dartmouth.cs.reshmi.myruns.data.ExerciseEntryDataSource;


public class SyncServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String jsonArrayString = req.getParameter("JSON");

        // Do not proceed if null or empty jsonArrayString
        if (jsonArrayString == null || jsonArrayString.isEmpty()) {
            return;
        }

        // First delete existing entries
        ExerciseEntryDataSource.deleteAll();
        try {
            JSONArray jsonArray = new JSONArray(jsonArrayString);

            // Add all the ExerciseEntries (represented as JSON) to the datastore.
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                ExerciseEntryDataSource.add(jsonObject);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }
}
