package trolls;

import java.io.IOException;

public class Menu {
	
	public int MenuPrincipal() {
		System.out.println("********************** Menu Principal **********************");
		System.out.println("* 1- Lancer une partie   						  		   *");
		System.out.println("* 0- Quitter             						  		   *");
		System.out.println("***** Trolls by Favre Pierre-Edouard && Maillol Adrien *****");
		
		int rep= 100;
		while(rep!=0 && rep!=1)
			try {
				rep = System.in.read();
			} catch (IOException e) {
				System.out.println("Entrez un entier!");
				e.printStackTrace();
			}
		return rep;
	}
	
	public boolean questionSimple(String question) {
		System.out.println("********************** Question **********************");
		System.out.println(question);
		System.out.println("Reponse? (oui = 1/non = 0)");
		
		int rep= 100;
		while(rep!=0 && rep!=1)
			System.out.println("Reponse? (oui = 1/non = 0)");

			try {
				rep = System.in.read();
			} catch (IOException e) {
				System.out.println("Entrez 1 ou 0 (oui = 1/non = 0)");
				e.printStackTrace();
			}
		return rep == 1;
	}

}
