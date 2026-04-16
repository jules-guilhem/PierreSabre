package personnages;

public class Humain {
	private static int TAILLE_MEMOIRE = 30;
	private String nom;
	private String boissonFavorite;
	private int argent;
	protected Humain[] memoire = new Humain[TAILLE_MEMOIRE];
	protected int nbConnaissance = 0;

	public Humain(String nom, String boissonFavorite, int argent) {
		this.nom = nom;
		this.boissonFavorite = boissonFavorite;
		this.argent = argent;
	}

	public String getNom() {
		return nom;
	}

	public int getArgent() {
		return argent;
	}

	public void direBonjour() {
		parler("Bonjour ! Je m'apelle " + nom + " et j'aime boire du " + boissonFavorite);
	}

	public void boire() {
		parler("Mmmm, un bon verre de " + boissonFavorite + " ! GLOUPS !");
	}

	public void acheter(String bien, int prix) {
		if (prix > argent) {
			parler("Je n'ai plus que " + argent + " sous en poche. Je ne peux même pas m'offrir " + bien + " à " + prix
					+ " sous");
		} else {
			parler("J'ai " + argent + " sous en poche. Je vais pouvoir m'offrir " + bien + " à " + prix + " sous");
			perdreArgent(prix);
		}

	}

	protected void parler(String texte) {
		System.out.println("(" + nom + ") - " + texte);
	}

	protected void gagnerArgent(int gain) {
		argent += gain;
	}

	protected void perdreArgent(int perte) {
		argent -= perte;
	}

	public void faireConnaissanceAvec(Humain autrehumain) {
		direBonjour();
		autrehumain.repondre(this);
		memoriser(autrehumain);
	}

	private void memoriser(Humain humain) {
		if (nbConnaissance == TAILLE_MEMOIRE) {
			for (int i = 0; i < memoire.length - 1; i++) {
				Humain sauv = memoire[i + 1];
				memoire[i + 1] = memoire[i];
				memoire[i] = sauv;
			}
			memoire[nbConnaissance - 1] = humain;
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

	private void repondre(Humain humain) {
		direBonjour();
		memoriser(humain);
	}

	public void listerConnaissance() {
		String phrase = "Je connais beaucoup de monde dont : ";
		for (Humain humain : memoire) {
			if (humain != null) {
				phrase += humain.getNom() + ",";
			}
		}
		parler(phrase);
	}

}
