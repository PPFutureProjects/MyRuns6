package edu.dartmouth.cs.reshmi.myruns.data;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;

public class ExerciseEntryEntityConverter {

	public static final String ENTITY_NAME = "ExerciseEntry";

	public static ExerciseEntry fromEntity(Entity entity) {
		ExerciseEntry entry = new ExerciseEntry();
		
		entry.setId((Long)entity.getProperty("row_id"));
		entry.setInputType(((String)entity.getProperty("inputType")));
		entry.setActivityType(((String)entity.getProperty("activityType")));
		entry.setDateTime(((Long)entity.getProperty("dateTime" )).longValue());
		entry.setDuration(((Long)entity.getProperty("duration")).intValue());
		entry.setDistance((Double) entity.getProperty("distance"));
		entry.setAvgSpeed((Double)entity.getProperty("avgSpeed" ));
		entry.setCalorie( ((Long)entity.getProperty("calorie" )).intValue());
		entry.setClimb ((Double)entity.getProperty("climb"));
		entry.setHeartrate(((Long)entity.getProperty("heartrate")).intValue());
		entry.setComment((String)entity.getProperty("comment"));
		
		return entry;
	}

	public static Entity toEntity(ExerciseEntry entry) {
		Entity entity = new Entity(ENTITY_NAME, entry.mId);

		entity.setProperty("row_id", entry.getId());
		entity.setProperty("inputType", entry.getInputType());
		entity.setProperty("activityType", entry.getActivityType());
		entity.setProperty("dateTime", entry.getDateTimeInMillis());
		entity.setProperty("duration", entry.getDuration());
		entity.setProperty("distance", entry.getDistance());
		entity.setProperty("avgSpeed", entry.getAvgSpeed());
		entity.setProperty("calorie", entry.getCalorie());
		entity.setProperty("climb", entry.getClimb());
		entity.setProperty("heartrate", entry.getHeartrate());
		entity.setProperty("comment", entry.getComment());

		return entity;
	}

}
