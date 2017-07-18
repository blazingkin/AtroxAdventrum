import javax.swing.ImageIcon;


public enum Block {
	
	Air(new BlockEmpty(new ImageIcon("air.png").getImage())),
	Dirt(new BlockDirt()),
	Stone(new BlockStone()),
	Coal(new BlockOreCoal()),
	Grass(new BlockDirt(true)),
	Wood(new BlockWood()),
	Leaves(new BlockLeaves()),
	Plank(new BlockWood(true)),
	Sand(new BlockSand()),
	Cactus(new BlockCactus()),
	FullWater(new BlockWater(5)),
	FourWater(new BlockWater(4)),
	ThreeWater(new BlockWater(3)),
	TwoWater(new BlockWater(2)),
	LowWater(new BlockWater(1)),
	TNT(new BlockTNT()),
	Fire(new BlockFire()),
	Fluff(new BlockEmpty(new ImageIcon("Images/Cloudpng.png").getImage()));
	
	private final BlockBase theBlock;
	Block(BlockBase theBlock){
		this.theBlock = theBlock;
	}
	
	public BlockBase getBlock(){
		return this.theBlock;
	}
	
}
