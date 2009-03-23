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
//		map = map + this.map.getX() + ":" + this.map.getY() + "\n";
		
		Criteria crit = new Criteria();
		crit.addAscendingOrderByColumn(CellPeer.X);
		crit.addAscendingOrderByColumn(CellPeer.Y);
		
		Criteria critTroll = new Criteria();
		critTroll.addAscendingOrderByColumn(TrollPeer.X);
		critTroll.addAscendingOrderByColumn(TrollPeer.Y);
		
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
		

		Cell c = (Cell) itC.next();
		Troll t = (Troll) itT.next();
		for(int i=0; i<this.map.getY();i++){
			for(int j=0; j<this.map.getX();j++){
				map = map + "+-";
			}
			map = map + "+\n";
			for(int j=0; j<this.map.getX();j++){
				if(c.getX() == j && c.getY() == i){
					
					if(t.getX() == j && t.getY() == i){
						map = map + "|#";
						if(itT.hasNext())
							t = (Troll) itT.next();
					}else
						map = map + "|O";
					if(itC.hasNext())
						c = (Cell) itC.next();
					
				}else if(t.getX() == j && t.getY() == i){
					if(itT.hasNext()){
						t = (Troll) itT.next();
						if(t.getX() == j && t.getY() == i)
							map = map + "|X";
						else
							map = map + "|T";
					}else
						map = map + "|T";
				}else
					map = map + "| ";
			}
			map = map + "|\n";
		}
		for(int j=0; j<this.map.getX();j++){
			map = map + "+-";
		}
		map = map + "+";
		
		System.out.print(map);
	}
}
