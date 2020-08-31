import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class blackjack {
	public static void main(String[] args) {

		//	Aanmaken kaarten
		String kleur [] = {"harten", "ruiten", "schoppen", "klaveren"};
		String waarde [] = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "boer", "vrouw", "heer", "aas"};
		String kaarten [] = new String[52];
		int counter = 0;
		
		for(int i=0; i<kleur.length;i++) {
			for(int j=0; j<waarde.length;j++) {
				kaarten[counter] = kleur[i] + " " + waarde[j];
				counter++;
			}
		}

		//Schudden van kaarten
		List<String> kaarten_list = new ArrayList<String>(Arrays.asList(kaarten));
		Collections.shuffle(kaarten_list);
//		System.out.println("Geschudde kaarten: ");
//		for(String check : kaarten_list) {
//			System.out.println("- " + check);
//		}	
			
		//	Blackjack-loop
		int totaal = 0;
		List<String> gespeelde_kaarten = new ArrayList<String>();
		
		while (totaal < 21) {
			//	Speler input
			System.out.println("--- Kaarten over: " + kaarten_list.size() + " ---    (Nieuwe kaart: k | Pas: p | Stop spel: q)");
			Scanner inputObj = new Scanner(System.in);
			String input = inputObj.nextLine();
			
			//Controleren input
			if (input.equals("k")==true) {
				//Kaart toevoegen aan lijst met gespeelde kaarten
				
				
				// Waarde optellen bij totaal				
				if (kaarten_list.get(0).matches(".*\\b2\\b.*")==true) {
					totaal += 2;
				} else if (kaarten_list.get(0).matches(".*\\b3\\b.*")==true) {
					totaal += 3;
				} else if (kaarten_list.get(0).matches(".*\\b4\\b.*")==true) {
					totaal += 4;
				} else if (kaarten_list.get(0).matches(".*\\b5\\b.*")==true) {
					totaal += 5;
				} else if (kaarten_list.get(0).matches(".*\\b6\\b.*")==true) {
					totaal += 6;
				} else if (kaarten_list.get(0).matches(".*\\b7\\b.*")==true) {
					totaal += 7;
				} else if (kaarten_list.get(0).matches(".*\\b8\\b.*")==true) {
					totaal += 8;
				} else if (kaarten_list.get(0).matches(".*\\b9\\b.*")==true) {
					totaal += 9;
				} else if (kaarten_list.get(0).matches(".*\\b10\\b.*")==true) {
					totaal += 10;
				} else if (kaarten_list.get(0).matches(".*\\bboer\\b.*")==true) {
					totaal += 10;
				} else if (kaarten_list.get(0).matches(".*\\bvrouw\\b.*")==true) {
					totaal += 10;
				} else if (kaarten_list.get(0).matches(".*\\bheer\\b.*")==true) {
					totaal += 10;
				} else if (kaarten_list.get(0).matches(".*\\baas\\b.*")==true) {
					totaal += 11;
				}
				
				//	Kaart en totaal van speler tonen
				System.out.println("Je kaart is de: " + kaarten_list.get(0) + ".");
				System.out.println("Totaal: " + totaal);
				
				//	Kaart verplaatsen naar gespeelde lijst
				gespeelde_kaarten.add(kaarten_list.get(0));
				kaarten_list.remove(0);
				
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
			System.out.println("--- BLACKJACK! ---");
		} else if (totaal > 21) {
			System.out.println("Je hebt verloren!");
		} else if (totaal < 21) {
			;
		}
		
		// Gekregen kaarten tonen
		System.out.println("Gekregen kaarten: ");
		for(String check : gespeelde_kaarten) {
			System.out.println("- " + check);
		}	
	}
}