import java.util.Random;




public class WorldGenSurface {
public WorldGenSurface(World wo){
	w = wo;
}
public void generate(){
	Random r = new Random();
	 r.setSeed(System.nanoTime());
	for (int x = 0; x<w.X.size(); x++){
		w.setBlock(x, 299, 4);
		for (int y = 300; y<500;y++){
			w.setBlock(x, y, 0);
			w.setBack(x, y, r.nextInt(3)>1?0:r.nextInt(2)==0?4:5);

			
		}
		if (r.nextInt(3) == 0){
			w.setBlock(x, r.nextInt(50)+350, 17);
		}
	}
}

private World w;
}
