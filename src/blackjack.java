
public class blackjack {
	public static void main(String[] args) {
		String kleur [] = {"Harten", "Ruiten", "Schoppen", "Klaveren"};
		String waarde [] = {"Boer", "Vrouw", "Heer", "Aas"};
		String kaarten [] = new String[16];
		int counter = 0;
		
		for(int i=0; i<kleur.length;i++) {
			for(int j=0; j<waarde.length;i++) {
				kaarten[counter] = kleur[i] + " " + waarde[j];
				counter++;
			}
		}
		for(String check : kaarten) {
			System.out.println(check);
		}
	}
}