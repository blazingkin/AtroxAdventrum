import java.awt.event.MouseEvent;




public class KeyEventImplementor {
	
	public KeyEventImplementor(atroxMain am){
		main = am;
	}
	
	public void openInventory(){
		
	}
	public void exitGame(){
		if (!main.WorldName.equals("World")){
		main.rf.SaveWorld(main.theWorld, main.WorldName, main.thePlayer);
		}
		main.stop();
	}
	public void dropItem(){
		
	}
	
	
	public void useItem(int x, int y){
		if (main.thePlayer.inventory[main.thePlayer.inventoryItemSelected-1][0].item != null){
			int testX;
			int testY;	
			testX = Math.round(main.renderer.camPosTrueRoundX + (x - x%main.camSize)/(main.camSize) + 7);
			testY =  Math.round(main.renderer.camPosTrueRoundY - (y-y%main.camSize)/(main.camSize) - 6);
		main.thePlayer.inventory[main.thePlayer.inventoryItemSelected-1][0].getItem().onItemUse(main.thePlayer,testX, testY, main.theWorld, main.thePlayer.inventory[main.thePlayer.inventoryItemSelected-1][0]);
		//main.gui.addMessage(testX+", "+testY);
		}	
	}
	public void leftClick(int x, int y){
		if (main.playing){
		if (main.running){
		
		if (main.thePlayer.inventory[main.thePlayer.inventoryItemSelected-1][0].item != null){
			int testX;
			int testY;
			testX = Math.round(main.renderer.camPosTrueRoundX + (x - x%main.camSize)/(main.camSize) + 7);
			testY =  Math.round(main.renderer.camPosTrueRoundY - (y-y%main.camSize)/(main.camSize) - 6);
		main.thePlayer.inventory[main.thePlayer.inventoryItemSelected-1][0].getItem().onItemClick(main.thePlayer,testX, testY, main.theWorld, main.thePlayer.inventory[main.thePlayer.inventoryItemSelected-1][0]);
		//main.gui.addMessage(testX+", "+testY);
		}
		}else{
		main.gui.click(x, y);
		}
		}else{
		main.menu.click(x, y);
		}
	}
	public void pauseGame(){
		if (main.running){
			//main.gui.addMessage("Paused");
			main.running = false;
			main.walking = false;
		}else{
			main.running = true;
		}
		
	}
	
	
	public void menuType(String typed){
		typed = typed.equals("Slash")?"/":typed;
		typed = typed.equals("Back Slash")?"\\":typed;
		typed = typed.equals("Semicolon")?";":typed;
		typed = typed.equals("Colon")?":":typed;
		typed = typed.substring(0, typed.length() - 1).equals("NumPad-")?typed.substring(7, typed.length()):typed;
		main.menu.typed(typed);
	}
	
	
	public void changeInventorySelected(int ammount){
		EntityPlayer p = main.thePlayer;
		p.inventoryItemSelected += ammount;
		if (p.inventoryItemSelected <= 0){
			p.inventoryItemSelected += 8;
		}else if(p.inventoryItemSelected > 8){
			p.inventoryItemSelected -= 8;
		}
	}
	public void changeInventorySelected(int to, int worthless){
		EntityPlayer p = main.thePlayer;
		p.inventoryItemSelected = to;
	}
	
	public void Jump(){	
		if (main.playing && main.running){
		main.thePlayer.Jump(main.theWorld);	
		}
	}
	public void Walk(boolean left){
		if (main.playing && main.running){
		main.walking = true;
		main.walkingleft = left;
		}
	}
	public void stopWalk(){
		main.walking = false;
	}
	
	public void handleMousePosition(MouseEvent me) {
		main.gui.setMousePos(me.getXOnScreen(), me.getYOnScreen());
	}
	
	
public atroxMain main;




}
