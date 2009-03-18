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
		this.troll1.init(this.IG);
		
		this.troll2 = new Troll();
		this.troll2.init(this.IG);
		
		this.IG.afficher("Préparation du jeu terminée, jouons!");
		this.jeu();
	}
	
	private void jeu() {
		this.IG.afficher("Début de partie");
		
		while(!this.fini()){
			
		}
	}
	
	private boolean fini(){
		return (this.troll1.getVie() == 0 || this.troll2.getVie() == 0);
	}
	
}
