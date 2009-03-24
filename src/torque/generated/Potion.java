package torque.generated;


import org.apache.torque.TorqueException;
import org.apache.torque.om.Persistent;

/**
 * Potions
 *
 * The skeleton for this class was autogenerated by Torque on:
 *
 * [Wed Mar 18 14:54:46 CET 2009]
 *
 * You should add additional methods to this class to meet the
 * application requirements.  This class will only be generated as
 * long as it does not already exist in the output directory.
 */
public  class Potion
    extends torque.generated.BasePotion
    implements Persistent
{
    /** Serial version */
    private static final long serialVersionUID = 1237384486901L;
    public void init(int id_objet) {

			try {
				this.setIdObjet(id_objet);

			switch ((int) Math.round(( Math.random()*( 3)))) {
			case 0:
				this.setBonusattaque(Map.hasard()/10);
				this.setBonusdegat(0);
				this.setBonusesquive(0);
				this.setBonusvie(0);
				this.setNom("Potion d'attaque");
				break;
				
			case 1:
				this.setBonusattaque(0);
				this.setBonusdegat(Map.hasard()/10);
				this.setBonusesquive(0);
				this.setBonusvie(0);
				this.setNom("Potion de puissance");
				break;
			case 2:
				this.setBonusattaque(0);
				this.setBonusesquive(Map.hasard()/10);
				this.setBonusdegat(0);
				this.setNom("Potion de rapidité");
				break;
			case 3:
				this.setBonusattaque(0);
				this.setBonusvie(Map.hasard()/5);
				this.setBonusesquive(0);
				this.setBonusdegat(0);
				this.setNom("Potion de santé");
				break;
			}
			
			this.setDuree(Map.hasard()/10);
			this.setUse(false);
			
			} catch (TorqueException e) {
				e.printStackTrace();
			}
   	
	}
    
    public void afficher() {// id_objet | nom | bonusattaque | bonusdegat | bonusesquive | portee 
		System.out.println(this.getIdObjet() +" : "+this.getNom());
		System.out.println("* Attaque : +"+ this.getBonusattaque());
		System.out.println("* Dégats : +"+ this.getBonusdegat());
		System.out.println("* Esquive : +"+ this.getBonusesquive());
		System.out.println("* Vie : +"+ this.getBonusvie());
		System.out.println("* Durée : "+ this.getDuree());
		System.out.print("* Utilisée : ");
		if (this.getUse() == true)
			System.out.println("Oui");
		else
			System.out.println("Non");
	}
}