import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;


public class BlockLeaves extends BlockBase {
	
	
	public BlockLeaves(){
		lightGiven = 0;
		lightBlock = 2;
		canCollide = false;
		isLiquid = false;
		canBePlacedOn = true;
		blockId = 6;
		healthLeft = 4;
		setTick(true);
	}
	
	void onBlockDestroyedByExplosion(int x, int y, String nameOfSource, World w) {
		
	}

	void onBlockPlaced(EntityPlayer entityPlayer, int x, int y) {
		
	}

	void onEntityWalk(Entity entity, int x, int y) {
		
	}

	void onBlockMined(EntityPlayer entityPlayer, int x, int y, World w) {
		
	}

	void onTick(int x, int y, World w) {
		Random r = new Random();
		r.setSeed(System.currentTimeMillis() + x + y);
		if (r.nextInt(40)==0){
		if (w.getBlockID(x-1, y) == 6 || w.getBlockID(x-1, y) == 5||w.getBlockID(x+1, y) == 6 || w.getBlockID(x+1, y) == 5||w.getBlockID(x, y-1) == 6 || w.getBlockID(x, y-1) == 5||w.getBlockID(x, y+1) == 6 || w.getBlockID(x, y+1) == 5){
		}else{w.setBlock(x, y, 0);}
		}
	}

	Effect getEffectOnDestroy(int x, int y) {
		return new Effect(1,x,y);
	}

	Image getImage(int x, int y, World w) {
		return new ImageIcon("Images/Leaves.png").getImage();
	}

}
