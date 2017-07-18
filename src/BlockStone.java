import java.awt.Image;

import javax.swing.ImageIcon;


public class BlockStone extends BlockBase {
	public BlockStone(){
		lightGiven = 0;
		lightBlock = 5;
		canCollide = true;
		isLiquid = false;
		canBePlacedOn = true;
		item = Item.StoneBlock.getItem();
		blockId = 2;
		healthLeft = 7;
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
		
	}

	Effect getEffectOnDestroy(int x, int y) {
		return new Effect(1,x,y);
	}

	Image getImage(int x, int y, World w) {
		return new ImageIcon("Images/Stone.png").getImage();
	}

}
