import java.util.Arrays;
import java.util.Collections;

public class blackjack {
	public static void main(String[] args) {
		String kleur [] = {"Harten", "Ruiten", "Schoppen", "Klaveren"};
		String waarde [] = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Boer", "Vrouw", "Heer", "Aas"};
		String kaarten [] = new String[52];
		int counter = 0;
		
		for(int i=0; i<kleur.length;i++) {
			for(int j=0; j<waarde.length;j++) {
				kaarten[counter] = kleur[i] + " " + waarde[j];
				counter++;
			}
		}
		Collections.shuffle(Arrays.asList(kaarten));
		for(String check : kaarten) {
			System.out.println(check);
		}
	}
}