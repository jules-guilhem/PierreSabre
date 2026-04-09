package personnages;

public class Humain {
	private String nom;
	private String boissonFavorite;
	private int argent;
	
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
		System.out.println(parler(nom) +"Bonjour ! Je m'apelle "+ nom +" et j'aime boire du "+ boissonFavorite);
	}
	
	
	public void boire() {
		System.out.println(parler(nom) +"Mmmm, un bon verre de "+ boissonFavorite +" ! GLOUPS !");
	}
	
	public void acheter(String bien, int prix) {
		if (prix>argent) {
			System.out.println(parler(nom) +"Je n'ai plus que "+ argent +" sous en poche. Je ne peux même pas m'offrir "+ bien +" à "+ prix +" sous");
		} else {
			System.out.println(parler(nom) +"J'ai "+ argent +" sous en poche. Je vais pouvoir m'offrir "+ bien +" à "+ prix +" sous");
			perdreArgent(prix);
		}
		
	}
	
	
	private String parler(String texte) {
		return "("+ texte +") - ";
	}
	
	private void gagnerArgent(int gain) {
		argent += gain;
	}
	
	private void perdreArgent(int perte) {
		argent -= perte;
	}
	
	
	
	
}
