package trolls;

import java.util.Iterator;
import java.util.List;

import org.apache.torque.TorqueException;
import org.apache.torque.util.Criteria;

import com.workingdogs.village.DataSetException;
import com.workingdogs.village.Record;

import torque.generated.Arme;
import torque.generated.ArmePeer;
import torque.generated.Objet;
import torque.generated.ObjetPeer;
import torque.generated.Potion;
import torque.generated.PotionPeer;
import torque.generated.Sad;
import torque.generated.SadPeer;
import torque.generated.SortPeer;
import torque.generated.Troll;
import torque.generated.TrollPeer;

public class vueTroll {
	
	Troll troll;
	
	public vueTroll(Troll t) {
		this.troll = t;
	}
	
	public String getNom() {
		return this.troll.getNom();
	}
	
	public void afficherInfos() {
		System.out.println("***** "+this.troll.getNom()+" *****");
		System.out.println("* Vie     : "+ this.troll.getVie());
		System.out.println("* Attaque : "+ this.troll.getAttaque());
		System.out.println("* Dégats  : " + this.troll.getDegats());
		System.out.println("* Esquive : "+ this.troll.getEsquive());
		System.out.println("* PA      : "+ this.troll.getPa());
		System.out.println("* X       : "+ (this.troll.getX()+1));
		System.out.println("* Y       : "+ (this.troll.getY()+1));
	}
	
	public void afficherInventaireArme() throws TorqueException {
		System.out.println("***** Inventaire Arme *****");
		Criteria c = new Criteria();
		c.add(SadPeer.NOMTROLL, this.troll.getNom());
		List inventaire = SadPeer.doSelect(c);
		
		Iterator i = inventaire.iterator();
		while (i.hasNext())
		{
			Sad record = (Sad) i.next();
			int a = record.getIdObjet();
			
			Objet obj = ObjetPeer.retrieveByPK(a);
			
			if (obj.getType().equalsIgnoreCase("arme"))
				ArmePeer.retrieveByPK(a).afficher();
		}
		
	}
	public void afficherInventairePotion() throws TorqueException, DataSetException {
		System.out.println("***** Inventaire Potion & Sorts *****");
		Criteria c = new Criteria();
		c.add(SadPeer.NOMTROLL, this.troll.getNom());
		List inventaire = SadPeer.doSelect(c);
		
		Iterator i = inventaire.iterator();
		while (i.hasNext())
		{
			Sad record = (Sad) i.next();
			int a = record.getIdObjet();
			
			Objet obj = ObjetPeer.retrieveByPK(a);
			
			if (obj.getType().equalsIgnoreCase("potion"))
				PotionPeer.retrieveByPK(a).afficher();
			else if (obj.getType().equalsIgnoreCase("sort"))
				SortPeer.retrieveByPK(a).afficher();
		}
		
	}
	
	public void afficherEquipement() throws TorqueException, DataSetException {
		System.out.println("***** Equipement *****");
//		Criteria c = new Criteria();
//		c.add("nomtroll", );
//		Troll equipement = TrollPeer.retrieveByPK(this.troll.getNom());

//		c.add("id_objet", a);
//		c.add("id_objet", p);
		ArmePeer.retrieveByPK(this.troll.getIdEquipArme()).afficher();
		ArmePeer.retrieveByPK(this.troll.getIdEquipProtect()).afficher();
	}

}
