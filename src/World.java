import java.util.*;


public class World {
	
public List<LinkedList<Short>> X = new LinkedList<LinkedList<Short>>();
public List<LinkedList<Byte>> Meta = new LinkedList<LinkedList<Byte>>();
public List<LinkedList<Integer>> Light = new LinkedList<LinkedList<Integer>>();
public List<LinkedList<Integer>> Back = new LinkedList<LinkedList<Integer>>();

public World(){

}
public void makeWorld(atroxMain am,int worldSize){
	Random r = new Random();
	r.setSeed(System.currentTimeMillis());
	for (int i = 0;i<worldSize;i++){
		LinkedList<Short> Y = new LinkedList<Short>();
		LinkedList<Byte> MetaY = new LinkedList<Byte>();
		LinkedList<Integer> LightY = new LinkedList<Integer>();
		LinkedList<Integer> BackY = new LinkedList<Integer>();
		for (int z = 0; z < 500; z++){
			Y.add((short) 1);
			MetaY.add((byte) 0);
			LightY.add(5);
			BackY.add(r.nextInt(2)==0?6:1);
		}
		X.add(Y);
		Meta.add(MetaY);
		Light.add(LightY);
		Back.add(BackY);

}
}
	

public int getBlockID(int x, int y){
	if (x<0||x>X.size()-1||y<0||y>499)
	{return 0;}else{	
		int id = (X.get(x)).get(y);
		return id;
	}
}	

public int getBlockMeta(int x, int y){
	int id = (Meta.get(x)).get(y);
	return id;
}	

public void setBlock(int x, int y, int newid){
	try{
	if (x<0||x>X.size()||y<0||y>499)
	{}else{	
	X.get(x).set(y, (short) newid);
	}
	}catch(Exception e){}
}




public int getLight(int x, int y){
	if (x<0||x>Light.size()-1||y<0||y>499)
	{return 0;}else{	
		int id = (Integer)(Light.get(x)).get(y);
		return id;
	}
}	

public void setLight(int x, int y, int newid){
	try{
	if (x<0||x>Light.size()||y<0||y>499)
	{}else{	
	Light.get(x).set(y, newid);
	}
	}catch(Exception e){}
}


public int getBack(int x, int y){
	if (x<0||x>Back.size()-1||y<0||y>499)
	{return 0;}else{	
		int id = (Integer)(Back.get(x)).get(y);
		return id;
	}
}	

public void setBack(int x, int y, int newid){
	try{
	if (x<0||x>Back.size()||y<0||y>499)
	{}else{	
	Back.get(x).set(y, newid);
	}
	}catch(Exception e){}
}




public void repBlock(int x, int y, int newid){
	try{
	if (x<0||x>X.size()||y<0||y>499)
	{}else{	
	if (X.get(x).get(y) == 0){
	X.get(x).set(y, (short) newid);
	}
	}
	}catch(Exception e){}
}

public void setBlockMeta(int x, int y, int newMeta){
	Meta.get(x).set(y, (byte) newMeta);
}


}
