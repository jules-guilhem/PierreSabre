package personnages;

import java.util.Random;

public class GrandMere extends Humain {
	
	private static int TAILLE_MEMOIRE = 5;
	private static Random RND = new Random();
	
	Humain[] memoire = new Humain[TAILLE_MEMOIRE];
	private int nbConnaissance = 0;
	
	
	public GrandMere(String nom, int argent) {
		super(nom,"tisane",argent);
	}
	
	
	
	protected void memoriser(Humain humain) {
		if (nbConnaissance == TAILLE_MEMOIRE) {
			parler("Oh ma tête ! Je ne peux plus retenir le nom d'une personne supplémentaire !");
		} else {
			if (!in(humain, memoire)) {
				memoire[nbConnaissance] = humain;
				nbConnaissance++;
			}
		}
	}

	private Boolean in(Humain humain, Humain[] t) {
		Boolean status = false;
		Humain test = null;
		int i = 0;
		while (humain != test && i < TAILLE_MEMOIRE) {
			test = t[i];
			if (test == humain) {
				status = true;
			}
			i++;
		}
		return status;
	}
	
	
	
	private enum TypeHumain {
		HUMAIN("un habitant"),GRANDMERE("une grand-mère"), COMMERCANT("un commercant"), YAKUZA("un yakuza"), RONIN("un ronin"), SAMOURAI("un samourai");
		
		private String nom;
		
		private TypeHumain(String nom) {
			this.nom = nom;
		}
		
		public String getNom() {
			return nom;
		}
	}
	
	public void ragoter() {
		for (Humain humain : memoire) {
			if (humain instanceof Traitre) {
				parler("Je sais que "+ humain.getNom() +" est un traître. Petit chenapan !");
			} else {
				String type = humainHasard();
				parler("Je crois que "+ humain.getNom() +" est "+ type);
			}
		}
		
	}
	
	
	
	
	private String humainHasard() {
		TypeHumain[] types = TypeHumain.values();
		int a = RND.nextInt(nbConnaissance);
		return types[a].getNom();
	}

}
