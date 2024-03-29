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

import torque.generated.ArmePeer;
import torque.generated.BaseTrollPeer;
import torque.generated.BaseMapPeer;
import torque.generated.Map;
import torque.generated.ObjetPeer;
import torque.generated.Potion;
import torque.generated.PotionPeer;
import torque.generated.Sad;
import torque.generated.SadPeer;
import torque.generated.Sort;
import torque.generated.SortPeer;
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
		
		this.IG.afficherBrut("Génération des objets ...");
		this.carte = new Map();
		this.carte.init(x,y,nb_obj);
		IG.affecterMap(this.carte);
		this.IG.afficherBrut("[OK]\n");

		
		
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
//			while(!this.IG.questionSimple("Passer au tour suivant?"))
//				;
		}
		
		
		
		if (this.troll1.getVie() == 0){
			this.IG.afficher("Victoire de " + this.troll1.getNom());
		} else if (this.troll2.getVie() == 0) {
			this.IG.afficher("Victoire de " + this.troll1.getNom());
		} else {
			this.IG.afficher("Partie Terminée");
		}
	}
	
	private boolean fini() throws DataSetException, TorqueException{
		String SQL = "select fini();";//Procédure stockée gérant la durée des potions
		List records = TrollPeer.executeQuery(SQL);
		
		Iterator i = records.iterator();
	    Record record = (Record) i.next();
	    String a = record.getValue("fini").asString();
	    return a.equals("true");
	}
	
	private void Tour(Troll troll) throws Exception{
		troll.setPa(6);
		try {
			troll.save();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (troll.getVie() != 0){
			this.IG.afficher("******************************************\n" +
							 "C'est à " + troll.getNom() + " de jouer\n" +
							 "******************************************\n");
			
			String SQL = "select maj_potions();";//Procédure stockée gérant la durée des potions
			TrollPeer.executeQuery(SQL);//execution de la ps ci dessus
			
			this.IG.afficheInfosTroll(troll); //sa position, sa vie restante, son nombre de points d'action
			while (troll.getPa()!=0 && !fini()){
				troll.save();
				this.troll1.update();
				this.troll2.update();
				
//				this.IG.afficherMap();
				int r = MoteurGraphique.menuTour();
				
				if (test_action(r, troll)){
					switch (r) {
					case 1: {//Déplacement du troll
						String rep = this.IG.question("Destination (d,g,h,b) ?");
						int x=0;
						int y=0;

						if (rep.equalsIgnoreCase("d")){
							x =	troll.getX()+1;
							y =	troll.getY();
						}
						else if (rep.equalsIgnoreCase("g")){
							x =	troll.getX()-1;
							y =	troll.getY();
						}
						else if (rep.equalsIgnoreCase("h")){
							x =	troll.getX();
							y =	troll.getY()-1;
						}
						else if (rep.equalsIgnoreCase("b")){
							x =	troll.getX();
							y =	troll.getY()+1;
						}
						SQL = "select deplacement('"+troll.getNom()+"',"+x+","+y+","+prix_action(r, troll)+")";
						List records = TrollPeer.executeQuery(SQL);
						
						Iterator i = records.iterator();
					    Record record = (Record) i.next();
					    String a = record.getValue("deplacement").asString();
					    if(a.equals("true"))
					    	this.IG.afficher("Déplacement réussi");
					    else
					    	this.IG.afficher("Déplacement échoué");
						troll.update();
						break;}
						
					case 2 : {//Attaque
						SQL = "select portee('"+troll.getNom()+"')";//PS qui teste si les troll sont à portée
						List rep1 = TrollPeer.executeQuery(SQL);
						for (Iterator i = rep1.iterator(); i.hasNext();) {
						    Record record = (Record) i.next();
						    boolean a = record.getValue("portee").asBoolean();
						    if(a){// A portée!
						    	if(troll.getNom() == this.troll1.getNom())
						    		SQL = "select combat('"+troll.getNom()+"','"+this.troll2.getNom()+"')";//PS qui va effectuer le combat!
						    	else
						    		SQL = "select combat('"+troll.getNom()+"','"+this.troll1.getNom()+"')";//PS qui va effectuer le combat!
						    	List combat = TrollPeer.executeQuery(SQL);
								Iterator i2 = combat.iterator();
							    Record record2 = (Record) i2.next();
							    int resultat = record2.getValue("combat").asInt();
							    if (resultat == -1)
							    	this.IG.afficher("Attaque esquivée!");
							    else
							    	this.IG.afficher("Attaque réussie : "+ resultat+ " dégat(s) infligés");
						    	
						    }else
						    	this.IG.afficher("Ton troll est trop loin!");
						}
						break;}
					case 3 : {//Ramasser
						SQL = "select ramasser("+troll.getX()+","+troll.getY()+",'"+troll.getNom()+"')";//PS qui teste si il y a un objet
						List id = TrollPeer.executeQuery(SQL);
						for (Iterator i = id.iterator(); i.hasNext();) {
						    Record record = (Record) i.next();
						    int a = record.getValue("ramasser").asInt();
						    if(a != 0){
						    	Sad nvO = new Sad();
						    	nvO.setIdObjet(a);
						    	nvO.setNomtroll(troll.getNom());
						    	nvO.save();
						    	this.IG.afficher("Vous avez ramassé ("+a+") :");
						    	if(ObjetPeer.retrieveByPK(a).getType().equalsIgnoreCase("arme"))
						    		ArmePeer.retrieveByPK(a).afficher();
						    	else if(ObjetPeer.retrieveByPK(a).getType().equalsIgnoreCase("potion"))
						    		PotionPeer.retrieveByPK(a).afficher();
						    	else if(ObjetPeer.retrieveByPK(a).getType().equalsIgnoreCase("sort"))
						    		SortPeer.retrieveByPK(a).afficher();
						    }else
						    	this.IG.afficher("Aucun objet sur cette case!");
						}
						break;}
					case 4 :{ //Utiliser
							this.IG.afficherInventairePotion(troll);
							int id = this.IG.questionInt("Quelle potion/sort utiliser? (rentrer l'id, 0 pour annuler)");
							if(id != 0){
								if (ObjetPeer.retrieveByPK(id).getType().equalsIgnoreCase("potion")){
									Potion p = PotionPeer.retrieveByPK(id);
									p.setUse(true);
									p.save();
									
									troll.setAttaque(troll.getAttaque()+p.getBonusattaque());
									troll.setDegats(troll.getDegats()+p.getBonusdegat());
									troll.setEsquive(troll.getEsquive()+p.getBonusesquive());
									troll.setVie(troll.getVie()+p.getBonusvie());
									troll.save();
							}else if (ObjetPeer.retrieveByPK(id).getType().equalsIgnoreCase("sort")){
								Sort s = SortPeer.retrieveByPK(id);
								if(troll.getNom() == this.troll1.getNom())//Troll1
									this.troll2.enleverVie(s.getDegats());
								else										// Troll2
									this.troll1.enleverVie(s.getDegats());
								SadPeer.deleteAll("sad", "id_objet", id);
								
								troll1.save();
								troll2.save();
								s.save();
								}
							}
							this.IG.afficheInfosTroll(troll);
						break;}
					case 5 :{ //Equiper
							this.IG.afficherInventaireArme(troll);
							int arme = this.IG.questionInt("Quelle arme équiper? (rentrer l'id, 0 pour annuler)");
							if(arme != 0){
								if(SadPeer.retrieveByPK(troll.getNom(), arme).toString() != null){
									SQL = "select equiper('"+troll.getNom()+"',"+arme+")";
									TrollPeer.executeQuery(SQL);
								}
								else
									this.IG.afficher("Impossible d'équiper cette arme");
								}
							troll.update();
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
					
					case 10 :{
						troll.setPa(0);
						troll.save();
						break;}
						
					default:
						this.IG.afficher("Rentrez un entier du menu");
						break;
					}
				} else {
					this.IG.afficher("Il ne vous reste pas assez de points d'actions pour effectuer cette action");
					
				}
				this.troll1.update();
				this.troll2.update();
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
