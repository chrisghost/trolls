package trolls;

import java.util.Scanner;

import torque.generated.Map;
import torque.generated.Troll;

public class MoteurGraphique {
	
	static Menu menu;
	vueTroll vueTroll1;
	vueTroll vueTroll2;
	vueMap vueMap;
	
	public MoteurGraphique() {
		this.menu = new Menu();
	}
	
	public static  int menuTour() {
		return menu.MenuTour();
	}
	
	public void affecterTroll1(Troll t1) {
		this.vueTroll1 = new vueTroll(t1);
	}
	public void affecterTroll2(Troll t2) {
		this.vueTroll2 = new vueTroll(t2);
	}
	
	public void affecterMap(Map m) {
		this.vueMap = new vueMap(m);
	}
	public void afficherMap() {
		this.vueMap.afficherMap();
	}
	
	public int afficherMenuPrincipal() {
		return menu.MenuPrincipal();
	}
	
	public boolean questionSimple(String question) {
		return menu.questionSimple(question);
	}
	
	public String question(String question) {
		return menu.question(question);
	}

	public int questionInt(String question) {
		return menu.questionInt(question);
	}
	
	public void afficheInfosTroll(Troll troll) {
			if(troll.getNom() == this.vueTroll1.getNom())//Troll1
				this.vueTroll1.afficherInfos();
			else										// Troll2
				this.vueTroll2.afficherInfos();
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
	
	public static int lireInt() {
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}

}
