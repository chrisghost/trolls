package torque.generated;


import org.apache.torque.TorqueException;
import org.apache.torque.om.Persistent;

/**
 * Armes
 *
 * The skeleton for this class was autogenerated by Torque on:
 *
 * [Wed Mar 18 14:54:46 CET 2009]
 *
 * You should add additional methods to this class to meet the
 * application requirements.  This class will only be generated as
 * long as it does not already exist in the output directory.
 */
public  class Arme
    extends torque.generated.BaseArme
    implements Persistent
{
    /** Serial version */
    private static final long serialVersionUID = 1237384486901L;
    
    public void init(int id_objet) {
			try {
				this.setIdObjet(id_objet);
				
			int type = Map.hasard()%2;

			this.setNom(gen_nom(type));
			this.setBonusattaque(Map.hasard()/10);
			this.setBonusdegat(Map.hasard()/10);
			this.setBonusesquive(Map.hasard()/10);
			this.setPortee(Map.hasard()/20);
			this.setType(type);
			
			} catch (TorqueException e) {
				e.printStackTrace();
			}
    	
	}
    
    public void initDef(int id_objet) {
		try {
			this.setIdObjet(id_objet);

		this.setNom(gen_nom(1));
		this.setBonusattaque(0);
		this.setBonusdegat(0);
		this.setBonusesquive(Map.hasard()/10);
		this.setPortee(0);
		this.setType(1);
		
		} catch (TorqueException e) {
			e.printStackTrace();
		}
	
    }
    public void initAtt(int id_objet) {
		try {
			this.setIdObjet(id_objet);

		this.setNom(gen_nom(0));
		this.setBonusattaque(Map.hasard()/10);
		this.setBonusdegat(Map.hasard()/10);
		this.setBonusesquive(0);
		this.setPortee(Map.hasard()/20);
		this.setType(0);
		
		} catch (TorqueException e) {
			e.printStackTrace();
		}
	
}
    
    public static String gen_nom(int t) {
    	if(t==2)
    		t = (int) Math.round(( Math.random()*2));
    	
		int intA = (int) Math.round(( Math.random()*( 3)));
		int intB = (int) Math.round(( Math.random()*( 3)));
    	
		if( t == 0){
			String a[] = {"Hache ","Marteau ", "Epée ", "Coupe ongle "};
			String b[] = {"de la mort","du roi maudit","des plaines maléfiques", "en carton"};
			return a[intA]+b[intB];
    	}else{
			String a[] = {"Bouclier ","Targe ", "Heaume ", "Couvercle de casserole"};
			String b[] = {"d'or","maléfique","impétueux", "de mauvaise facture"};
			return a[intA]+b[intB];
    	}
		
	}

    
    public void afficher() {// id_objet | nom | bonusattaque | bonusdegat | bonusesquive | portee 
		System.out.println(this.getIdObjet() +" : "+this.getNom());
		System.out.println("* Attaque : +"+ this.getBonusattaque());
		System.out.println("* Dégats : +"+ this.getBonusdegat());
		System.out.println("* Esquive : +"+ this.getBonusesquive());
		System.out.println("* Portée : +"+ this.getPortee());
	}
}
