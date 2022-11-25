package org.generation.italy.eventi;

import java.time.LocalDate;

public class Evento {
	//Properties
	private String title;
	private LocalDate date;
	private int avbSeats;
	private int bookedSeats;
	//Constructor
	public Evento(String title, LocalDate date, int avbSeats) {
		setTitle(title);
		setDate(date);
		SetAvbSeats(avbSeats);
		this.bookedSeats = 0;
	}
	
	//Title
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	//Date
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		LocalDate today = LocalDate.now();
		LocalDate pastDate = date;
		
		boolean isBefore = today.isBefore(pastDate);
		if(isBefore) {
			this.date = date;
		}
	}
	//Seats
	public int getAvbSeats() {
		return avbSeats;
	}
	private void SetAvbSeats(int avbSeats) {
		if(avbSeats > 0) {
			this.avbSeats = avbSeats;
		}
	}
	public int getBookedSeats() {
		return bookedSeats;
	}
	
	
	//Public methods
	//First method
	public String prenota() {
		LocalDate today = LocalDate.now();
		LocalDate pastDate = date;
		
		boolean isBefore = today.isBefore(pastDate);
		if(isBefore && availebeleSeat()) {
			this.bookedSeats++;
			return "seat has been booked";
		} else {
			return "cannot book this seat";
		}
	}

	private boolean availebeleSeat() {
		if(getAvbSeats() - getBookedSeats() > 0 ) {
			return true;
		}
		return false;
	}
	
	// Second method
	public String disdici() {
		LocalDate today = LocalDate.now();
		LocalDate pastDate = date;
		
		boolean isAfter = today.isAfter(pastDate);
		if(isAfter && getBookedSeats() > 0) {
			this.bookedSeats--;
			return "your reservation has been deleted";
		}else {
			return "error occured, cannot delete this reservation";
		}
		
	}	
	
	// toString
	
	@Override
	public String toString() {
		return "The event: " + getTitle() + "will take place on: " + getDate();
	}
}