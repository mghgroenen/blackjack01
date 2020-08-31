import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class blackjack {
	public static void main(String[] args) {
		String kleur [] = {"harten", "ruiten", "schoppen", "klaveren"};
		String waarde [] = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "boer", "vrouw", "heer", "aas"};		
		Kaart [] kaarten = new Kaart [52];
		
		int card_counter = 0;
		for(int i=0; i<kleur.length;i++) {
			for(int j=0; j<waarde.length;j++) {
				kaarten[card_counter] = new Kaart(kleur[i], waarde[j]);
				card_counter++;
			}
		}
		Collections.shuffle(Arrays.asList(kaarten));
		
//		for(Kaart check : kaarten) {
//		System.out.println(check.naam);
//		}	
		
		//	Blackjack-loop
		int totaal = 0;
		int game_counter = 0;
		
		//Kaart 1 uitdelen
		System.out.println("- Kaart 1: " + kaarten[game_counter].naam + ".");
		totaal += kaarten[game_counter].waarde;
		game_counter++;
		
		// Kaart 2 uitdelen (met dubbele-aas check)
		System.out.println("- Kaart 2: " + kaarten[game_counter].naam + ".");
		if (totaal == 11 && kaarten[game_counter].plaatje.equals("aas")) {
			totaal ++;
		} else {
			totaal += kaarten[game_counter].waarde;
		}		
		game_counter++;
		System.out.println("[Totaal: " + totaal + "]");
		
		while (totaal < 21) {
			//	Speler input
			System.out.println("--- Kaarten over: " + (kaarten.length - game_counter) + " ---    (Nieuwe kaart: k | Pas: p | Stop spel: q)");
			Scanner inputObj = new Scanner(System.in);
			String input = inputObj.nextLine();
			inputObj.close();
			
			//Controleren input
			if (input.equals("k")==true) {				
				//	Kaart tonen en bij totaal optellen
				System.out.println("Je kaart is de: " + kaarten[game_counter].naam + ".");
				
				// Aas check (1 of 11)
				if (kaarten[game_counter].plaatje.equals("aas")==true) {
					if (totaal > 10) {
						totaal += 1;
					} else {
						totaal += kaarten[game_counter].waarde;
					}
				} else {
					totaal += kaarten[game_counter].waarde;
				}
				
				System.out.println("[Totaal: " + totaal + "]");
				game_counter++;
				
			//	Passen
			} else if (input.equals("p")==true) {
				System.out.println("Je hebt gepast. Totaal: " + totaal);
				break;
			
			// Afsluiten
			} else if (input.equals("q")==true) {
				System.out.println("Einde spel.");
				System.exit(0);
			
			//Foutieve input
			} else {
				System.out.println("Input is niet k, p, of q.");
				System.out.println("Totaal: " + totaal);
			}
		}
		// Uitslag tonen
		if (totaal == 21) {
			System.out.println("---< BLACKJACK! >---");
		} else if (totaal > 21) {
			System.out.println("Je hebt verloren!");
		} else if (totaal < 21) {
			;
			}
		
		//	Getrokken kaarten tonen
		System.out.println("Getrokken kaarten: ");
		for(int i=0; i<game_counter;i++) {
			System.out.println("- " + kaarten[i].naam);
		}
		System.exit(0);
	}
	static class Kaart {
		String naam;
		String kleur;
		String plaatje;
		int waarde;
		
		Kaart(String kleur, String plaatje) {
			this.naam = (kleur + " " + plaatje);
			this.kleur = kleur;
			this.plaatje = plaatje;
			if (plaatje.equals("2")==true) {
				waarde = 2;
			} else if (plaatje.equals("3")==true) {
				waarde = 3;
			} else if (plaatje.equals("4")==true) {
				waarde = 4;
			} else if (plaatje.equals("5")==true) {
				waarde = 5;
			} else if (plaatje.equals("6")==true) {
				waarde = 6;
			} else if (plaatje.equals("7")==true) {
				waarde = 7;
			} else if (plaatje.equals("8")==true) {
				waarde = 8;
			} else if (plaatje.equals("9")==true) {
				waarde = 9;
			} else if (plaatje.equals("10")==true) {
				waarde = 10;
			} else if (plaatje.equals("boer")==true) {
				waarde = 10;
			} else if (plaatje.equals("vrouw")==true) {
				waarde = 10;
			} else if (plaatje.equals("heer")==true) {
				waarde = 10;
			} else if (plaatje.equals("aas")==true) {
				waarde = 11;
			}
		}
	}
}