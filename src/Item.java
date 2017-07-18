import javax.swing.*;


public enum Item {
	
	DirtBlock(new ItemBlock(1, 0, "Dirt", new ImageIcon("Images/Dirt.png").getImage())),
	StoneBlock(new ItemBlock(2, 1, "Stone", new ImageIcon("Images/Stone.png").getImage())),
	WoodenPickaxe(new ItemTool(new ImageIcon("Images/TempWoodenPickaxe.png").getImage(), 2)),
	ItemCoal(new ItemUseless(new ImageIcon("Images/TempCoalIcon.png").getImage(), 3, "Coal")),
	ItemWood(new ItemBlock(5, 4,"Log", new ImageIcon("Images/Wood.png").getImage())),
	ItemStick(new ItemUseless(new ImageIcon("Images/stick.png").getImage(), 5, "Stick")),
	SandBlock(new ItemBlock(8,6,"Sand", new ImageIcon("Images/sand.png").getImage())),
	CactusBlock(new ItemBlock(9,7,"Cactus",new ImageIcon("Images/cactus.png").getImage())),
	DirtBack(new ItemBack(1,8,"Dirt Backing",new ImageIcon("Images/BGround.png").getImage())),
	CobbleBack(new ItemBack(3,9,"Cobble Backing",new ImageIcon("Images/BCobble.png").getImage())),
	WaterBucket(new ItemBlock(10,10,"Water",new ImageIcon("Images/Water1.png").getImage())),
	HalfWaterBucket(new ItemBlock(12,11,"HalfWater",new ImageIcon("Images/Water3.png").getImage())),
	TNTBlock(new ItemBlock(15,12,"TNT",new ImageIcon("Images/TNT.png").getImage())),
	ItemSulphur(new ItemUseless(new ImageIcon("Images/Sulphur.png").getImage(), 13, "Sulphur")),
	FireBlock(new ItemBlock(16, 14, "Fire", new ImageIcon("Images/Fire.png").getImage()));
	
	private final ItemBase theItem;
	
	Item(ItemBase it){
		this.theItem = it;
	}
	
	public ItemBase getItem(){
		return this.theItem;
	}
}