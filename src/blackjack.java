import java.util.Arrays;
import java.util.Collections;
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
		
		//	Print geschudde kaarten
//		for(Kaart check : kaarten) {
//		System.out.println(check.naam);
//		}	
		
		//	Blackjack-loop
		int totaal = 0;
		int bank = 0;
		int game_counter = 0;
		
		//Inzetten
		System.out.println("Welkom aan de tafel. Hoeveel euro zet je in?");
		wacht();
		Scanner inzetObj = new Scanner(System.in);
		int inzet = inzetObj.nextInt();
		wacht();
				
		System.out.println("- Kaart 1: " + kaarten[game_counter].naam + ".");
		kaarten[game_counter].aan_wie = "speler";
		totaal += kaarten[game_counter].waarde;
		game_counter++;
		
		// Kaart 2 uitdelen (met dubbele-aas check)
		wacht();
		System.out.println("- Kaart 2: " + kaarten[game_counter].naam + ".");
		if (totaal == 11 && kaarten[game_counter].plaatje.equals("aas")) {
			totaal ++;
		} else {
			totaal += kaarten[game_counter].waarde;
		}		
		kaarten[game_counter].aan_wie = "speler";
		game_counter++;
		wacht();
		
		// Kaart bank uitdelen
		System.out.println(" ");
		System.out.println("- Bank: " + kaarten[game_counter].naam + ".");
		bank += kaarten[game_counter].waarde;
		kaarten[game_counter].aan_wie = "bank";
		game_counter++;
		wacht();
		System.out.println("[Speler: " + totaal + "][Bank: " + bank + "]");
		
		// Speler loop
		while (totaal < 21) {
			//	Speler input
			wacht();
			System.out.println("====== (Nieuwe kaart: k | Pas: p | Stop spel: q) ======");
			Scanner inputObj = new Scanner(System.in);
			String input = inputObj.nextLine();
			
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
				
				System.out.println("[Speler: " + totaal + "][Bank: " + bank + "]");
				kaarten[game_counter].aan_wie = "speler";
				game_counter++;
				
			//	Passen
			} else if (input.equals("p")==true) {
				System.out.println("Je hebt gepast.");
				System.out.println("[Speler: " + totaal + "][Bank: " + bank + "]");
				break;
			
			// Afsluiten
			} else if (input.equals("q")==true) {
				System.out.println("Einde spel.");
				System.exit(0);
			
			//Foutieve input
			} else {
				System.out.println("Input is niet k, p, of q.");
				System.out.println("[Speler: " + totaal + "][Bank: " + bank + "]");
			}
		}
		
		// Bank loop
		wacht();
		if (totaal < 22) {
			System.out.println("-----------------------------------------------------------------------");
			System.out.println("De bank is nu aan de beurt.");
			while (bank < 17) {
				wacht();
				wacht();
				wacht();
				System.out.println("De bank trekt een: " + kaarten[game_counter].naam + ".");
				if (kaarten[game_counter].plaatje.equals("aas")==true) {
					if (bank > 6) {
						totaal += 1;
					} else {
						bank += kaarten[game_counter].waarde;
					}
				} else {
					bank += kaarten[game_counter].waarde;
				}
				kaarten[game_counter].aan_wie = "bank";
				game_counter++;
				wacht();
				System.out.println("[Speler: " + totaal + "][Bank: " + bank + "]");
			}
		}
		
		// Uitslag speler
		wacht();
		if (totaal == 21 && bank != 21) {
			System.out.println("---< BLACKJACK! >---");
			wacht();
			System.out.println("Je wint: " + (1.5*inzet) + " euro.");
		} else if (totaal > 21) {
			System.out.println("Helaas. Je hebt " + inzet + " euro verloren!");
		} else if (totaal > bank) {
			System.out.println("Gefeliciteerd! Je wint: " + inzet + " euro.");
		} else if (totaal < bank && bank < 22) {
			System.out.println("Helaas. Je hebt " + inzet + " euro verloren!");
		} else if (totaal < bank && bank > 21) {
			System.out.println("Gefeliciteerd! Je wint: " + inzet + " euro.");	
		} else if (totaal == bank) {
			System.out.println("Gelijkspel. Je krijgt je inzet terug.");
		}
		
		//	Gespeelde kaarten tonen
		wacht();
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("Gespeelde kaarten: ");
		wacht();
		for(int i=0; i<game_counter;i++) {
			wacht();
			System.out.println("- " + kaarten[i].naam + "		(" + kaarten[i].aan_wie + ")");
		}
		System.exit(0);
	}
	static class Kaart {
		String naam;
		String kleur;
		String plaatje;
		String aan_wie;
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
	public static void wacht() {
		try {
		    Thread.sleep(1000);                 
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
	}
}