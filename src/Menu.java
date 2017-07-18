
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import  sun.audio.*; 
import  java.io.*;


public class Menu {

	
	
	public Menu(atroxMain am){
		main = am;
	}
	  public void playSound(String Filename) {
		  try{
		InputStream in = new FileInputStream(Filename);
		AudioStream as = new AudioStream(in);         
		AudioPlayer.player.start(as);            
		//AudioPlayer.player.stop(as);
		  }catch(Exception e){}
		  }
	
	public void click(int x, int y){
		int width = main.renderer.width;
		int height = main.renderer.height;
		if (x < (width/2 - width/4)+ width/2 && x > width/2 - width/4 && y < height/5 + height/30 && height > height/5){
			if (name == ""){
			name = "World";
			}
			main.WorldName = name;
			if (main.rf.canGetWorld(name) && name != "World"){
				main.theWorld = main.rf.getWorld(name);
				main.thePlayer = main.rf.getPlayer(name);
				main.thePlayer.entityIcon = new ImageIcon("Images/TempPlayer.png").getImage();
				main.thePlayer.w = main.theWorld;
				main.entities.add(main.thePlayer);
				EntityBunny b = new EntityBunny(main.theWorld.X.size()/2, main.theWorld);
				main.entities.add(b);
			}else{
				main.theWorld = new World();
				main.theWorld.makeWorld(main, main.WorldSize);
				WorldGen generator = new WorldGen(main.theWorld, main.gui);
				generator.generate();
				main.thePlayer = new EntityPlayer(main.theWorld.X.size()/2, main.theWorld);
				main.entities.add(main.thePlayer);
				EntityBunny b = new EntityBunny(main.theWorld.X.size()/2, main.theWorld);
				main.entities.add(b);
				main.collisionMaster.addCollisionObject(main.thePlayer.bounds);
				main.thePlayer.inventory[0][0] = new itemStack(main.theItems.WoodenPickaxe.getItem(),1);
				main.thePlayer.inventory[1][0] = new itemStack(main.theItems.WaterBucket.getItem(),99);
				main.thePlayer.inventory[2][0] = new itemStack(main.theItems.TNTBlock.getItem(),99);
				main.thePlayer.inventory[3][0] = new itemStack(main.theItems.FireBlock.getItem(),99);
			}

			
			main.running = true;
			main.playing = true;
			typing = false;
		}else if (x < (width/2 - width/4)+ width/2 && x > width/2 - width/4 && y < height/4 + height/30 && height > height/4){
			if (typing){
				typing = false;
			}else{
				typing = true;
				name = "";
			}
		}else if ( x < width - 100+width/30 && x > width - 100 && y < height - 300+  height/30 && y > height - 300){
			main.camSize++;
		}else if ( x < width - 100+width/30 && x > width - 100 && y < height - 200+  height/30 && y > height - 200){
			main.camSize--;
		}
		
		
		
		
	}
	
	public void typed(String s){
		if (typing){
		if (s.equals("Backspace")){
			try{
				name = name.substring(0, name.length()-1);
			}catch(Exception e){}
		}else
		{
		name = name.toLowerCase() + s.toLowerCase();
		}
		}
	}

	public void render(Graphics2D g){
		int width = main.renderer.width;
		int height = main.renderer.height;
		g.setColor(Color.white);
		g.fillRect(0, 0, width, height);
		
		g.setColor(Color.black);
		g.setFont(new Font("Arial", Font.BOLD, 40));
		g.drawString("ATROX ADVENTRUM", width/2 - width/4, height/7);
		
		g.setColor(Color.red);
		g.fillRect(width/2 - width/4, height/5, width/2, height/30);
		g.setColor(Color.black);
		g.setFont(new Font("Arial", Font.PLAIN, 25));
		g.drawString("Play Game", width/2 - width/50, height/5 + height/35);
		
		g.setColor(Color.red);
		g.fillRect(width/2 - width/4, height/4, width/2, height/30);
		g.setColor(Color.black);
		g.setFont(new Font("Arial", Font.PLAIN, 25));
		g.drawString(typing?"Done":"Rename", width/2 - width/50, height/4 + height/35);
		g.drawString(name, width/2 - width/50 - (name.length()*(width/200)), height/4 + height/18);
		
		
		g.setColor(Color.black);
		g.setFont(new Font("Arial", Font.PLAIN, 20));
		g.drawString("Camera distance", width - 150,height - 310);
		g.fillRect(width - 100, height - 300,width/30, height/30);
		g.setColor(Color.white);
		g.drawString("^", width - 80,height - 275);
		g.setColor(Color.black);
		g.drawString(main.camSize+"",width - 90, height - 230);
		g.fillRect(width - 100, height - 200,width/30, height/30);
		g.setColor(Color.white);
		g.drawString("v", width - 80,height - 175);
	}

private String name = "";
private atroxMain main;
private boolean typing;
}
