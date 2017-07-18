import java.awt.Image;


public class ItemBlock extends ItemBase {
	
	public ItemBlock(int blockID, int itemID, String itmName, Image itemim){
		itemName = itmName;
		itemIcon = itemim;
		isBlock = true;
		blockId = blockID;
		itemId = itemID;
	}

	
	public void onItemUse(EntityPlayer entityPlayer, int x, int y, World w, itemStack is) {
		if (w.getBlockID(x, y) == 0 || Block.values()[w.getBlockID(x, y)].getBlock().isLiquid){
		w.setBlock(x, y, blockId);
		is.addToStack(-1);
		if (is.ammount <= 0){
			entityPlayer.inventory[entityPlayer.inventoryItemSelected-1][0].item = null;
		}
		}
	}

	public void onItemClick(EntityPlayer entityPlayer, int x, int y, World w, itemStack is) {
		
	}

	public void onItemDrop(EntityPlayer entityPlayer, World w) {
		
	}

	public void onItemEquip(EntityPlayer entityPlayer, World w) {
		
	}

}
