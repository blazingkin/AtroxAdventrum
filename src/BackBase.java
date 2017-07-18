import java.awt.*;
public abstract class BackBase {
public Image Icon;
public boolean spawnable;
public boolean safe;
public int minLightBeforeSpawn; //light level below will allow spawn
public abstract void onCoverDestroyed(int x, int y, Entity e);
public abstract void onCoverAdded(int x, int y, Entity e);
}
