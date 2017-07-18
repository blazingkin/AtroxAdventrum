import java.awt.Image;


public class ItemBack extends ItemBase {
	
	public ItemBack(int backID, int itemID, String itmName, Image itemim){
		itemName = itmName;
		itemIcon = itemim;
		isBlock = false;
		itemId = itemID;
		this.backId = backID;
	}

	
	public void onItemUse(EntityPlayer entityPlayer, int x, int y, World w, itemStack is) {
		if (w.getBlockID(x, y) == 0){
		w.setBack(x, y, backId);
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

private int backId = 0;
}
