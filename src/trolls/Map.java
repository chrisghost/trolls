package trolls;

public class Map {
	
	
	public Map(int x, int y, int nb_obj) {
		int compteur = 0;
		for(int i =0; i<x;i++){
			for(int j=0;j<y;j++){
				compteur++;
				String obj;
				
				if (nb_obj>0){
					if (x*y-compteur == nb_obj){
						obj = "oui car il reste "+ nb_obj+" et "+(x*y-compteur)+" cases";
						nb_obj--;
					}
					else if (hasard() > 50){
						obj = "Oui, hasard > ";
						nb_obj--;}
	
					else
						obj = "Non";
					System.out.println(i+":"+j+">"+obj);
				}
			}
		}
		System.out.println("Il reste "+nb_obj+" objet(s)");
		
	}
	
	private int hasard() {
		return (int)( Math.random()*( 100 - 1 + 1 ) ) + 1; // Nombre aléatoire entre 1 et 100
	}

}
