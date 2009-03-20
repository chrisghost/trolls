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
import torque.generated.Potion;
import torque.generated.Sad;
import torque.generated.SadPeer;
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
		System.out.println("* Vie : "+ this.troll.getVie());
		System.out.println("* Attaque : "+ this.troll.getAttaque());
		System.out.println("* Dégats : " + this.troll.getDegats());
		System.out.println("* Esquive : "+ this.troll.getEsquive());
	}
	
	public void afficherInventaireArme() throws TorqueException {
		System.out.println("***** Inventaire Arme *****");
		Criteria c = new Criteria();
		c.add("nomtroll", troll.getNom());
		List inventaire = SadPeer.doSelect(c);
		
		Iterator i = inventaire.iterator();
		while (i.hasNext())
		{
			Object obj = (Object) i.next();
			if (obj instanceof Arme)
				((Arme) obj).afficher();
		}
		
	}
	public void afficherInventairePotion() throws TorqueException {
		System.out.println("***** Inventaire Potion *****");
		Criteria c = new Criteria();
		c.add("nomtroll", troll.getNom());
		List inventaire = SadPeer.doSelect(c);
		
		Iterator i = inventaire.iterator();
		while (i.hasNext())
		{
			Object obj = (Object) i.next();
			if (obj instanceof Potion)
				((Potion) obj).afficher();
		}
		
	}
	
	public void afficherEquipement() throws TorqueException, DataSetException {
		System.out.println("***** Equipement *****");
		Criteria c = new Criteria();
		c.add("nomtroll", troll.getNom());
		List equipement = TrollPeer.doSelect(c);
		
		Iterator i = equipement.iterator();
		while (i.hasNext())
		{
		    Record record = (Record) i.next();
		    int a = record.getValue("id_equip_arme").asInt();
		    int p = record.getValue("id_equip_protect").asInt();
			Criteria c2 = new Criteria();
			c.add("id_objet", a);
			c.add("id_objet", p);
			List equipement2 = ArmePeer.doSelect(c);
			Iterator i2 = equipement.iterator();
			while (i2.hasNext())
			{
				Arme arme = (Arme) i.next();
				arme.afficher();
			}
		}
	}

}
