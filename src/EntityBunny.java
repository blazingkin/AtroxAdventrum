
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Random;

import javax.swing.ImageIcon;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;


public class EntityBunny extends Entity {
public World w;
public int prevHealth = 3;
private boolean dir = true;
	
	  public void playSound(String Filename) {
		  try{
		InputStream in = new FileInputStream(Filename);
		AudioStream as = new AudioStream(in);         
		AudioPlayer.player.start(as);            
		//AudioPlayer.player.stop(as);
		  }catch(Exception e){}
		  }

	public EntityBunny(int startX, World w){
		this.w = w;
		width = 1;
		height = 1;
		Health = 3;
		entityIcon = new ImageIcon("Images/bunny.png").getImage();
		posX = (float)startX;
		Spawn(startX, w);
		stepEffect = new Effect(1,Math.round(posX),Math.round(posY));
		deathEffect = new Effect(1,Math.round(posX),Math.round(posY));
		bounds = new CollisionBounds(1F,2F,posX,posY);
	}

	
	public void Jump(World w){
		if (canJump){
			gravity = false;
		if (jumpCounter < 7){
			jumpCounter++;
			if ((w.getBlockID(Math.round(posX), Math.round(posY+0.6F)) == 0)||(Block.values()[w.getBlockID(Math.round(posX), Math.round(posY+0.6F))].getBlock().isLiquid)){
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
		playSound("Sound/bunny.wav");
	}
	
	
	public void walk(boolean left, World w) {
		if (left){
			if ((w.getBlockID(Math.round(posX-0.75F), Math.round(posY)) == 0 && w.getBlockID(Math.round(posX-0.75F), Math.round(posY+1)) == 0)||(Block.values()[w.getBlockID(Math.round(posX-0.75F), Math.round(posY))].getBlock().isLiquid && Block.values()[w.getBlockID(Math.round(posX-0.75F), Math.round(posY+1.0F))].getBlock().isLiquid)){
				posX-=0.35F;
			}else{
				Block.values()[w.getBlockID(Math.round(posX-0.75F), Math.round(posY))].getBlock().onEntityWalk(this,Math.round(posX-0.75F), Math.round(posY));
				Block.values()[w.getBlockID(Math.round(posX-0.75F), Math.round(posY))].getBlock().onEntityWalk(this,Math.round(posX-0.75F), Math.round(posY+1));
			}
			entityIcon = new ImageIcon("Images/bunnyl.png").getImage();
		}else{
			if ((w.getBlockID(Math.round(posX+0.75F), Math.round(posY)) == 0 && w.getBlockID(Math.round(posX+0.75F), Math.round(posY+1)) == 0)||(Block.values()[w.getBlockID(Math.round(posX+0.75F), Math.round(posY))].getBlock().isLiquid && Block.values()[w.getBlockID(Math.round(posX+0.75F), Math.round(posY+1.0F))].getBlock().isLiquid)){
			posX+=0.35F;
			}else{
				Block.values()[w.getBlockID(Math.round(posX+0.75F), Math.round(posY))].getBlock().onEntityWalk(this,Math.round(posX+0.75F), Math.round(posY));
				Block.values()[w.getBlockID(Math.round(posX+0.75F), Math.round(posY))].getBlock().onEntityWalk(this,Math.round(posX+0.75F), Math.round(posY+1));
			}
			entityIcon = new ImageIcon("Images/bunny.png").getImage();
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
	
	public void onAi(){
		Random r = new Random();
		r.setSeed(System.currentTimeMillis() + (int)posX + (int)posY);
		if (prevHealth > Health || r.nextInt(20) == 0){
			Jump(w);
		}
		if (r.nextInt(75) == 0){
			playSound("Sound/hmm.wav");
		}
		
		
		if (dir && r.nextInt(45) > 1){
			dir = true;
		}else{
			if (r.nextInt(45) < 43){
			dir = false;
			}else{
				dir = true;
			}
		}
		
		walk(dir, w);
		r = null;
	}

}
