package project.service;

import java.util.List;

import project.beans.Admin;
import project.beans.Event;
import project.dao.EventDao;

public class EventService {

	EventDao eventDao=new EventDao();
	public void saveEvent(Event event)
	{
		eventDao.saveEvent(event);
	}
	public List<Event> getAllDetails()
	{
		List<Event> list=eventDao.getAllDetails();
		return list;
	}
}
