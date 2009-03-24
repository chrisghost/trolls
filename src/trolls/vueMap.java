package trolls;

import java.util.Iterator;
import java.util.List;

import org.apache.torque.TorqueException;
import org.apache.torque.util.Criteria;

import torque.generated.Cell;
import torque.generated.CellPeer;
import torque.generated.Map;
import torque.generated.Troll;
import torque.generated.TrollPeer;

public class vueMap {
	
	Map map;
	
	public vueMap(Map m) {
		this.map = m;
	}
	
	public void afficherMap() {
		String map = "";
		
		Criteria crit = new Criteria();
		crit.addAscendingOrderByColumn(CellPeer.Y);
		crit.addAscendingOrderByColumn(CellPeer.X);
		
		Criteria critTroll = new Criteria();
		critTroll.addAscendingOrderByColumn(TrollPeer.Y);
		critTroll.addAscendingOrderByColumn(TrollPeer.X);
		
		Iterator itC = null;
		Iterator itT = null;
		try {
			List cells = CellPeer.doSelect(crit);
			itC = cells.iterator();
			
			List trolls = TrollPeer.doSelect(critTroll);
			itT = trolls.iterator();

		} catch (TorqueException e) {
			e.printStackTrace();
		}
		
		map = map + " ";
		for(int j=0; j<this.map.getX();j++){
			map = map + " "+(j+1);
		}
		map = map + "\n";
		
		Cell c = (Cell) itC.next();
		Troll t = (Troll) itT.next();
		for(int i=0; i<this.map.getY();i++){
			map = map + " ";
			for(int j=0; j<this.map.getX();j++){//lignes de séparation
				map = map + "+-";
			}
			map = map + "+\n";
			map = map + (i+1);
			for(int j=0; j<this.map.getX();j++){
				int o = 0;
				if(c.getX() == j && c.getY() == i){
					o += 1; // ajout d un objet sur la case
					if(itC.hasNext())
						c = (Cell) itC.next();
				}
				if(t.getX() == j && t.getY() == i){
					o += 2; //ajout d un troll sur la case
					if(itT.hasNext()){
						t = (Troll) itT.next();
						if(t.getX() == j && t.getY() == i)
							o += 2;
					}
				}
				
				switch (o) {
				case 0:
					map = map + "| ";
					break;
				case 1:
					map = map + "|¤";
					break;
				case 2:
					map = map + "|T";
					break;
				case 3:
					map = map + "|&";
					break;
				case 4:
					map = map + "|X";
					break;
				case 5:
					map = map + "|#";
					break;
				default:
					break;
				}

			}
			
			map = map + "|\n";
		}
		for(int j=0; j<this.map.getX();j++){
			map = map + "+-";
		}
		map = map + "+\n";
		
		System.out.print(map);
	}
}
