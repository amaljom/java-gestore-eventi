package org.generation.italy.eventi;


import java.time.LocalDate;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Benvento utente, inserisci i dettagli di un nuovo evento!");
		System.out.print("Inserisci la data dell'evento nell' ordine 'yyyy-MM-dd': ");
		String date = sc.nextLine();
		// SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");2
		LocalDate date2 = LocalDate.parse(date); 
		
		System.out.println(date2);
		
		System.out.print("Come vuoi chiamare l'evento? ");
		String title = sc.nextLine();
		
		System.out.print("Quanti posti saranno disponibili? ");
		int avbSeats = sc.nextInt();
		// instanziamento evento
		Evento e1 = new Evento(title, date2, avbSeats);
		/*
		try {
			System.out.println("Quanti posti vorresti prenotare? ");
			int seatToBook = sc.nextInt();
			int i = 0;
			if(seatToBook > 0) {
				for (i = 0; i < seatToBook; i++) {
					System.out.println(e1.prenota());
				}
				System.out.println("hai prenotato " + i + " posti");
			}else
				System.out.println("inserire un numero valido di posti da prenotare!");
		}catch(Exception e) {
			
			System.err.println(e.getMessage());
		}
		*/
		System.out.println("----------------------------");
		System.out.println("i posti totali sono: " + e1.getBookedSeats() + "\nI posti disponibili ancora sono: " + e1.availebeleSeatPublic());
		
		//--------------------------------------------------
		
		try {
			System.out.println("Quanti posti vorresti prenotare? ");
			int seatToBook = sc.nextInt();
			int i = 0;
			if(seatToBook > 0) {
				for (i = 0; i < seatToBook; i++) {
					System.out.println(e1.prenota());
				}
				System.out.println("hai prenotato " + i + " posti");
			}else
				System.out.println("inserire un numero valido di posti da prenotare!");
			
			// *******
			System.out.println("vorresti disdire dei posti? \n si-->1\n no-->0");
			int choice = sc.nextInt();
			
			
			if(choice == 1) {
				System.out.print("quanto posti vorresti vorresti disdire? ");
				int n = sc.nextInt();
				if(n > 0 && e1.getBookedSeats() >= n) {
					for (i = 0; i < n; i++) {
						System.out.println(e1.disdici());
					}
					System.out.println("hai disdetto " + i + " posti");
				}
				else {
					System.out.println("inserisci un numero valido");
				}
				
			}
		}catch(Exception e) {
			
			System.err.println(e.getMessage());
		}
		System.out.println("----------------------------");
		System.out.println("i posti prenotati sono: " + e1.getBookedSeats() + "\nI posti disponibili ancora sono: " + e1.availebeleSeatPublic());
		
	}	
	
}
