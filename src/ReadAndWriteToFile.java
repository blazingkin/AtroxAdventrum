import java.io.*;
import java.util.*;

public class ReadAndWriteToFile{
	
	
	
  public ReadAndWriteToFile() {
    File file=new File(System.getenv("APPDATA")+"\\.Atrox Adventrum\\");
    boolean exists = file.exists();
    if (!exists) {
      try{
      file.mkdir();
      }catch(Exception e){}
    }
  }
  
  public void SaveWorld(World w, String Name, EntityPlayer ep){
	  	File folder= new File(System.getenv("APPDATA")+"\\.Atrox Adventrum\\"+Name);
	    File file=new File(folder,"World.atroxWorld");
	    File playerFile = new File(folder, "Player.atroxPlayer");
	    File playerPositionFile = new File(folder, "PlayerPosition.atroxPlayer");
	   
	    boolean exists = folder.exists();
	    if (!exists) {
	      try{
	      folder.mkdir();
	      }catch(Exception e){}
	    }
	    
	    exists = file.exists();
	    if (!exists) {
	      try{
	      file.createNewFile();
	      }catch(Exception e){}
	    }else{
	    	try{
	    		file.delete();
	    		file.createNewFile();	
	    	}catch(Exception e){}
	    }
	    
	    exists = playerFile.exists();
	    if (!exists) {
	      try{
	      playerFile.createNewFile();
	      }catch(Exception e){}
	    }else{
	    	try{
	    		playerFile.delete();
	    		playerFile.createNewFile();	
	    	}catch(Exception e){}
	    }
	    
	    exists = playerPositionFile.exists();
	    if (!exists) {
	      try{
	      playerPositionFile.createNewFile();
	      }catch(Exception e){}
	    }else{
	    	try{
	    		playerPositionFile.delete();
	    		playerPositionFile.createNewFile();	
	    	}catch(Exception e){}
	    }
	    
	    

	    
	  try{
	        Formatter output = new Formatter(playerFile);
	       Formatter out = new Formatter(playerPositionFile);
		    for (int b = 0; b< 3; b++){
		    	for (int i = 0; i< 8; i++){
			    	
		    		if (ep.inventory[i][b].item != null){
		    			output.format("%d\n",ep.inventory[i][b].item.itemId);
		    			output.format("%d\n",ep.inventory[i][b].ammount);
		    		}else{
		    			output.format("%d\n",1337);
		    			output.format("%d\n",0);
		    		}
		    		
		    		
			    }
		    }
		    
		    out.format("%d\n",Math.round(ep.posX));
		    out.format("%d\n",Math.round(ep.posY));
		    out.format("%d\n",ep.Health);
		    
		    out.close();
		    output.close();
	     
	  }catch(Exception e){System.out.println("ErrorInSavingPlayer");}
	    
	    
	    try{
	    
        Formatter out = new Formatter(file);
        out.format("%d\n",new atroxMain().WorldSize);
        for (int x = 0; x < new atroxMain().WorldSize; x++){
        	for (int y = 0; y < 500;y++){
        		out.format("%d\n%d\n",w.getBlockID(x, y),w.getBack(x, y));
        	}
        	
        }
        out.close();
	    }catch(Exception e){}
	    
	    
	    
  }
  
  public boolean canGetWorld(String fileName){
	  	World ew = new World();
	  	File folder= new File(System.getenv("APPDATA")+"\\.Atrox Adventrum\\"+fileName);
	    File file=new File(folder,"World.atroxWorld");
	    boolean exists = file.exists();
	    if (exists) {
	    return true;
	    }else{
	    return false;
	    }
  }
  
  public void deleteWorld(String fileName){
	  	World ew = new World();
	  	File folder= new File(System.getenv("APPDATA")+"\\.Atrox Adventrum\\"+fileName);
	    File file=new File(folder,"World.atroxWorld");
	    boolean exists = file.exists();
	    if (exists) {
	    file.delete();
	    folder.delete();
	    }
  }
  
  
  public World getWorld(String fileName){
	  	World ew = new World();
	  	File folder= new File(System.getenv("APPDATA")+"\\.Atrox Adventrum\\"+fileName);
	    File file=new File(folder,"World.atroxWorld");
	    boolean exists = file.exists();
	    if (exists) {
	      try{
	  	    BufferedReader s = new BufferedReader(new FileReader(file));
	    	  int numX = Integer.parseInt(s.readLine());
	    	  for (int x = 0; x < numX; x++){
	    		  ew.X.add(x,new LinkedList<Short>());
	    		  ew.Back.add(x,new LinkedList<Integer>());
	    		  for (int y = 0; y < 500; y++){
	    			  if (s.ready()){
	    			ew.X.get(x).add((short) Integer.parseInt(s.readLine()));
	    			ew.Back.get(x).add(Integer.parseInt(s.readLine()));
	    			  }else{
	    				  ew.X.get(x).add((short) 0);
	    			  }
	    		  }
	    	  }
	    	  s.close();
	      }catch(Exception e){}
	    }
	    return ew;
  }
  
  public EntityPlayer getPlayer(String fileName){
		 EntityPlayer ep = new EntityPlayer();
		  	File folder= new File(System.getenv("APPDATA")+"\\.Atrox Adventrum\\"+fileName);
		    File file=new File(folder,"Player.atroxPlayer");
		    File PosFile=new File(folder,"PlayerPosition.atroxPlayer");
		    boolean exists = file.exists();
		    if (exists) {
		      try{
			  	    BufferedReader s = new BufferedReader(new FileReader(file));
			  itemStack[][] inventory = new itemStack[8][3];
			  for (int b = 0; b < 3; b++){
				  for (int a = 0; a < 8;a++){
					  inventory[a][b] = new itemStack();
				  }
				}
			  
			  
			  for (int b = 0; b < 3; b++){
				  for (int a = 0; a < 8;a++){

						  int next;
							next = Integer.parseInt(s.readLine());
						  if (next == 1337 ){
							  inventory[a][b].item = null;
							  inventory[a][b].ammount = Integer.parseInt(s.readLine());
						  }else{
							  try{
							  inventory[a][b].item = Item.values()[next].getItem();
							  }catch(Exception e){inventory[a][b].item = null;}
							  inventory[a][b].ammount = Integer.parseInt(s.readLine());
						  }
					 
				  }
			  }
		  	    BufferedReader sc = new BufferedReader(new FileReader(PosFile));
		 ep.posX = Integer.parseInt(sc.readLine());
		 ep.posY = Integer.parseInt(sc.readLine());
		 ep.Health = Integer.parseInt(sc.readLine());
		 ep.inventoryItemSelected = 1;
		 s.close();
		 ep.inventory = inventory;
		  	} catch (IOException e) {}
		  
		   }
		   
		 
		 return ep;
	 }
  
  
}
  

