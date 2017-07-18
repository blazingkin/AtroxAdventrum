
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.*;
import javax.swing.ImageIcon;


public class GuiOverlay {
	
	public GuiOverlay(atroxMain am){
		main = am;
		cm.addRecipes();
	}
	
	public void click(int x, int y){
		/*if (y > 700 && y < 720 && x < 1080 && x > 1000){
			addMessage("Saving",20);
			main.rf.SaveWorld(main.theWorld, main.WorldName, main.thePlayer);
			addMessage("Saved",20);
		}*/
		
		if ((y < (1+1)*10+(1*35) + 35 && y > 0)||(y < (2+1)*10+(2*35) + 35 && y > 0)||(y < (3+1)*10+(3*35) + 35 && y > 0)){
			try{
			x-=205;
			x-=x%45;
			int num = x/45;
			y+=45;
			if (y < 90){y = 0;}
			if (y < (2+1)*10+(2*35) + 35 && y > (2+1)*10+(2*35)){
				y = 1;
			}
			if (y < (3+1)*10+(3*35) + 35 && y > (3+1)*10+(3*35)){
				y = 2;
			}
			if (y > 2 || y <0){
				y = 0;
			}
			
			
			if (itemFollowingCursor.item == null && main.thePlayer.inventory[num][y].item != null){
				itemFollowingCursor.item = main.thePlayer.inventory[num][y].item;
				itemFollowingCursor.ammount = main.thePlayer.inventory[num][y].ammount;
				main.thePlayer.inventory[num][y].item = null;
				main.thePlayer.inventory[num][y].ammount = 0;
			}else if (itemFollowingCursor.item != null && main.thePlayer.inventory[num][y].item == null){
				main.thePlayer.inventory[num][y].item = itemFollowingCursor.item;
				main.thePlayer.inventory[num][y].ammount = itemFollowingCursor.ammount;
				itemFollowingCursor.item = null;
				itemFollowingCursor.ammount = 0;
			}
		}catch(Exception e){}

			
			
		return;	
		}

		if (y > main.renderer.height - main.renderer.height/10 && y < main.renderer.height - main.renderer.height/10 + main.renderer.height/30 && x > main.renderer.width - main.renderer.width/25 && x < main.renderer.width - main.renderer.width/25+main.renderer.width/25){
			addMessage("Saving",99999);
			main.rf.SaveWorld(main.theWorld, main.WorldName, main.thePlayer);
			addMessage("Done",20);
		}
		
		if (y > main.renderer.height - main.renderer.height/30 && x > main.renderer.width - main.renderer.width/25){
			addMessage("Saving",20);
			main.rf.SaveWorld(main.theWorld, main.WorldName, main.thePlayer);
			main.entities.add(main.thePlayer);
			main.playing = false;
		}
		
		List<itemStack> crafts = cm.getPossibleCraftingRecipes(main.thePlayer.inventory);
		for (int i = 0; i < crafts.size(); i++ ){
			if (y < 850 && y > 800 && x>i*50 && x < (i*50)+50){
				cm.craftItemBasedOnItemStack(crafts.get(i), main.thePlayer);
			}
			
			
		}
		
		
		
	}

	public void render(Graphics2D g){
		
		if (displayMessage){
			g.setColor(messcolor==null?Color.black:messcolor);
			messcolor = null;
			g.drawString(message,100+scinceMessage, 710);
			scinceMessage+= 1;
			if (scinceMessage == displayFor){displayMessage = false;}
		}
		
		if (main.playing){
		for (int i = 0; i < 8; i++){
			g.setFont(new Font("Arial", Font.PLAIN, 18));
			g.setColor(Color.white);
			if (!(i+1 == main.thePlayer.inventoryItemSelected)){
				g.drawImage(new ImageIcon("Images/InventoryBackground.png").getImage(), i*45+200,0,45,45,null);
				if (main.thePlayer.getItemStackFromInvCoords(i, 0) != null ){
				if (main.thePlayer.getItemStackFromInvCoords(i, 0).item != null){
				g.drawImage(main.thePlayer.getItemStackFromInvCoords(i, 0).item.itemIcon, i*45+205,5,35,35,null);
				if (main.thePlayer.inventory[i][0].ammount > 1)
				{
				g.drawString(""+main.thePlayer.getItemStackFromInvCoords(i, 0).ammount, i*45+(main.thePlayer.getItemStackFromInvCoords(i, 0).ammount > 9? main.thePlayer.getItemStackFromInvCoords(i, 0).ammount > 99?213:223: 233),40);
				}
				}
			}
			}else{
				g.drawImage(new ImageIcon("Images/InventoryBackgroundSelected.png").getImage(), i*45+200,5,45,45,null);
				if (main.thePlayer.getItemStackFromInvCoords(i, 0).item != null){
				g.drawImage(main.thePlayer.getItemStackFromInvCoords(i, 0).item.itemIcon, i*45+205,10,35,35,null);
				if (main.thePlayer.getItemStackFromInvCoords(i, 0).ammount > 1)
				{
				g.drawString(""+main.thePlayer.getItemStackFromInvCoords(i, 0).ammount, i*45+(main.thePlayer.getItemStackFromInvCoords(i, 0).ammount > 9? main.thePlayer.getItemStackFromInvCoords(i, 0).ammount > 99?213:223: 233),45);
				}
				}
			}
		}
		
		
		for (int i = 0; i < Math.round(main.thePlayer.Health/2);i++){
			if (Math.round((main.thePlayer.Health/2-(float)Math.round(main.thePlayer.Health/2))*2) == 1){
			g.drawImage(new ImageIcon("Images/halfHeart.png").getImage(),25,20*i+(i*5),25,25,null);
			}else{
			g.drawImage(new ImageIcon("Images/heart.png").getImage(),25,20*i+(i*5),25,25,null);
			}
		}
		
		
		if (!main.running){
			/*g.setFont(new Font("Arial", Font.PLAIN, 12));
			g.setColor(Color.white);
			g.fillRect(1000, 700, 80, 20);
			g.setColor(Color.black);
			g.drawString("Save World", 1000, 715);
			*/
			for (int d = 1; d < 3; d++){
				for (int f = 0; f < 8; f++){
					g.setFont(new Font("Arial", Font.PLAIN, 18));
					g.setColor(Color.white);
					g.drawImage(new ImageIcon("Images/InventoryBackground.png").getImage(), f*45+200,5+(d*45),45,45,null);
					if (main.thePlayer.getItemStackFromInvCoords(f, d).item != null){
					g.drawImage(main.thePlayer.getItemStackFromInvCoords(f, d).item.itemIcon, f*45+205,(d+1)*10+(d*35),35,35,null);
					if (main.thePlayer.getItemStackFromInvCoords(f, d).ammount > 1)
					{
					g.drawString(""+main.thePlayer.getItemStackFromInvCoords(f, d).ammount, f*45+(main.thePlayer.getItemStackFromInvCoords(f, d).ammount > 9? main.thePlayer.getItemStackFromInvCoords(f, d).ammount > 99?213:223: 233),d*45+45);
					}
					}
				}
			}
			
			if (itemFollowingCursor.item != null){
			g.drawImage(itemFollowingCursor.item.itemIcon,mouseX,mouseY,35,35,null);
			}
			
			g.setColor(Color.white);
			g.fillRect(main.renderer.width - main.renderer.width/25, main.renderer.height - main.renderer.height/10, main.renderer.width/25, main.renderer.height/30);
			g.setColor(Color.black);
			g.drawString("Save", main.renderer.width - main.renderer.width/25, main.renderer.height - main.renderer.height/13);
			
			g.setColor(Color.WHITE);
			g.fillRect(main.renderer.width - main.renderer.width/25, main.renderer.height - main.renderer.height/30, main.renderer.width/25, main.renderer.height/30);
			g.setColor(Color.black);
			g.drawString("X", main.renderer.width - main.renderer.width/37, main.renderer.height - main.renderer.height/70);
			
			
			List<itemStack> crafts = cm.getPossibleCraftingRecipes(main.thePlayer.inventory);
			for (int i = 0; i < crafts.size(); i++ ){
				g.setFont(new Font("Arial", Font.PLAIN, 16));
				g.drawImage(crafts.get(i).item.itemIcon,i*50,800,50,50,null);
				g.drawString(crafts.get(i).ammount+"", i*50, 850);
				
				

				
				
				
				
			}
			
			
		}
		
		
		
		
		}
		
	}
	
	public void addMessage(String message){
		this.message = message;
		this.displayMessage = true;
		this.scinceMessage = 0;
		displayFor = 200;
	}
	
	public void addMessage(String message, int fort){
		this.message = message;
		this.displayMessage = true;
		this.scinceMessage = 0;
		displayFor = fort;
	}
	
	public void addMessage(String message, int fort, Color c){
		this.message = message;
		this.displayMessage = true;
		this.scinceMessage = 0;
		this.messcolor = c;
		displayFor = fort;
	}
	public void setMousePos(int x, int y){
		mouseX = x;
		mouseY = y;
	}
	
private String message = "";
private boolean displayMessage = false;
private int scinceMessage = 0;
private int displayFor = 200;
private atroxMain main;
private CraftingManager cm = new CraftingManager();
private Color messcolor;
private itemStack itemFollowingCursor = new itemStack();
private int mouseX = 0;
private int mouseY = 0;
}
