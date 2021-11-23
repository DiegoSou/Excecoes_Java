package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	
	private Integer roomNumber;
	private Date checkin;
	private Date checkout;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation() {
		
	}
	
	public Reservation(Integer roomNumber, Date checkin, Date checkout) {
		this.roomNumber = roomNumber;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckin() {
		return checkin;
	}


	public Date getCheckout() {
		return checkout;
	}

	public long duration() {
		long dif = checkout.getTime() - checkin.getTime();
		return TimeUnit.DAYS.convert(dif, TimeUnit.MILLISECONDS);
	}
	
	public String updateDates(Date checkin, Date checkout) {
		Date now = new Date();
		if(checkin.before(now) || checkout.before(now)) {
			return "Reservation dates for update must be future dates";
		}
		
		if(!checkout.after(checkin)) {
			return "Reservation dates for update must be future dates";
		}
		
		this.checkin = checkin;
		this.checkout = checkout;
		return null;
	}
 
	@Override
	public String toString() {
		return "Room " 
				+ roomNumber 
				+ ", Check-in: "
				+ sdf.format(checkin)
				+ ", Check-out: "
				+ sdf.format(checkout)
				+ ", Duration: "
				+ duration()
				+ " nights";
	}
}
