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
		System.out.println("Reponse? (oui = 1/non = 0)");
		
		int rep= 100;
		while(rep!=0 && rep!=1){
			System.out.println("Reponse? (oui = 1/non = 0)");

			try {
				rep = System.in.read();
			} catch (IOException e) {
				System.out.println("Entrez 1 ou 0 (oui = 1/non = 0)");
				e.printStackTrace();
			}
		}
		return rep == 1;
	}
	
	public int questionInt(String question) {
		System.out.println("********************** Question **********************");
		System.out.println(question);
		System.out.println(">");
		
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
		System.out.println("* 0- Quitter_______________________________________________*");
		System.out.println("***** Trolls by Favre Pierre-Edouard && Maillol Adrien *****");
		

		int rep = -1;
		while((rep!=1) && (rep!=2) && (rep!=3) && (rep!=4) && (rep!=5))
			rep = MoteurGraphique.lireInt();

		return rep;
	}
	
	
	
	
	
	
	public String question(String question) {
		System.out.println("********************** Question **********************");
		System.out.println(question);
		System.out.println(">");
		
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
