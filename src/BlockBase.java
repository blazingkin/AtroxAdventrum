import java.awt.*;


public abstract class BlockBase 
{
abstract void onBlockMined(EntityPlayer entityPlayer, int x, int y, World w);
abstract void onBlockPlaced(EntityPlayer entityPlayer, int x, int y);
abstract void onBlockDestroyedByExplosion(int x, int y, String nameOfSource, World w);
abstract void onEntityWalk(Entity entity, int x, int y);
abstract void onTick(int x, int y, World w);
abstract Effect getEffectOnDestroy(int x, int y);
abstract Image getImage(int x, int y, World w);
public int lightGiven;
public int lightBlock;
public boolean canCollide;
public boolean isLiquid;
public boolean canBePlacedOn;
public ItemBase item;
public int blockId;
public int healthLeft;
public boolean onTick;
public int dropsAmmount;
public ItemBase dropItem;
public int waterHeight = -1;
public short ticknum = 1;
public void setTick(boolean tick){

	onTick = tick;
}

	
	
	
	
}
