package personnages;

public class Commercant extends Humain {

	public Commercant(String nom, int argent) {
		super(nom, "the", argent);
	}

	public int seFaireExtorquer() {
		int argentExtorquer = getArgent();
		perdreArgent(argentExtorquer);
		parler("J’ai tout perdu! Le monde est trop injuste...");
		return argentExtorquer;
	}


	public void recevoir(int argent) {
		gagnerArgent(argent);
		parler(argent+" sous ! Je te remercie généreux donateur !");
	}
	
	
}
