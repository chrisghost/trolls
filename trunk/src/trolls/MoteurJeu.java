package trolls;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.apache.torque.Torque;
import org.apache.torque.TorqueException;
import org.apache.torque.util.Criteria;

import com.workingdogs.village.DataSetException;
import com.workingdogs.village.Record;
import com.workingdogs.village.Value;

import torque.generated.BaseTrollPeer;
import torque.generated.BaseMapPeer;
import torque.generated.Map;
import torque.generated.Potion;
import torque.generated.PotionPeer;
import torque.generated.Sad;
import torque.generated.Troll;
import torque.generated.TrollPeer;

import com.workingdogs.village.Record; 


public class MoteurJeu {
	
	MoteurGraphique IG;
	Troll troll1;
	Troll troll2;
	Map carte;
	
	public MoteurJeu(MoteurGraphique IG) {
		this.IG = IG;
		
		this.IG.afficher("Bienvenue dans le jeu de duel de troll.\n" +
				"A tout moment vous pouvez quitter en éteignant l'ordinateur\n" +
				"Bon jeu");
		
		int r = this.IG.afficherMenuPrincipal();

		
		
		switch (r) {
		case 1:
			try {
					this.nouvellePartie();
				} catch (Exception e) {
					e.printStackTrace();
				}
			break;

		default:
			
			break;
		}
	}
	
	private void nouvellePartie() throws Exception {
		this.IG.afficher("=== Nouvelle partie ===");
		int x = this.IG.questionInt("Taille de l'échiquier en x :");
		int y = this.IG.questionInt("Taille de l'échiquier en y :");
		int nb_obj = this.IG.questionInt("Combien d'objets voulez vous mettre sur la carte? (<"+ (x*y+1) +") :");
		
		this.carte = new Map();
		this.carte.init(x,y,nb_obj);
		IG.affecterMap(this.carte);
		
		
		this.troll1 = new Troll();
		this.troll1.init(this.IG);
		this.IG.affecterTroll1(this.troll1);
		this.IG.afficheInfosTroll(troll1);
		
		this.troll2 = new Troll();
		this.troll2.init(this.IG);
		this.troll2.setX(carte.getX()-1);
		this.troll2.setY(carte.getY()-1);
		this.troll2.save();
		
		this.IG.affecterTroll2(this.troll2);
		this.IG.afficheInfosTroll(troll2);
		
		
		this.IG.afficherMap();

		
		this.IG.afficher("Préparation du jeu terminée, jouons!");
		this.jeu();
	}
	
	private void jeu() throws Exception {
		this.IG.afficher("Début de partie");
		
		while(!this.fini()){
				
			if(	Map.hasard() > 50){		// random pour savoir qui commence
				this.Tour(troll1);  	// tour de troll1 puis de troll2
				this.Tour(troll2);	
			} else {
				this.Tour(troll2);
				this.Tour(troll1);	
			}
			this.IG.questionSimple("Passer au tour suivant?");
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
	
	private void Tour(Troll troll) throws Exception{
		troll.setPa(6);
		try {
			troll.save();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (troll.getVie() != 0){
			this.IG.afficher("C'est à " + troll.getNom() + " de jouer");
			
			String SQL = "select maj_potions();";//Procédure stockée gérant la durée des potions
			TrollPeer.executeQuery(SQL);//execution de la ps ci dessus
			
			this.IG.afficheInfosTroll(troll); //sa position, sa vie restante, son nombre de points d'action
			while (troll.getPa()!=0){
				int r = MoteurGraphique.menuTour();
				
				if (test_action(r, troll)){
					switch (r) {
					case 1: //Déplacement du troll
						int x = this.IG.questionInt("Destination (X) ?");
						int y = this.IG.questionInt("Destination (Y) ?");
						
						SQL = "select deplacement('"+troll.getNom()+"',"+x+","+y+","+prix_action(r, troll)+")";
						List records = TrollPeer.executeQuery(SQL);
						
						for (Iterator i = records.iterator(); i.hasNext();) {
						    Record record = (Record) i.next();
						    String a = record.getValue("deplacement").asString();
						    System.out.println(a);
						}
						troll.update();
						break;
						
					case 2 : //Attaque
						SQL = "select portee('"+troll.getNom()+"')";//PS qui teste si les troll sont à portée
						List rep = TrollPeer.executeQuery(SQL);
						for (Iterator i = rep.iterator(); i.hasNext();) {
						    Record record = (Record) i.next();
						    boolean a = record.getValue("portee").asBoolean();
						    if(a){// A portée!
						    	if(troll.getNom() == this.troll1.getNom())
						    		SQL = "select combat("+troll.getNom()+","+this.troll2.getNom()+")";//PS qui va effectuer le combat!
						    	else
						    		SQL = "select combat("+troll.getNom()+","+this.troll1.getNom()+")";//PS qui va effectuer le combat!
						    	List combat = TrollPeer.executeQuery(SQL);
								for (Iterator i2 = combat.iterator(); i.hasNext();) {
								    Record record2 = (Record) i.next();
								    int resultat = record.getValue("combat").asInt();
								    if (resultat == -1)
								    	this.IG.afficher("Attaque esquivée!");
								    else
								    	this.IG.afficher("Attaque réussie : "+ resultat+ " dégat(s) infligés");
								}
						    	
						    }else
						    	this.IG.afficher("Ton troll est trop loin!");
						}
						break;
					case 3 : //Ramasser
						SQL = "select ramasser("+troll.getX()+","+troll.getY()+","+troll.getNom()+")";//PS qui teste si il y a un objet
						List id = TrollPeer.executeQuery(SQL);
						for (Iterator i = id.iterator(); i.hasNext();) {
						    Record record = (Record) i.next();
						    int a = record.getValue("ramasser").asInt();
						    if(a != 0){
						    	Sad nvO = new Sad();
						    	nvO.setIdObjet(a);
						    	nvO.setNomtroll(troll.getNom());
						    	nvO.save();
						    }else
						    	this.IG.afficher("Aucun objet sur cette case!");
						}
						break;
					case 4 : //Utiliser
							this.IG.afficherInventairePotion(troll);
							int potion = this.IG.questionInt("Quelle potion utiliser? (rentrer l'id");
							Criteria c = new Criteria();
							c.add("id_objet", potion);
							Potion p = (Potion) PotionPeer.doSelect(c);
							p.setUse(true);
							
							troll.setAttaque(troll.getAttaque()+p.getBonusattaque());
							troll.setDegats(troll.getDegats()+p.getBonusdegat());
							troll.setEsquive(troll.getEsquive()+p.getBonusesquive());
							troll.setVie(troll.getVie()+p.getBonusvie());
							troll.save();
							
							this.IG.afficheInfosTroll(troll);
						break;
					case 5 :{ //Equiper
							this.IG.afficherInventaireArme(troll);
							int arme = this.IG.questionInt("Quelle arme équiper? (rentrer l'id");
							troll.setIdEquipArme(arme);
						break;}
					
					case 6 :{
						this.IG.afficheInfosTroll(troll);
						break;}

					case 7 :{
						this.IG.afficherEquipement(troll);
						break;}

					case 8 :{
						this.IG.afficherInventaireArme(troll);
						this.IG.afficherInventairePotion(troll);
						break;}
					
					case 9 :{
						this.IG.afficherMap();
						break;}
						
					default:
						this.IG.afficher("Rentrez un entier du menu");
						break;
					}
				} else {
					this.IG.afficher("Il ne vous reste pas assez de points d'actions pour effectuer cette action");
					
				}
				
			}
			
		}
		
	}
	
	private boolean test_action(int action, Troll t) {
		switch (action) {
		case 1:
			if (this.troll1.getX() == this.troll2.getX() && this.troll1.getY() == this.troll2.getY())
				return t.getPa() >= 4;
			return t.getPa() >= 1;
		case 2:
			return t.getPa() >= 4;
		case 3:
			return t.getPa() >= 1;
		case 4:
			return t.getPa() >= 1;
		case 5:
			return t.getPa() >= 2;
		default:
			return true;
		}
	}
	
	private int prix_action(int action, Troll t) {
		switch (action) {
		case 1:
			System.out.println(this.troll1.getX()+"=="+this.troll2.getX()+"&&"+ this.troll1.getY()+"=="+this.troll2.getY()+"?");
			if (this.troll1.getX() == this.troll2.getX() && this.troll1.getY() == this.troll2.getY())
					return 4;
				return 1;
		case 2:
			return 4;
		case 3:
			return 1;
		case 4:
			return 1;
		case 5:
			return 2;
		default:
			return 0;
		}
	}
	
}
