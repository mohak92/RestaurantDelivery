package project.beans;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Event {

	@Id
	@GeneratedValue
	int evtid;
	String event;
	String eventdes;
	int date;
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	public String getEventdes() {
		return eventdes;
	}
	public void setEventdes(String eventdes) {
		this.eventdes = eventdes;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int i) {
		this.date = i;
	}
}
