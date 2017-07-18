import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;


public class BlockCactus extends BlockBase {
	
	public BlockCactus(){
		lightGiven = 0;
		lightBlock = 4;
		canCollide = true;
		isLiquid = false;
		canBePlacedOn = true;
		item = Item.CactusBlock.getItem();
		blockId = 1;
		healthLeft = 4;
		setTick(true);
		ticknum = 35;
	}
	




	void onBlockPlaced(EntityPlayer entityPlayer, int x, int y) {
		
	}

	void onEntityWalk(Entity entity, int x, int y) {
		entity.hurt(1);
	}

	void onBlockMined(EntityPlayer entityPlayer, int x, int y, World w) {
		
	}

	void onTick(int x, int y, World w) {
		if (w.getBlockID(x, y - 1) != 8 && w.getBlockID(x, y - 1) != 9){
			w.setBlock(x, y, 0);
		}
	}

	Effect getEffectOnDestroy(int x, int y) {
		return new Effect(1,x,y);
	}




	Image getImage(int x, int y, World w) {
return new ImageIcon("Images/cactus.png").getImage();
	}



	void onBlockDestroyedByExplosion(int x, int y, String nameOfSource, World w) {
		
	}

}
