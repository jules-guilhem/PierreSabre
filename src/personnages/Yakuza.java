package personnages;

public class Yakuza extends Humain {
	private String clan;
	private int reputation = 0;

	public Yakuza(String nom,String boissonFavorite, int argent, String clan) {
		super(nom,boissonFavorite,argent);
		this.clan = clan;
	}
	
	public void  extorquer(Commercant victime) {
		parler("Tiens, tiens, ne serait-ce pas un faible marchand qui passe par là ?");
		parler(victime.getNom()+", si tu tiens à la vie donne moi ta bourse !");
		int argentVole = victime.seFaireExtorquer();
		gagnerArgent(argentVole);
		parler("J’ai piqué les "+ argentVole +" sous de Marco, ce qui me fait "+ getArgent() +" sous dans ma poche. Hi ! Hi !");
		reputation++;
	}

	public int getReputation() {
		return reputation;
	}
	
	protected void gagner(int gain) {
		gagnerArgent(gain);
		reputation++;
		parler("Ce ronin pensait vraiment battre "+ getNom() +" du clan de "+ clan +" ? Je l'ai dépouillé de ses "+ gain +" sous.");
	}
	
	protected void perdre() {
		int argentPerdu = getArgent();
		perdreArgent(argentPerdu);
		if (reputation>0) {
			reputation--;
		}
		parler("J’ai perdu mon duel et mes "+ argentPerdu +" sous, snif... J'ai déshonoré le clan de "+ clan);
	}

}
