import java.util.*;


public class CollisionMaster {
	
public void addCollisionObject(CollisionBounds object){
	EntitiesandBlocks.add(object);
}

public boolean willHaveCollision(CollisionBounds object1,CollisionBounds object2, float ammount, int direction){
	//for direction 1=up 2=down 3=left 4=right
		float[] coBounds = object1.getCollisionBounds();
		float[] boBounds2 = object2.getCollisionBounds();
			switch(direction){
			
			case 1:
			if (coBounds[0] > boBounds2[0] && coBounds[1] < boBounds2[1] && coBounds[2] - ammount < boBounds2[2] && coBounds[3] > boBounds2[3] ){
				return true;
			}
			break;
			case 2:
				if (coBounds[0] > boBounds2[0] && coBounds[1] < boBounds2[1] && coBounds[2] <boBounds2[2] && coBounds[3] + ammount > boBounds2[3] ){
					return true;
				}
				break;
			case 3:
				if (coBounds[0] > boBounds2[0] - ammount && coBounds[1] <boBounds2[1] && coBounds[2] < boBounds2[2] && coBounds[3] > boBounds2[3] ){
					return true;
				}
				break;
			case 4:
				if (coBounds[0] > boBounds2[0] && coBounds[1] + ammount < boBounds2[1] && coBounds[2] < boBounds2[2] && coBounds[3] > boBounds2[3] ){
					return true;
				}
				break;
			
			
			
			
			
			}
	
	return false;
}

public boolean willHaveCollision(CollisionBounds object, float ammount, int direction){
	//for direction 1=up 2=down 3=left 4=right
	int objis = 3;
	for (int i = 0; i < EntitiesandBlocks.size();i++){
		if (EntitiesandBlocks.get(i) == object){
			objis = i;
		}else if(objis == -1){
			objis = 0;
		}
	}
	CollisionBounds theEntity = EntitiesandBlocks.get(objis);
	float[] coBounds = theEntity.getCollisionBounds();
	for (int i = 0; i < EntitiesandBlocks.size();i++){
		CollisionBounds Entity = EntitiesandBlocks.get(i);
		if (Entity != theEntity){
			switch(direction){
			
			case 1:
			if (coBounds[0] > Entity.getCollisionBounds()[0] && coBounds[1] < Entity.getCollisionBounds()[1] && coBounds[2] - ammount < Entity.getCollisionBounds()[2] && coBounds[3] > Entity.getCollisionBounds()[3] ){
				return false;
			}
			break;
			case 2:
				if (coBounds[0] > Entity.getCollisionBounds()[0] && coBounds[1] < Entity.getCollisionBounds()[1] && coBounds[2] < Entity.getCollisionBounds()[2] && coBounds[3] + ammount > Entity.getCollisionBounds()[3] ){
					return false;
				}
				break;
			case 3:
				if (coBounds[0] > Entity.getCollisionBounds()[0] - ammount && coBounds[1] < Entity.getCollisionBounds()[1] && coBounds[2] < Entity.getCollisionBounds()[2] && coBounds[3] > Entity.getCollisionBounds()[3] ){
					return false;
				}
				break;
			case 4:
				if (coBounds[0] > Entity.getCollisionBounds()[0] && coBounds[1] + ammount < Entity.getCollisionBounds()[1] && coBounds[2] < Entity.getCollisionBounds()[2] && coBounds[3] > Entity.getCollisionBounds()[3] ){
					return false;
				}
				break;
			
			
			
			
			
			}
		}
	}
	
	return false;
}





private List<CollisionBounds> EntitiesandBlocks = new LinkedList<CollisionBounds>();
}
