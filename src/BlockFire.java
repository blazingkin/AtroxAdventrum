import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;


public class BlockFire extends BlockBase {
	
	
	public BlockFire(){
		lightGiven = 5;
		lightBlock = 0;
		canCollide = false;
		isLiquid = false;
		canBePlacedOn = false;
		blockId = 6;
		healthLeft = 4;
		setTick(true);
		ticknum = 5;
	}
	
	void onBlockDestroyedByExplosion(int x, int y, String nameOfSource, World w) {
		
	}

	void onBlockPlaced(EntityPlayer entityPlayer, int x, int y) {
		
	}

	void onEntityWalk(Entity entity, int x, int y) {
		entity.hurt(1);
	}

	void onBlockMined(EntityPlayer entityPlayer, int x, int y, World w) {
		
	}

	void onTick(int x, int y, World w) {
		Random r = new Random();
		r.setSeed(System.currentTimeMillis() + x + y);
		
		
		if (w.getBlockID(x, y+1) < 15 && w.getBlockID(x, y+1) > 9){
			w.setBlock(x, y, 0);
			return;
		}
		
		
		if (w.getBlockID(x, y+1) == 5 ||w.getBlockID(x, y+1) == 6 ){
			w.setBlock(x, y+1,16);
		}else if (w.getBlockID(x+1, y) == 5 ||w.getBlockID(x+1, y) == 6 ){
			w.setBlock(x+1, y,16);
		}else if (w.getBlockID(x-1, y) == 5 ||w.getBlockID(x-1, y) == 6 ){
			w.setBlock(x-1, y,16);
		}else if (w.getBlockID(x, y-1) == 5 ||w.getBlockID(x-1, y-1) == 6 ){
			if (r.nextInt(10)==0){
				w.setBlock(x, y-1, 16);
			}
		}
		else{
			if ((r.nextInt(5)==0 || w.getBlockID(x, y-1) == 0) && w.getBlockID(x, y-1) != 17){
			w.setBlock(x, y, 0);
			}
		}
		
	}

	Effect getEffectOnDestroy(int x, int y) {
		return new Effect(1,x,y);
	}

	Image getImage(int x, int y, World w) {
		if (w.getBlockID(x, y+1) == 16){
			return new ImageIcon("Images/FireFull.png").getImage();
		}else{
			return new ImageIcon("Images/Fire.png").getImage();
		}
	}

}
