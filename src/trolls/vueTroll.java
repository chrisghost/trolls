package trolls;

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
	
	public void afficherInventaire() {
		
	}
	
	public void afficherEquipement() {
		
	}

}
