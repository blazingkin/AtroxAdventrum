import java.awt.Image;

import javax.swing.ImageIcon;


public class BlockSand extends BlockBase {
	
	public BlockSand(){
		lightGiven = 0;
		lightBlock = 4;
		canCollide = true;
		isLiquid = false;
		canBePlacedOn = true;
		item = Item.SandBlock.getItem();
		blockId = 8;
		healthLeft = 4;
		setTick(false);
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
		if (w.getBlockID(x, y-1) == 0){
			w.setBlock(x, y, 0);
			w.setBlock(x, y-1, 8);
		}
	}

	Effect getEffectOnDestroy(int x, int y) {
		return new Effect(1,x,y);
	}


	Image getImage(int x, int y, World w) {
		return new ImageIcon("Images/sand.png").getImage();
	}

}
