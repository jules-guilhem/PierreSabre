package personnages;

public class Ronin extends Humain {

	private int honneur = 1;
	
	public Ronin(String nom, String boissonFavorite, int argent) {
		super(nom, boissonFavorite, argent);
	
	}
	
	public void donner(Commercant beneficiaire) {
		int don = (getArgent()*10)/100;
		perdreArgent(don);
		parler(beneficiaire.getNom()+" prend ces "+ don +" sous");
		beneficiaire.recevoir(don);
	}
	
	public void provoquer(Yakuza adversaire) {
		parler("Je t'ai retrouvé vermine, tu vas payer pour ce que tu as fait à ce pauvre marchand!");
		if (honneur*2 >= adversaire.getReputation()) {
			gagnerArgent(adversaire.getArgent());
			honneur++;
			parler("Je t’ai eu petit yakusa");
			adversaire.perdre();
		} else {
			parler("J'ai perdu contre ce yakuza, mon honneur et ma bourse en ont pris un coup");
			if (honneur>0) {
				honneur--;
			}
			adversaire.gagner(getArgent());
			perdreArgent(getArgent());
		}
	}

}
