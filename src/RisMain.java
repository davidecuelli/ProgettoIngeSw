package it.unibs.fp.Ristorante;

import java.util.*;
import java.io.*;

public class RisMain{
	
	private static final String TITOLO = "MENU";
	private static final String [] ID = {"1 - Gestore", "2 - Addetto alla prenotazione", "3 - Magazziniere"};
	private static final String [] ID2 = {"1 - Aggiungi menu", "2 - Aggiungi piatto", "3 - Visualizza clienti"};
	private static final String [] ID3 = {"1 - Gestore", "2 - Addetto alla prenotazione", "3 - Magazziniere"};
	private static final String [] ID4 = {"1 - Gestore", "2 - Addetto alla prenotazione", "3 - Magazziniere"};
	
	
	private static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException {
		saluto();
		int x, n = 0;
		
		do {
			
			menu(TITOLO, ID);
			x=input.nextInt();
			switch(x) {
				case 0:
					System.out.println("FINE.");
					break;
				case 1:
					System.out.println("Gestore");
					if(autenticazione("Gestore")){
						do {
							menu(TITOLO, ID2);
							n=input.nextInt();
						}while(n!=0);
					}
					break;
				case 2:
					System.out.println("Addetto alla prenotazione");
					
					if(autenticazione("Addetto alla prenotazione")){
						do {
							menu(TITOLO, ID2);
							n=input.nextInt();
						}while(n!=0);
					}
					break;
				case 3:
					System.out.println("Magazziniere");
					
					if(autenticazione("Magazziniere")){
						do {
							menu(TITOLO, ID2);
							n=input.nextInt();
						}while(n!=0);
					}
			}
		}while(x!=0);
		
	}
	
	public static void saluto() {
		System.out.println("**********************************");
        System.out.println("*           Benvenuto!           *");
        System.out.println("**********************************");
	}
	
	public static void menu(String titolo, String[] id) {
		
		System.out.println("--------------");
        System.out.println("-    "+ titolo +"    -");
        System.out.println("--------------");
        
		System.out.println("SCEGLI UN OPZIONE");
		for(String nomi: id) {
			System.out.println(nomi);
		}
		System.out.println("0 - Exit");
	}
	
	public static boolean autenticazione(String username) throws IOException {
		Map<String, String> credentials = readCredentials("C:\\Users\\Kiri\\eclipse-workspace\\Ristorante\\src\\it\\unibs\\fp\\Ristorante\\pass");
		Scanner input2 = new Scanner(System.in);
		System.out.println("Inserisci password: ");
		String pass = input2.nextLine();
		
		if (credentials.containsKey(username) && credentials.get(username).equals(pass)) {
		    System.out.println("Accesso consentito.");
		    return true;
		} else {
			System.out.println("Accesso negato.");
			return false;
		}
	}
	
	public static Map<String, String> readCredentials(String filename) throws IOException {
	    Map<String, String> credentials = new HashMap<>();
	    BufferedReader reader = new BufferedReader(new FileReader(filename));
	    String line = reader.readLine();
	    while (line != null) {
	        String[] parts = line.split("=");
	        credentials.put(parts[0], parts[1]);
	        line = reader.readLine();
	    }
	    reader.close();
	    return credentials;
	}
	
}