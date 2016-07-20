package edu.dartmouth.cs.reshmi.myruns.data;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.Filter;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.FilterPredicate;
import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ExerciseEntryDataSource {

    private static final Logger mLogger = Logger
            .getLogger(ExerciseEntryDataSource.class.getName());
    private static final DatastoreService mDatastore = DatastoreServiceFactory
            .getDatastoreService();

    public static boolean add(JSONObject jsonObj) throws JSONException {
        ExerciseEntry entry =  new ExerciseEntry();
        entry.fromJSONObject(jsonObj);
        Entity entity = ExerciseEntryEntityConverter.toEntity(entry);
        mDatastore.put(entity);
        return true;    }




    public static boolean deleteAll() {
        boolean success = true;
        for (ExerciseEntry entry : fetchAll()) {
            success = delete(""+entry.mId);
        }

        return success;
    }

    /**
     * Delete the ExerciseEntry with the given ID from the datastore.
     *
     * Returns whether it successfully deleted or not.
     */
    public static boolean delete(String id) {
        // Setup query with ID filter
        Query query = new Query(ExerciseEntryEntityConverter.ENTITY_NAME);
        Filter filter = new FilterPredicate("row_id",
                FilterOperator.EQUAL, Long.parseLong(id));
        query.setFilter(filter);
        PreparedQuery preparedQuery = mDatastore.prepare(query);
        Entity result = preparedQuery.asSingleEntity();
        if (result == null) { return false; }
        mDatastore.delete(result.getKey());

        return true;
    }

    /**
     * Fetch all existing ExcerciseEntries from datastore.
     */
    public static List<ExerciseEntry> fetchAll() {
        List<ExerciseEntry> resultList = new ArrayList<ExerciseEntry>();

        Query query = new Query(ExerciseEntryEntityConverter.ENTITY_NAME);
        query.setFilter(null);
        PreparedQuery preparedQuery = mDatastore.prepare(query);

        for (Entity entity : preparedQuery.asIterable()) {
            resultList.add(ExerciseEntryEntityConverter.fromEntity(entity));
        }

        return resultList;
    }
}
