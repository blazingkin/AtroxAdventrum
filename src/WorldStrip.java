import java.util.*;


public class WorldStrip {
	
	
	public WorldStrip(atroxMain am, int realx){
		main = am;
		worldMeta = new LinkedList<Integer>();
		worldBlocks = new LinkedList<Integer>();
		worldLight = new LinkedList<Integer>();
		for (int i = 0; i < 400; i++){
			worldMeta.add(0);
			worldBlocks.add(1);
			worldLight.add(0);
		}
	}

	public int getBlockID(int y) {
		if (y > worldBlocks.size()){
			worldBlocks.set(y, 0);
		}
		return worldBlocks.get(y);
	}

	public int getBlockMetadata(int y) {
		if (y > worldMeta.size()){
			worldMeta.set(y, 0);
		}
		return worldMeta.get(y);
	}

	public void setBlockID(int y, int newId) {
		worldBlocks.set(y, newId);
	}

	public void setBlockMetadata(int y, int newMeta) {
		worldMeta.set(y, newMeta);
	}
	
	public void setBlockLightValue(int y, int newValue){
		worldLight.set(y, newValue);
	}
	
	public int getBlockLight(int y) {
		if (y > worldLight.size()){
			worldLight.set(y, 0);
		}
		return worldLight.get(y);
	}
	

	
	private List<Integer> worldBlocks;
	private List<Integer> worldMeta;
	private List<Integer> worldLight;
	public atroxMain main;
}
