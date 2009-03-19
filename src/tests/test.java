package tests;

import java.util.List;

import org.apache.torque.Torque;
import org.apache.torque.TorqueException;
import org.apache.torque.util.Criteria;

import com.sun.corba.se.pept.transport.Connection;

import torque.generated.*;

public class test {

	public final static String TORQUE_PROPS = new String("torque-3.3/Torque.properties");

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Torque.init(TORQUE_PROPS);

			Objet addison = new Objet();
			addison.setId(109);
			addison.setTruc("trucccccccccc");
			System.out.println(addison.getId());
			addison.save();
			
			Arme a = new Arme();
			a.setIdObjet(addison.getId());
			a.setNom(Arme.gen_nom());
			a.setBonusattaque(Map.hasard()/10);
			a.setBonusdegat(Map.hasard()/10);
			a.setBonusesquive(Map.hasard()/10);
			a.save();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
