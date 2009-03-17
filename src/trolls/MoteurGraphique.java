package trolls;

import torque.generated.Troll;

public class MoteurGraphique {
	
	Menu menu;
	vueTroll vueTroll1;
	vueTroll vueTroll2;
	vueMap vueMap;
	
	public MoteurGraphique(Troll t1, Troll t2, Map m) {
		this.menu = new Menu();
		this.vueTroll1 = new vueTroll(t1);
		this.vueTroll2 = new vueTroll(t2);
		this.vueMap = new vueMap(m);
	}
	
	public void afficherMenuPrincipal() {
		this.menu.MenuPrincipal();
	}
	
	public void questionSimple(String question) {
		this.menu.questionSimple(question);
	}

}
