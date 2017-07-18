
import java.awt.Image;

public abstract class Entity {
	public void fall(World w){
		if (gravity){
		for (int inc = 0; inc <10; inc++){
		if((w.getBlockID(Math.round(posX), Math.round(posY-0.1F))==0 && w.getBlockID(Math.round(posX-0.3F), Math.round(posY-0.1F))==0 && w.getBlockID(Math.round(posX+0.3F), Math.round(posY-0.1F))==0)||(Block.values()[w.getBlockID(Math.round(posX), Math.round(posY-0.1F))].getBlock().isLiquid && Block.values()[w.getBlockID((int)Math.round(posX-0.3), Math.round(posY-0.1F))].getBlock().isLiquid && Block.values()[w.getBlockID((int)Math.round(posX+0.3), Math.round(posY-0.1F))].getBlock().isLiquid)){
			canJump = false;
			posY -= 0.1F;
		}else{
			canJump = true;
			Block.values()[w.getBlockID(Math.round(posX), Math.round(posY-0.1F))].getBlock().onEntityWalk(this, Math.round(posX), Math.round(posY-0.1F));
			Block.values()[w.getBlockID(Math.round(posX-0.3F), Math.round(posY-0.1F))].getBlock().onEntityWalk(this, Math.round(posX-0.3F), Math.round(posY-0.1F));
			Block.values()[w.getBlockID(Math.round(posX+0.3F), Math.round(posY-0.1F))].getBlock().onEntityWalk(this, Math.round(posX+0.3F), Math.round(posY-0.1F));
			break;
		}
		}
		}else{
			Jump(w);
		}
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
	
public void hurt(int ammount){
	Health-= ammount;
}
public abstract void Spawn(int startX, World w);
public abstract void walk(boolean left, World w);
public abstract void onEntityDeath();
public abstract void onEntityDamaged();
public abstract void onEntityDrowned();
public abstract void onEntityFall();
public abstract void onEntityHealed();
public abstract void onEntityCollide(Entity e);
public void onAi(){
	
}
public int Health;
public Image entityIcon;
public float posX;
public float posY;
public Effect stepEffect;
public Effect deathEffect;
public CollisionBounds bounds;
public boolean gravity = true;
public boolean canJump;
protected int jumpCounter = 0;
int height = 2;
int width = 1;
}
