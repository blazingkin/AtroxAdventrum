import java.util.Random;


public class WorldGenStone {
public WorldGenStone(World wo){
	w = wo;
}
public void generate(){
	Random r = new Random();
	r.setSeed(System.currentTimeMillis());
	int lastrndm = 0;
	for (int x = 0; x<w.X.size(); x++){
		int upto = 275 + (lastrndm += r.nextInt(3)-1);
		upto = upto < 225?230:upto;
		upto = upto > 290?285:upto;
		for (int y = 0; y<upto;y++){
			w.setBlock(x, y, 2);
			w.setBack(x, y, 2);
			//System.out.println("Changed at: "+x+", "+y);
		}
	}
}

private World w;
}
