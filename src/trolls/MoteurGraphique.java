package trolls;

import java.util.Scanner;

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
	
	public int afficherMenuPrincipal() {
		return this.menu.MenuPrincipal();
	}
	
	public boolean questionSimple(String question) {
		return this.menu.questionSimple(question);
	}
	
	public String question(String question) {
		return this.menu.question(question);
	}

	public int questionInt(String question) {
		return this.menu.questionInt(question);
	}
	
	public void afficher(String message) {
		this.menu.afficher(message);
	}
	public void afficherBrut(String message) {
		this.menu.afficherBrut(message);
	}
	
	public static String lireChaine() {
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}

}
