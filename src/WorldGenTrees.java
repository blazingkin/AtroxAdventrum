import java.util.Random;


public class WorldGenTrees {
public WorldGenTrees(World wo){
	w = wo;
}
public void generate(){
	Random r = new Random();
	r.setSeed(System.currentTimeMillis());
	for (int x = 0; x<w.X.size(); x++){
			for (int y = 499; y>=300;y--){
				if (w.getBlockID(x, y-1) == 4||w.getBlockID(x,y-1) == 1){
				if (r.nextInt(30)==0){
					int org = r.nextInt(6)+4;
					for (int rd = 0; rd < org; rd++){
					w.setBlock(x, y+rd, 5);
					if (rd > org/2){
						w.repBlock(x+1, y+rd, 6);
						w.repBlock(x-1, y+rd, 6);
						w.repBlock(x+2, y+rd, 6);
						w.repBlock(x-2, y+rd, 6);
						w.repBlock(x, y+rd+1, 6);
						w.repBlock(x, y+rd+2, 6);
						w.repBlock(x+1, y+rd+1, 6);
						w.repBlock(x-1, y+rd+1, 6);
						}
					}
				}
				break;
				}else if(w.getBlockID(x, y - 1) == 8){
					if (r.nextInt(20) == 0){
					int org = r.nextInt(7);
					w.setBlock(x, y-1, 8);
					w.setBack(x, y-1, 0);
					for (int rd = 0; rd < org; rd++){
						w.setBlock(x, y+rd, 9);
						w.setBack(x, y+rd, 0);
						}
					}
					break;
				}
				
			}	
	}
}
private World w;
}
