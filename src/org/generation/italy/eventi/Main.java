package org.generation.italy.eventi;


import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/*
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
		sc.close();
		*/
		
		// milestone 3
		ProgrammEventi p = new ProgrammEventi("Eventi Musicali");
		
		Evento e2 = new Evento("Musica", LocalDate.parse("2023-12-15"), 100);
		Evento e3 = new Evento("Rap", LocalDate.parse("2023-11-18"), 150);
		Evento e4 = new Evento("Trap", LocalDate.parse("2023-09-28"), 80);
		Evento e5 = new Evento("pop", LocalDate.parse("2023-12-28"), 80);
		
		// first method
		p.addEvent(e2);
		p.addEvent(e3);
		p.addEvent(e4);
		p.addEvent(e5);
		
		
		//second method
		List<Evento> specificData = p.getEvent(LocalDate.parse("2023-09-28"));
		System.out.println(specificData);
		System.out.println("-----------------------");
		
		// System.out.println(p.getEvent(LocalDate.parse("2023-10-18")));
		// Third method
		System.out.print("number of elemnt in the list: ");
		System.out.println(p.howMany());
		System.out.println("-----------------------");
		// Fourth method
		
		System.out.println("* clearing the list *");
		System.out.print("number of element in the list: ");
		System.out.println(p.empty());
		System.out.println("-----------------------");
		
		//fifth method(comment the one above to make it work)
		List<Evento> eventi1 = p.sort();
		
		for(Evento e : eventi1) {
			System.out.println(e.getTitle() + " - " +e.getDate() + "\n");
		}
		
	}	
	
	
}
