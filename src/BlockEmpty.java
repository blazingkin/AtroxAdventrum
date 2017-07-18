import java.awt.*;
import java.util.*;


public class BlockEmpty extends BlockBase {
	
	public BlockEmpty(Image icon){
		lightGiven = 0;
		lightBlock = 0;
		canCollide = false;
		isLiquid = true;
		canBePlacedOn = false;
		blockId = 0;
		healthLeft = -1;
		currentImage = icon;
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
Image currentImage;
Image getImage(int x, int y, World w) {
	return currentImage;
}
}
