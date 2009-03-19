package trolls;

import torque.generated.Map;

public class vueMap {
	
	Map map;
	
	public vueMap(Map m) {
		this.map = m;
	}
	
	public void afficherMap() {
		String map = "";
		map = map + this.map.getX() + ":" + this.map.getY() + "\n";
		
		for(int i=0; i<this.map.getY();i++){
			for(int j=0; j<this.map.getX();j++){
				map = map + "+-";
			}
			map = map + "+\n";
			for(int j=0; j<this.map.getX();j++){
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
