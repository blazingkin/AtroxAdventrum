import javax.swing.*;


public enum Background {

	Air(new NaturalBack(new ImageIcon("Images/SkyBackground.png").getImage(),false,true,4)),
	Dirt(new NaturalBack(new ImageIcon("Images/Rocky_Background.png").getImage(),false,true,5)),
	Stone(new NaturalBack(new ImageIcon("Images/Stone_Background.png").getImage(),false,true,6)),
	Cobble(new NaturalBack(new ImageIcon("Images/BCobble.png").getImage(),true,false,0)),
	DarkSky(new NaturalBack(new ImageIcon("Images/DarkerSky_Background.png").getImage(),false,true,5)),
	DarkestSky(new NaturalBack(new ImageIcon("Images/DarkestSky_Background.png").getImage(),false,true,5)),
	DirtTwo(new NaturalBack(new ImageIcon("Images/BGround.png").getImage(),false,true,5));
	
	
	
	private final BackBase theBlock;
	Background(BackBase b){
		this.theBlock = b;
	}
	
	public BackBase getBack(){
		return this.theBlock;
	}
	
	
}
