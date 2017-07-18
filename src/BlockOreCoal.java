import java.awt.Image;

import javax.swing.ImageIcon;


public class BlockOreCoal extends BlockBase {
	
	public BlockOreCoal(){
		lightGiven = 0;
		lightBlock = 4;
		canCollide = true;
		isLiquid = false;
		canBePlacedOn = true;
		item = Item.ItemCoal.getItem();
		blockId = 3;
		healthLeft = 4;
	}

	void onBlockDestroyedByExplosion(int x, int y, String nameOfSource, World w) {
		
	}
	void onBlockPlaced(EntityPlayer entityPlayer, int x, int y) {
		
	}

	void onEntityWalk(Entity entity, int x, int y) {
		
	}


	void onTick(int x, int y, World w) {
		
	}

	Effect getEffectOnDestroy(int x, int y) {
		return new Effect(1,x,y);
	}

	Image getImage(int x, int y, World w) {
		return new ImageIcon("Images/CoalOre.png").getImage();
	}

	@Override
	void onBlockMined(EntityPlayer entityPlayer, int x, int y, World w) {
		// TODO Auto-generated method stub
		
	}

}
