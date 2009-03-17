package trolls;

import torque.generated.Troll;

public class MoteurJeu {
	
	MoteurGraphique IG;
	Troll troll1;
	Troll troll2;
	Map carte;
	
	public MoteurJeu(MoteurGraphique IG) {
		this.IG = IG;
		
		this.IG.afficher("Bienvenue dans le jeu de duel de troll." +
				"A tout moment vous pouvez quitter en éteignant l'ordinateur" +
				"Bon jeu");
		int r = this.IG.afficherMenuPrincipal();
		
		switch (r) {
		case 1:
			this.nouvellePartie();
			break;

		default:
			break;
		}
	}
	
	private void nouvellePartie() {
		this.IG.afficher("=== Nouvelle partie ===");
		int x = this.IG.questionInt("Taille de l'échiquier en x :");
		int y = this.IG.questionInt("Taille de l'échiquier en y :");
		int nb_obj = this.IG.questionInt("Combien d'objets voulez vous mettre sur la carte? (<"+ (x*y+1) +") :");
		this.carte = new Map(x,y,nb_obj);
		
		this.troll1 = new Troll();
		this.troll1.setNom(this.IG.question("Nom du premier troll:"));
		boolean incomplet = true;
		while (incomplet){
			this.IG.afficher("Affectation des points de " + this.troll1.getNom());
//			TO-DO : A DEPLACER dans un méthode du troll (ex: Init(IG) ) après régénération du code torque
//			  attaque, dégâts, esquive, point de vie
			this.troll1.setAttaque(this.IG.questionInt("Nombre de points d'attaque : "));
			this.troll1.setDegats(this.IG.questionInt("Nombre de points de dégâts : "));
			this.troll1.setEsquive(this.IG.questionInt("Nombre de points d'esquive : "));
			this.troll1.setVie(this.IG.questionInt("Nombre de points de vie : "));
		}
		
		this.troll2 = new Troll();
		this.troll2.setNom(this.IG.question("Nom du second troll:"));
	}
	
}
