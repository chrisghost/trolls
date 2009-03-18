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
				
			if(	( Math.random()*( 100 - 1 + 1 ) ) + 1>50){	// random pour savoir qui commence
				this.Tour(troll1);  						// tour de troll1 puis de troll2
				this.Tour(troll2);	
			} else {
				this.Tour(troll2);
				this.Tour(troll1);	
			}
		}
		
		
		
		if (this.troll1.getVie() == 0){
			this.IG.afficher("Victoire de " + this.troll1.getNom());
		} else if (this.troll2.getVie() == 0) {
			this.IG.afficher("Victoire de " + this.troll1.getNom());
		} else {
			this.IG.afficher("Partie Terminée");
		}
	}
	
	private boolean fini(){
		return (this.troll1.getVie() == 0 || this.troll2.getVie() == 0);
	}
	
	private void Tour(Troll troll){
		if (troll.getVie() != 0){ 
			this.IG.afficher("C'est à " + troll.getNom() + " de jouer");
			this.IG.afficheInfosTroll(troll); //sa position, sa vie restante, son nombre de points d'action
			while (troll.getPa()!=0){
				int r = MoteurGraphique.menuTour();
				
			}
			
			
			
			
			
			
		}
		
	}
	
}
