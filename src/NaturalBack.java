import java.awt.*;
public class NaturalBack extends BackBase {
	public NaturalBack(Image i, boolean safe, boolean spawnable, int bfspawn){
		Icon = i;
		this.safe = safe;
		this.spawnable = spawnable;
		this.minLightBeforeSpawn = bfspawn;
	}
	
	
	
	public void onCoverDestroyed(int x, int y, Entity e) {
		
	}

	public void onCoverAdded(int x, int y, Entity e) {
		
	}

}
