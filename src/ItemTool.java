import java.awt.*;


public class ItemTool extends ItemBase {
	
	public ItemTool(Image icon, int id){
		itemIcon = icon;
		isBlock = false;
		itemName = "tool";
		itemId = id;
	}

	public void onItemUse(EntityPlayer entityPlayer, int x, int y, World w, itemStack is) {
	}

	public void onItemClick(EntityPlayer entityPlayer, int x, int y, World w, itemStack is) {
		if (w.getBlockID(x, y) != 0){
			if (Block.values()[w.getBlockID(x, y)].getBlock().canCollide == true){
			entityPlayer.addToInventory(Block.values()[(w.getBlockID(x, y))].getBlock().item.itemId, 1);	
			Block.values()[(w.getBlockID(x, y))].getBlock().onBlockMined(entityPlayer, x, y, w);
			}
			w.setBlock(x, y, 0);
		}
	}

	public void onItemDrop(EntityPlayer entityPlayer, World w) {
		
	}

	public void onItemEquip(EntityPlayer entityPlayer, World w) {
		
	}

}
