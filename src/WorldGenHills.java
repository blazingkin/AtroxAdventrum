import java.util.Random;


public class WorldGenHills {
public WorldGenHills(World wo){
	w = wo;
}
public void generate(){
	Random r = new Random();
	r.setSeed(System.currentTimeMillis());
	int lastslope = r.nextInt(10);
	int prev = 85;
	for (int x = 0; x<w.X.size(); x++){
		int zed = lastslope += (r.nextInt(5)-2);
		zed = zed+300<301?2+r.nextInt(2):zed;
		if (zed >= 300){
			for (int y = zed; y>=300;y--){
				w.setBlock(x, y, 0);
				w.setBack(x, y, 0);
			}	
		}else{
		prev += r.nextInt(3)-1;
		for (int y = r.nextInt(10)+290; y<300+zed;y++){
			if (y == 299+zed){
			w.setBlock(x, y, prev<100?4:8);
			w.setBack(x, y, r.nextInt(2)==0?1:6);
			}else{
			w.setBlock(x, y, prev<100?1:8);
			w.setBack(x, y, r.nextInt(2)==0?1:6);
			}		
		}
	}
}
}
private World w;
}
