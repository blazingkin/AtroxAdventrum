import java.awt.Image;


public abstract class ItemBase {
	
public abstract void onItemUse(EntityPlayer entityPlayer, int x, int y, World w, itemStack is);
public abstract void onItemClick(EntityPlayer entityPlayer, int x, int y, World w, itemStack is);
public abstract void onItemDrop(EntityPlayer entityPlayer, World w);
public abstract void onItemEquip(EntityPlayer entityPlayer, World w);
public String itemName;
public Image itemIcon;
public int lightGiven;
public boolean isBlock;
public int blockId;
public int itemId = 0;
}
