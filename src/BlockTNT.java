import java.awt.*;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.swing.ImageIcon;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.util.*;


public class BlockTNT extends BlockBase {
BlockTNT(){
	lightGiven = 0;
	lightBlock = 4;
	canCollide = true;
	isLiquid = false;
	canBePlacedOn = true;
	item = Item.TNTBlock.getItem();
	blockId = 3;
	healthLeft = 4;
	setTick(true);
	r = new Random();
	r.setSeed(System.currentTimeMillis());
	
}
	
public void playSound(String Filename) {
	  try{
	InputStream in = new FileInputStream(Filename);
	AudioStream as = new AudioStream(in);         
	AudioPlayer.player.start(as);            
	//AudioPlayer.player.stop(as);
	  }catch(Exception e){}
	  }

	void onBlockMined(EntityPlayer entityPlayer, int x, int y, World w) {
		playSound("Sound/boom.wav");
		w.setBlock(x, y, 0);
		w.setBack(x, y, r.nextInt(3)>1?0:r.nextInt(2)==0?4:5);
		for (int lx = x - r.nextInt(4) -7; lx < x+r.nextInt(4)+7; lx++){
			for (int ly = y - r.nextInt(4)-7; ly < y+r.nextInt(4)+7; ly++){
				if (r.nextInt(40)<37){
					Block.values()[w.getBlockID(lx, ly)].getBlock().onBlockDestroyedByExplosion(lx, ly, "TNT", w);
					w.setBlock(lx, ly, 16);
					w.setBack(lx, ly, r.nextInt(3)>1?0:r.nextInt(2)==0?4:5);
				}
			}
		}
	}

	void onBlockPlaced(EntityPlayer entityPlayer, int x, int y) {
		
	}

	void onBlockDestroyedByExplosion(int x, int y, String nameOfSource, World w) {
		playSound("Sound/boom.wav");
		w.setBlock(x, y, 0);
		w.setBack(x, y, r.nextInt(3)>1?0:r.nextInt(2)==0?4:5);
		for (int lx = x - r.nextInt(4) -7; lx < x+r.nextInt(4)+7; lx++){
			for (int ly = y - r.nextInt(4)-7; ly < y+r.nextInt(4)+7; ly++){
				if (r.nextInt(40)<37){
					Block.values()[w.getBlockID(lx, ly)].getBlock().onBlockDestroyedByExplosion(lx, ly, "TNT", w);
					w.setBlock(lx, ly, 16);
					w.setBack(lx, ly, r.nextInt(3)>1?0:r.nextInt(2)==0?4:5);
				}
			}
		}
	}

	void onEntityWalk(Entity entity, int x, int y) {
		
	}

	void onTick(int x, int y, World w) {
		if (r.nextInt(50)==0){
			playSound("Sound/boom.wav");
			w.setBlock(x, y, 0);
			w.setBack(x, y, r.nextInt(3)>1?0:r.nextInt(2)==0?4:5);
			for (int lx = x - r.nextInt(4) -7; lx < x+r.nextInt(4)+7; lx++){
				for (int ly = y - r.nextInt(4)-7; ly < y+r.nextInt(4)+7; ly++){
					if (r.nextInt(40)<37){
						Block.values()[w.getBlockID(lx, ly)].getBlock().onBlockDestroyedByExplosion(lx, ly, "TNT", w);
						w.setBlock(lx, ly, 16);
						w.setBack(lx, ly, r.nextInt(3)>1?0:r.nextInt(2)==0?4:5);
					}
				}

			}
			
			
			
		}
	}

	Effect getEffectOnDestroy(int x, int y) {
		return null;
	}

	Image getImage(int x, int y, World w) {
		return new ImageIcon("Images/TNT.png").getImage();
	}

Random r;
}
