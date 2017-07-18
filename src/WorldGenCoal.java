import java.util.Random;

public class WorldGenCoal{
public WorldGenCoal(World wo){
	w = wo;
}
public void generate(){
	Random r = new Random();
	r.setSeed(System.currentTimeMillis());
	
	for (int x = 0; x < w.X.size(); x++){
		if (r.nextInt(6) == 0){
		int ammount = r.nextInt(2)+1;
		for (int lol = 0; lol < ammount; lol++){
			int y = r.nextInt(100)+200;
			
			w.setBlock(x, y, 3);
			int till = r.nextInt(6)+2;
			for (int zed = 0; zed < till; zed++){
				int dir = r.nextInt(4);
				switch (dir){
				case 0:
					x++;
					break;
				case 1:
					x--;
					break;
				case 2:
					y++;
					break;
				case 3:
					y--;
					break;
				default:
					break;
				}
				w.setBlock(x, y, 3);
			}
			
		}
	}
	}
	
	
}
private World w;
}
