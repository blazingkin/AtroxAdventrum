import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;


public class BlockDirt extends BlockBase {
	
	public BlockDirt(){
		lightGiven = 0;
		lightBlock = 4;
		canCollide = true;
		isLiquid = false;
		canBePlacedOn = true;
		item = Item.DirtBlock.getItem();
		blockId = 1;
		healthLeft = 4;
		grass = false;
	}
	
	public BlockDirt(boolean grass){
		lightGiven = 0;
		lightBlock = 4;
		canCollide = true;
		isLiquid = false;
		canBePlacedOn = true;
		item = Item.DirtBlock.getItem();
		blockId = 1;
		healthLeft = 4;
		setTick(true);
		ticknum = 20;
		this.grass = true;
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
		r.setSeed(System.currentTimeMillis());
		if (w.getBlockID(x, y+1) != 0){
			w.setBlock(x, y, 1);
		}
		if (r.nextInt(10)==0){
		if ((w.getBlockID(x+1, y) == 1&&w.getBlockID(x+1, y+1) == 0)){
				w.setBlock(x+1, y, 4);
		}else if ((w.getBlockID(x-1, y) == 1&&w.getBlockID(x-1, y+1) == 0)){
				w.setBlock(x-1, y, 4);
		}else if (w.getBlockID(x-1, y+1) == 1&&w.getBlockID(x-1, y+2) == 0){
				w.setBlock(x-1, y+1, 4);
		}else if (w.getBlockID(x-1, y-1) == 1&&w.getBlockID(x-1, y) == 0){
				w.setBlock(x-1, y-1, 4);
		}else if (w.getBlockID(x+1, y+1) == 1&&w.getBlockID(x+1, y+2) == 0){
				w.setBlock(x+1, y+1, 4);
		}else if (w.getBlockID(x+1, y-1) == 1&&w.getBlockID(x+1, y) == 0){
				w.setBlock(x+1, y-1, 4);
		}
		
		}	
	}

	Effect getEffectOnDestroy(int x, int y) {
		return new Effect(1,x,y);
	}

	@Override
	Image getImage(int x, int y, World w) {
		if (grass){
			return new ImageIcon("Images/Grass.png").getImage();
		}else{
			return new ImageIcon("Images/Dirt.png").getImage();
		}
	}

	boolean grass;
}
