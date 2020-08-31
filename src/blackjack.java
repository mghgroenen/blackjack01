import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

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
		List<String> kaarten_list = new ArrayList<String>(Arrays.asList(kaarten));
		Collections.shuffle(kaarten_list);
		
		System.out.println(kaarten_list.get(0));
		kaarten_list.remove(0);	
		
		System.out.println(kaarten_list.size());
//		for(String check : kaarten_list) {
//			System.out.println(check);
//		}
	}
}