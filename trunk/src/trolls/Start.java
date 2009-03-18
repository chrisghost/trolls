package trolls;

import java.util.List;

import org.apache.torque.Torque;
import org.apache.torque.TorqueException;
import org.apache.torque.util.Criteria;

import torque.generated.*;

public class Start {

	public final static String TORQUE_PROPS = new String("torque-3.3/Torque.properties");

	public static void main(String[] args) {
//		Fonction principale du programme, contiendra l'appel au moteur graphique et au moteur de jeu.
		
//		Ce qui suit permet de tester les fonctionnalités implémentées pour le moment


		MoteurGraphique IG = new MoteurGraphique();
		MoteurJeu MJ = new MoteurJeu(IG);
		

		System.out.println(IG.afficherMenuPrincipal());

		
//		Menu ig = new Menu();
		
//		int i = ig.MenuPrincipal();
		
//		if(ig.questionSimple("Ca marche?"))
//			System.out.println("Yes!");
		
	}

}
