package org.generation.italy.eventi;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

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
	public void setDate(LocalDate date){
		LocalDate today = LocalDate.now();
		
		boolean isBefore = today.isBefore(date);
		if(isBefore) {
			this.date = date;
		}else {
			while(!today.isBefore(date)) {
				Scanner s = new Scanner(System.in);
				System.out.println("inserisci una data valida: ");
				String data = s.nextLine();
				LocalDate dateNew = LocalDate.parse(data); 
				if(today.isBefore(dateNew)) {
					date = dateNew;
				}
			}
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
	public String prenota() throws Exception {
		LocalDate today = LocalDate.now();
		LocalDate eventDate = date;
		
		boolean isBefore = today.isBefore(eventDate);
		if(isBefore && availebeleSeat()) {
			this.bookedSeats++;
			return "un posto è stato prenotato";
		} else if(today.isAfter(eventDate)) {
			throw new Exception("L'evento ha gia avuto luogo");
		} else if(!availebeleSeat()) {
			throw new Exception("Non ci sono piu posti disponibili");
		}
		return "-----------------";
	}

	private boolean availebeleSeat() {
		if(getAvbSeats() - getBookedSeats() > 0 ) {
			return true;
		}
		return false;
	}
	public int availebeleSeatPublic() {
		
			return getAvbSeats() - getBookedSeats();
	}
	// Second method
	public String disdici() throws Exception{
		LocalDate today = LocalDate.now();
		LocalDate pastDate = date;
		
		boolean isBefore = today.isBefore(pastDate);
		if(isBefore && getBookedSeats() > 0) {
			this.bookedSeats--;
			return "prenotazione cancellata";
		}else if(getBookedSeats() == 0) {
			throw new Exception("Non ci sono prenotazione da eliminare");
		}
		return "----------------";
		
	}	
	
	public String dateFormatter() {
		int year = date.getYear();
		int month = date.getMonthValue();
		int day = date.getDayOfMonth();
		
		return year + "/" +  month + "/" + day;
	}
	// toString
	
	@Override
	public String toString() {
		return "The event: " + getTitle() + "will take place on: " + getDate();
	}
}