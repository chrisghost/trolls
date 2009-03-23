package torque.generated;


import org.apache.torque.om.Persistent;

/**
 * Infos sur la carte
 *
 * The skeleton for this class was autogenerated by Torque on:
 *
 * [Thu Mar 19 13:46:25 CET 2009]
 *
 * You should add additional methods to this class to meet the
 * application requirements.  This class will only be generated as
 * long as it does not already exist in the output directory.
 */
public  class Map
    extends torque.generated.BaseMap
    implements Persistent
{
    /** Serial version */
    private static final long serialVersionUID = 1237466785498L;

	public void init(int x, int y, int nb_obj) throws Exception{
		try {
			this.setX(x);
			this.setY(y);
			this.setNom("La map!");
			this.save();
		} catch (Exception e) {
			e.printStackTrace();
		}
		int compteur = 0;
		for(int i =0; i<x;i++){
			for(int j=0;j<y;j++){
				compteur++;
				if (nb_obj>0){
					if (x*y-compteur == nb_obj || hasard() > 50){
						Objet o = new Objet();
						o.setType("arme");
						o.save();
						
						Cell c = new Cell();
						c.setX(i);
						c.setY(j);
						c.setIdObjet(o.getId());
						c.save();
						
						if(hasard()>50){
							Arme a = new Arme();
							a.init(o.getId());
							a.save();
						}else{
							Potion p = new Potion();
							p.init(o.getId());
							o.setType("potion");
							o.save();
							p.save();
						}
						nb_obj--;}
					else
						;//Pas d'objet sur cette case
				}
			}
		}
		
	}
	
	public static int hasard() {
		return (int)( Math.random()*( 100 - 1 + 1 ) ) + 1; // Nombre aléatoire entre 1 et 100
	}

}