package trolls;

import java.io.IOException;



public class Menu {
	
	public int MenuPrincipal() {
		System.out.println("********************** Menu Principal **********************");
		System.out.println("* 1- Lancer une partie_____________________________________*");
		System.out.println("* 0- Quitter_______________________________________________*");
		System.out.println("***** Trolls by Favre Pierre-Edouard && Maillol Adrien *****");

		int rep = -1;
		while(rep == -1)
			rep = MoteurGraphique.lireInt();

		return rep;
	}
	
	public boolean questionSimple(String question) {
		System.out.println("********************** Question **********************");
		System.out.println(question);
		
		int rep= 100;
		while(rep!=0 && rep!=1){
			System.out.println("Reponse? (oui = 1/non = 0)");
			rep = MoteurGraphique.lireInt();
		}
		return rep == 1;
	}
	
	public int questionInt(String question) {
		System.out.println("********************** Question **********************");
		System.out.println(question);
		int rep = -1;
		while(rep == -1)
			rep = MoteurGraphique.lireInt();
		return rep;

	}
	
	
	public int MenuTour() {
		System.out.println("********************** Menu Principal **********************");
		System.out.println("* 1- Deplacemenent_________________________________________*");
		System.out.println("* 2- Attaquer______________________________________________*");
		System.out.println("* 3- Ramasser______________________________________________*");
		System.out.println("* 4- Utiliser______________________________________________*");
		System.out.println("* 5- Equiper_______________________________________________*");
		System.out.println("* 6- Afficher infos troll__________________________________*");
		System.out.println("* 7- Afficher equipement___________________________________*");
		System.out.println("* 8- Afficher inventaire___________________________________*");
		System.out.println("* 9- Afficher carte________________________________________*");
		System.out.println("* 10- Finir le tour________________________________________*");
		System.out.println("* 0- Quitter_______________________________________________*");
		System.out.println("***** Trolls by Favre Pierre-Edouard && Maillol Adrien *****");
		

		int rep = -1;
		while((rep!=1) && (rep!=2) && (rep!=3) && (rep!=4) 
				&& (rep!=5) && (rep!=6) && (rep!=7) && (rep!=8) 
				&& (rep!=9) && (rep!=10) && (rep!=0))
			rep = MoteurGraphique.lireInt();

		return rep;
	}
	
	
	
	
	
	
	public String question(String question) {
		System.out.println("********************** Question **********************");
		System.out.println(question);
		String rep = "";
		while(rep.equalsIgnoreCase(""))
			rep = MoteurGraphique.lireChaine();

		return rep;
	}
	
	public void afficher(String message) {
		System.out.println("********************** Information **********************");
		System.out.println(message);
	}
	
	public void afficherBrut(String message) {
		System.out.println(message);
	}

}
