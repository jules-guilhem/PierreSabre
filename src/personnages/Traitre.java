package personnages;

import java.util.Random;

public class Traitre extends Samourai {
	private static Random RND = new Random();
	private int niveauTraitrise = 0;

	public Traitre(String seigneur, String nom, String boissonFavorite, int argent) {
		super(seigneur, nom, boissonFavorite, argent);
	}

	@Override
	public void direBonjour() {
		super.direBonjour();
		parler("Mais je suis un traître et mon niveau de traîtrise est : " + niveauTraitrise + ". Chut !");
	}

	public void ranconner(Commercant commercant) {
		if (niveauTraitrise < 3) {
			int argentRanconner = commercant.getArgent() * 2 / 10;
			commercant.perdreArgent(argentRanconner);
			gagnerArgent(argentRanconner);
			niveauTraitrise++;
			parler("Si tu veux ma protection contre les Yakuzas, il va falloir payer ! Donne-moi " + argentRanconner
					+ " sous ou gare à toi !");
			commercant.parler("Tout de suite grand " + getNom() + ".");
		} else {
			parler("Mince je ne peux plus rançonner personne sinon un samouraï risque de me démasquer !");
		}
	}

	public void faireLeGentil() {
		if (nbConnaissance < 1) {
			parler(" Je ne peux faire ami ami avec personne car je ne connais personne ! Snif.");
		} else {
			int a = RND.nextInt(nbConnaissance);
			Humain ami = memoire[a];
			int don = getArgent() * 1 / 20;
			String nomAmi = ami.getNom();
			parler("Il faut absolument remonter ma cote de confiance. Je vais faire ami ami avec " + nomAmi + ".");
			parler("Bonjour l'ami ! Je voudrais vous aider en vous donnant " + don + " sous.");
			ami.gagnerArgent(don);
			perdreArgent(don);
			String nom = getNom();
			ami.parler("Merci "+ nom +". Vous êtes quelqu'un de bien.");
			
			if (niveauTraitrise>1) {
				niveauTraitrise--;
			}

		}
	}

}
