import java.util.Random;

public class WorldGenCaves{
public WorldGenCaves(World wo){
	w = wo;
}
public void generate(){
	Random r = new Random();
	r.setSeed(System.currentTimeMillis());
	
	for (int x = 0; x < w.X.size(); x++){
		if (r.nextInt(200) == 0){
			int start = 0;
			for (int y = 0; y < 500; y++){
				if (w.getBlockID(x, y) == 0){
					start = y;
					break;
				}
			}
			int at = r.nextInt(400)+50;
			int y = start;
			int atx = x;
			int last = 4;
			for (int gofor = 0; gofor< at; gofor++){
				int dir = r.nextInt(3);
				last = last < 3?4:last;
				
				
				switch(dir){
				case 0:
					y-=1;
					last += r.nextInt(3)-1;
					for (int i = 0; i < last;i++){
						
						if (r.nextInt(90)<=85){
						w.setBlock(atx+i, y, 0);
						}
						
						
					}
					break;
				case 1:
					last += r.nextInt(3)-1;
					atx+=1;
					for (int i = 0; i < last;i++){
						
						if (r.nextInt(90)<=85){
						w.setBlock(atx, y+i, 0);
						}
						
						
					}
					break;
				case 2:
					atx-=1;
					last += r.nextInt(3)-1;
					for (int i = 0; i < last;i++){
						
						if (r.nextInt(90)<=85){
						w.setBlock(atx, y+i, 0);
						}
						
						
					}
					break;
				default:	
					last += r.nextInt(3)-1;
				y-=1;
				for (int i = 0; i < last;i++){
					
					if (r.nextInt(90)<=85){
					w.setBlock(atx+i, y, 0);
					}
					
					
				}break;
				}
			}
			
			
			
		
			
			
			
		}
	}
	
	
}
private World w;
}
