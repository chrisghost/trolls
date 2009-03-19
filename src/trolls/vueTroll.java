package trolls;

import java.util.Iterator;
import java.util.List;

import org.apache.torque.TorqueException;
import org.apache.torque.util.Criteria;

import torque.generated.Arme;
import torque.generated.Objet;
import torque.generated.Potion;
import torque.generated.Sad;
import torque.generated.SadPeer;
import torque.generated.Troll;

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
		System.out.println("***** Inventaire *****");
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
		System.out.println("***** Inventaire *****");
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
	
	public void afficherEquipement() {
		
	}

}
