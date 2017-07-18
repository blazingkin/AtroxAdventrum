import java.awt.Image;

import javax.swing.ImageIcon;


public class BlockWood extends BlockBase {
	
	public BlockWood(){
		lightGiven = 0;
		lightBlock = 4;
		canCollide = true;
		isLiquid = false;
		canBePlacedOn = true;
		item = Item.ItemWood.getItem();
		blockId = 5;
		healthLeft = 4;
	}
	public BlockWood(boolean plank){
		lightGiven = 0;
		lightBlock = 4;
		canCollide = true;
		isLiquid = false;
		canBePlacedOn = true;
		item = Item.ItemCoal.getItem();
		blockId = 5;
		healthLeft = 4;
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
		return new ImageIcon("Images/Wood.png").getImage();
	}

}
