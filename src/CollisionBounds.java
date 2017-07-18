
public class CollisionBounds {
private float boxX;
private float boxY;
private float entityPosX;
private float entityPosY;

public CollisionBounds(float bX,float bY,float eX,float eY){
	this.boxX = bX;
	this.boxY = bY;
	this.entityPosX = bX;
	this.entityPosY = bY;
}

public float[] getCollisionBounds(){
	float[] tempBounds = new float[4];
	/*
	 * Template for int[]
	 * 0 - left
	 * 1 - right
	 * 2 - top
	 * 3 - bottom
	 * */
	tempBounds[0] = this.entityPosX;
	tempBounds[1] = this.boxX + this.entityPosX;
	tempBounds[2] = this.entityPosY;
	tempBounds[3] = this.entityPosY = this.boxY;
	
	return tempBounds;
	
	
	
}


	
	
}
