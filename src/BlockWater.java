import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;


public class BlockWater extends BlockBase {
	
	public BlockWater(int h){
		lightGiven = 0;
		lightBlock = 0;
		canCollide = false;
		isLiquid = true;
		canBePlacedOn = false;
		item = Item.CactusBlock.getItem();
		blockId = 15 - h;
		healthLeft = 4;
		
		waterHeight = h;
		setTick(true);
		ticknum = 1;
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
		boolean ch = false;
		try{
		if (w.getBlockID(x, y-1) == 0){
			w.setBlock(x, y-1, blockId);
			w.setBlock(x, y, 0);
			ch = true;
		}/*else if (Block.values()[w.getBlockID(x, y-1)].getBlock().waterHeight + waterHeight >= waterHeight){
			if (Block.values()[w.getBlockID(x, y-1)].getBlock().waterHeight + waterHeight > 5){
				if (Block.values()[w.getBlockID(x, y-1)].getBlock().waterHeight + waterHeight == 10){
				w.setBlock(x, y-1, 10);		
				w.setBlock(x, y, 10);		
				}else{
				w.setBlock(x, y,(Block.values()[w.getBlockID(x, y-1)].getBlock().blockId + waterHeight)<15?(Block.values()[w.getBlockID(x, y-1)].getBlock().blockId + waterHeight):10);
				w.setBlock(x, y-1, 10);	
				}
			}else{
				w.setBlock(x, y-1, (Block.values()[w.getBlockID(x, y-1)].getBlock().blockId + waterHeight)<15?(Block.values()[w.getBlockID(x, y-1)].getBlock().blockId + waterHeight):10);
				w.setBlock(x, y, 0);	
			}
		}*/
		
		else if (Block.values()[w.getBlockID(x, y-1)].getBlock().waterHeight != -1){
			if (Block.values()[w.getBlockID(x, y-1)].getBlock().waterHeight + Block.values()[w.getBlockID(x, y)].getBlock().waterHeight <= 5){
				w.setBlock(x, y-1, 9+Block.values()[w.getBlockID(x, y-1)].getBlock().waterHeight + Block.values()[w.getBlockID(x, y)].getBlock().waterHeight);
				w.setBlock(x, y, 0);
				ch = true;
			}else if (9+(Block.values()[w.getBlockID(x, y)].getBlock().waterHeight>Block.values()[w.getBlockID(x, y-1)].getBlock().waterHeight?Block.values()[w.getBlockID(x, y)].getBlock().waterHeight - Block.values()[w.getBlockID(x, y-1)].getBlock().waterHeight:Block.values()[w.getBlockID(x, y-1)].getBlock().waterHeight - Block.values()[w.getBlockID(x, y)].getBlock().waterHeight) > 9 && 9+(Block.values()[w.getBlockID(x, y)].getBlock().waterHeight>Block.values()[w.getBlockID(x, y-1)].getBlock().waterHeight?Block.values()[w.getBlockID(x, y)].getBlock().waterHeight - Block.values()[w.getBlockID(x, y-1)].getBlock().waterHeight:Block.values()[w.getBlockID(x, y-1)].getBlock().waterHeight - Block.values()[w.getBlockID(x, y)].getBlock().waterHeight) < 15){
				w.setBlock(x, y, 9+(Block.values()[w.getBlockID(x, y)].getBlock().waterHeight>Block.values()[w.getBlockID(x, y-1)].getBlock().waterHeight?Block.values()[w.getBlockID(x, y)].getBlock().waterHeight - Block.values()[w.getBlockID(x, y-1)].getBlock().waterHeight:Block.values()[w.getBlockID(x, y-1)].getBlock().waterHeight - Block.values()[w.getBlockID(x, y)].getBlock().waterHeight));
				w.setBlock(x, y-1, 10);
				ch = true;
			}
		}if (w.getBlockID(x+1, y) == 0 && !ch){
			if (waterHeight > 1){
			w.setBlock(x+1, y,15 - waterHeight/2+1<15?15 - waterHeight/2+1:0);
			w.setBlock(x, y, 15 - waterHeight/2-1>9?15 - waterHeight/2-1:0);
			}
		}if (w.getBlockID(x-1, y) == 0 && !ch){
			if (waterHeight > 1){
			w.setBlock(x-1, y, 15 - waterHeight/2+1<15?15 - waterHeight/2+1:0);
			w.setBlock(x, y, 15 - waterHeight/2-1>9?15 - waterHeight/2-1:0);
			}
		}
		if (Block.values()[w.getBlockID(x-1, y)].getBlock().waterHeight != -1 && waterHeight > 3){
			if (Block.values()[w.getBlockID(x-1, y)].getBlock().waterHeight+2 < waterHeight ){
				w.setBlock(x-1, y, 9+Block.values()[w.getBlockID(x-1, y)].getBlock().waterHeight+1);
				w.setBlock(x,y,9+waterHeight-2);
			}
		}if (Block.values()[w.getBlockID(x+1, y)].getBlock().waterHeight != -1 && waterHeight > 3){
			if (Block.values()[w.getBlockID(x+1, y)].getBlock().waterHeight+2 < waterHeight ){
				w.setBlock(x+1, y, 9+Block.values()[w.getBlockID(x+1, y)].getBlock().waterHeight+1);
				w.setBlock(x,y,9+waterHeight-2);
			}
		}
		}catch(Exception e){}
	}

	Effect getEffectOnDestroy(int x, int y) {
		return new Effect(1,x,y);
	}


	Image getImage(int x, int y, World w) {
		if (waterHeight == 5 ){
			if (w.getBlockID(x, y+1) == 0){
			return new ImageIcon("Images/Water1.png").getImage();
			}else{
			return new ImageIcon("Images/WaterFlat.png").getImage();
			}
		}else{
			if (w.getBlockID(x, y+1) != 0){
				w.setBlock(x, y, 10);
				return new ImageIcon("Images/WaterFlat.png").getImage();
			}

			switch(waterHeight){
			case 1:
			return new ImageIcon("Images/Water5.png").getImage();
			case 2:
				return new ImageIcon("Images/Water4.png").getImage();
			case 3:
				return new ImageIcon("Images/Water3.png").getImage();
			case 4:
				return new ImageIcon("Images/Water2.png").getImage();
			default:
				return new ImageIcon("Images/WaterFlat.png").getImage();
				
			}
		}
		
	}
}
