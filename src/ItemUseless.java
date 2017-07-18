import java.awt.Image;


public class ItemUseless extends ItemBase {
	
	public ItemUseless(Image icon, int id, String Name){
		itemIcon = icon;
		isBlock = false;
		itemName = Name;
		itemId = id;
	}

	public void onItemUse(EntityPlayer entityPlayer, int x, int y, World w, itemStack is) {

	}

	public void onItemClick(EntityPlayer entityPlayer, int x, int y, World w, itemStack is) {

	}

	public void onItemDrop(EntityPlayer entityPlayer, World w) {
		
	}

	public void onItemEquip(EntityPlayer entityPlayer, World w) {
		
	}

}
