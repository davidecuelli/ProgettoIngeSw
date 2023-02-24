package it.unibs.fp.Ristorante;

import java.util.Scanner;

public class RisMain{
	
	private static final String TITOLO = "MENU";
	private static final String [] ID = {"1 - Gestore", "2 - Addetto alla prenotazione", "3 - Magazziniere"};
	private static final String PASSGEST = "123";
	private static final String PASSPREN = "456";
	private static final String PASSMAG = "789";
	
	private static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		saluto();
		int x, n;
		
		do {
			
			menu(TITOLO, ID);
			x=input.nextInt();
			switch(x) {
				case 0:
					System.out.println("FINE.");
					break;
				case 1:
					System.out.println("Gestore");
					autenticazione(PASSGEST);
					break;
				case 2:
					System.out.println("Addetto alla prenotazione");
					autenticazione(PASSPREN);
					break;
				case 3:
					System.out.println("Magazziniere");
					autenticazione(PASSMAG);
					break;
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
	
	public static void autenticazione(String pass) {
		Scanner input2 = new Scanner(System.in);
		System.out.println("Inserisci password: ");
		String in = input2.nextLine();
		
		if(in.equals(pass)) {
			System.out.println("Accesso consentito.");
		}else {
			System.out.println("Accesso negato.");
		}
	}
	
}