import java.util.LinkedList;
import java.util.List;

public class WorldChunk {

public WorldChunk(atroxMain am, int realx)
{
		main = am;
	worldStrips = new LinkedList<WorldStrip>();	
	for (int i = 0; i <= 100; i++)
	{
	worldStrips.add(new WorldStrip(main, realx));	
	}
	
}
	
	
	
private List<WorldStrip> worldStrips;



public int getBlockID(int x, int y) {
	return worldStrips.get(x).getBlockID(y);
}



public int getBlockMetadata(int x, int y) {
	return worldStrips.get(x).getBlockMetadata(y);
}



public void setBlockID(int x, int y, int newId) {
	worldStrips.get(x).setBlockID(y, newId);
}



public void setBlockMetadata(int x, int y, int newMeta) {
	worldStrips.get(x).setBlockMetadata(y, newMeta);
}	


public int getBlockLight(int x, int y) {
	return worldStrips.get(x).getBlockLight(y);
}



public void setBlockLight(int x, int y, int newId) {
	worldStrips.get(x).setBlockLightValue(y, newId);
}

private atroxMain main;

}
