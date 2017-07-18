import java.awt.Image;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Random;

import javax.swing.ImageIcon;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;


public class EntityPlayer extends Entity {
public int Wealth;
public itemStack[][] inventory;
public int inventoryItemSelected;
public World w;
	public EntityPlayer(){
		
	}
	
	  public void playSound(String Filename) {
		  try{
		InputStream in = new FileInputStream(Filename);
		AudioStream as = new AudioStream(in);         
		AudioPlayer.player.start(as);            
		//AudioPlayer.player.stop(as);
		  }catch(Exception e){}
		  }

	public EntityPlayer(int startX, World w){
		this.w = w;
		Health = 20;
		entityIcon = new ImageIcon("Images/TempPlayer.png").getImage();
		posX = (float)startX;
		Spawn(startX, w);
		stepEffect = new Effect(1,Math.round(posX),Math.round(posY));
		deathEffect = new Effect(1,Math.round(posX),Math.round(posY));
		bounds = new CollisionBounds(1F,2F,posX,posY);
		Wealth = 0;
		inventory = new itemStack[8][3];
		for (int i = 0; i <8;i++){
			for (int b = 0; b <3; b++){
				inventory[i][b] = new itemStack();
			}
		}
		inventoryItemSelected = 1;
	}

	
	public void Jump(World w){
		if (canJump){
			gravity = false;
		if (jumpCounter < 7){
			jumpCounter++;
			if ((w.getBlockID(Math.round(posX), Math.round(posY+0.6F)) == 0&&w.getBlockID(Math.round(posX), Math.round(posY+1.6F)) == 0)||(Block.values()[w.getBlockID(Math.round(posX), Math.round(posY+0.6F))].getBlock().isLiquid || Block.values()[w.getBlockID(Math.round(posX), Math.round(posY+1.6F))].getBlock().isLiquid)){
				posY+=0.5F;
			}	else {
				jumpCounter = 10;
			}
		}else{
			gravity = true;
			jumpCounter = 0;
			canJump = false;
		}
		}

	}
	
	
	
	public void addToInventory(int id, int ammoun){
		for (int in = 0; in <8;in++){
			for (int i = 0; i <3;i++){
				if (this.inventory[in][i].item != null){
				if (this.inventory[in][i].getItem().itemId == id){
					this.inventory[in][i].ammount += ammoun;
					return;
				}
				}
			}
		}
		for (int inc = 0; inc <3;inc++){
			for (int ic = 0; ic <8;ic++){
				if (this.inventory[ic][inc].getItem() == null){
					this.inventory[ic][inc].setItem(Item.values()[id].getItem());
					this.inventory[ic][inc].ammount = ammoun;
					return;
				}
			}
		}
		
	}
	
	public itemStack getItemStackFromInvCoords(int vec1, int vec2){
		try{
		return inventory[vec1][vec2];
		}catch(Exception e){return new itemStack();}
	}

	
	public void setContentsFromFile(int health, int posx, int posy, int wealth, itemStack[][] in){
		Health = health;
		posX = posx;
		posY = posy;
		Wealth = wealth;
		inventory = in;
	}
	
	public void Spawn(int startX, World w){
		posX = (float)startX;
		boolean looking = true;
		int at = 500;
		while (looking){
			at--;
			if ((w.getBlockID(startX, at)!= 0 &&  Block.values()[w.getBlockID(startX, at)].getBlock().canCollide == true )|| at == 0){
				posY = (float) at+1;
				looking = false;
			}
		}
	}
	
	public void hurt(int ammount){
		Health-= ammount;
		if (Health <= 0){
			Health = 20;
			Spawn(w.X.size()/2, w);
		}
		Random r = new Random();
		r.setSeed(System.currentTimeMillis());
		playSound(r.nextInt(2)==0?"Sound/ahh.wav":"Sound/oww.wav");
	}
	
	
	public void walk(boolean left, World w) {
		if (left){
			if ((w.getBlockID(Math.round(posX-0.75F), Math.round(posY)) == 0 && w.getBlockID(Math.round(posX-0.75F), Math.round(posY+1)) == 0)||(Block.values()[w.getBlockID(Math.round(posX-0.75F), Math.round(posY))].getBlock().isLiquid && Block.values()[w.getBlockID(Math.round(posX-0.75F), Math.round(posY+1.0F))].getBlock().isLiquid)){
				posX-=0.5F;
			}else{
				Block.values()[w.getBlockID(Math.round(posX-0.75F), Math.round(posY))].getBlock().onEntityWalk(this,Math.round(posX-0.75F), Math.round(posY));
				Block.values()[w.getBlockID(Math.round(posX-0.75F), Math.round(posY))].getBlock().onEntityWalk(this,Math.round(posX-0.75F), Math.round(posY+1));
			}
		}else{
			if ((w.getBlockID(Math.round(posX+0.75F), Math.round(posY)) == 0 && w.getBlockID(Math.round(posX+0.75F), Math.round(posY+1)) == 0)||(Block.values()[w.getBlockID(Math.round(posX+0.75F), Math.round(posY))].getBlock().isLiquid && Block.values()[w.getBlockID(Math.round(posX+0.75F), Math.round(posY+1.0F))].getBlock().isLiquid)){
			posX+=0.5F;
			}else{
				Block.values()[w.getBlockID(Math.round(posX+0.75F), Math.round(posY))].getBlock().onEntityWalk(this,Math.round(posX+0.75F), Math.round(posY));
				Block.values()[w.getBlockID(Math.round(posX+0.75F), Math.round(posY))].getBlock().onEntityWalk(this,Math.round(posX+0.75F), Math.round(posY+1));
			}
		}
	}

	public void onEntityDeath() {
		
	}

	public void onEntityDamaged() {
		
	}

	public void onEntityDrowned() {
		
	}

	public void onEntityFall() {
		
	}

	public void onEntityHealed() {
		
	}

	public void onEntityCollide(Entity e) {
		
	}

}
