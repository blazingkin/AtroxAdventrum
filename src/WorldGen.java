import java.awt.Color;


public class WorldGen {
public WorldGen(World wo, GuiOverlay g){
	w = wo;
	this.g = g;
}
public void generate(){
	try{
	WorldGenSurface wgs = new WorldGenSurface(w);
	g.addMessage("Making surface...", 999, Color.black);
	wgs.generate();
	WorldGenHills wgh = new WorldGenHills(w);
	g.addMessage("Making hills...", 999, Color.black);
	wgh.generate();
	WorldGenStone wgst = new WorldGenStone(w);
	g.addMessage("Making stone...", 999, Color.black);
	wgst.generate();
	WorldGenChasm wgch = new WorldGenChasm(w);
	g.addMessage("Making chasms...", 999, Color.black);
	wgch.generate();
	WorldGenCaves wgca = new WorldGenCaves(w);
	g.addMessage("Making caves...", 999, Color.black);
	wgca.generate();
	WorldGenTrees wst = new WorldGenTrees(w);
	g.addMessage("Making plants...", 999, Color.black);
	wst.generate();
	g.addMessage("Making Ores...", 999, Color.black);
	WorldGenCoal wgc = new WorldGenCoal(w);
	wgc.generate();
	g.addMessage("", 2, Color.black);
	}catch(Exception e){
	WorldGenSurface wgs = new WorldGenSurface(w);
	wgs.generate();
	WorldGenHills wgh = new WorldGenHills(w);
	wgh.generate();
	WorldGenStone wgst = new WorldGenStone(w);
	wgst.generate();
	WorldGenChasm wgch = new WorldGenChasm(w);
	wgch.generate();
	WorldGenTrees wgt = new WorldGenTrees(w);
	wgt.generate();
	WorldGenTrees wst = new WorldGenTrees(w);
	wst.generate();	
	WorldGenCoal wgc = new WorldGenCoal(w);
	wgc.generate();
	WorldGenCaves wgca = new WorldGenCaves(w);
	wgca.generate();
	}
}
	
private World w;
private GuiOverlay g;
}
