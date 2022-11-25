package org.generation.italy.eventi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class ProgrammEventi {
	private String titolo;
	private List<Evento> eventi;
	
	// constructor
	public ProgrammEventi(String titoloNew) {
		this.titolo = titoloNew;
		this.eventi = new ArrayList<>();
	}
	// first method
	public void addEvent(Evento e) {
		eventi.add(e);
	}
	//second method
	public List<Evento> getEvent(LocalDate d){
		List<Evento> specificDateEvent = new ArrayList<>();
		
		for (int i = 0; i < eventi.size(); i++) {
			if(eventi.get(i).getDate().equals(d)) {
				specificDateEvent.add(eventi.get(i));
			}
		}
		return specificDateEvent;
	}
	
	//third method
	public int howMany() {
		return eventi.size();
	}
	// fourth method
	public int empty() {
		eventi.clear();
		return eventi.size();
	}
	
	// fifth method
	public List<Evento> sort() {
		eventi.sort(Comparator.comparing(Evento::getDate));
		return eventi;
	}
	
}
