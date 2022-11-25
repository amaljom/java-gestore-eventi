package org.generation.italy.eventi;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concerto extends Evento{
	
	private LocalTime ora;
	private BigDecimal prezzo;
	
	public Concerto(String title, LocalDate date, int avbSeats, LocalTime ora, BigDecimal prezzo) {
		super(title, date, avbSeats);
		setOra(ora);
		setPrezzo(prezzo);
	}

	public LocalTime getOra() {
		return ora;
	}

	public void setOra(LocalTime ora) {
		this.ora = ora;
	}
	
	public BigDecimal getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(BigDecimal prezzo) {
		this.prezzo = prezzo;
	}
	
	public String formatter() {
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm");
		String formattedTime = ora.format(myFormatObj);
		
		return formattedTime;
	}
	public String getPrezzoFormattato() {
		DecimalFormat f = new DecimalFormat("#,#00.00");
		return f.format(getPrezzo()) + "€";
	}
	
	@Override
	public String toString() {
		return formatter() + " - " + dateFormatter() + " - " + getTitle() + " - " + getPrezzoFormattato();
	}
	
	
}
