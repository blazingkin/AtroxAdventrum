import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;

import javax.swing.ImageIcon;

public class ScreenOutput {

	public ScreenOutput(Window w, atroxMain am){
		height = w.getHeight();
		width = w.getWidth();
		main = am;
	}
	
	
public void render(Graphics2D g){
	try{
	g.clearRect(0, 0, width, height);
	
	float cameraPosX = main.thePlayer.posX;
	float cameraPosY = main.thePlayer.posY;
	int camPosRoundX = Math.round(cameraPosX);
	int camPosRoundY = Math.round(cameraPosY);
	camPosTrueRoundX = camPosRoundX - 1080/main.camSize;
	camPosTrueRoundY = camPosRoundY + 720/main.camSize;
	int screenX = 2*-main.camSize;
	int screenY = 2*-main.camSize;
	diffX = Math.round(width*(camPosRoundX - cameraPosX));
	diffY = Math.round(height*(camPosRoundY - cameraPosY));
	
	if (camPosRoundY > 275){
	g.setColor(Color.blue);
	}else{
		g.setColor(Color.DARK_GRAY);
	}
	//g.fillRect(0, 0, width, height);
	int plx = 0;
	int ply = 0;
	for (int x = camPosRoundX - (1080/main.camSize)+5; x<=camPosRoundX + (1080/main.camSize)+2; x++){
		for (int y = camPosRoundY + (720/main.camSize)-5; y>=camPosRoundY - (720/main.camSize)+2; y--){
			Image nextIm;
			if (x == camPosRoundX && y == camPosRoundY){
				plx = screenX;
				ply = screenY;
			}
			if (main.theBlocks.values()[main.theWorld.getBlockID(x,y)].getBlock().onTick){
				main.tickBlocks.add(main.theBlocks.values()[main.theWorld.getBlockID(x,y)].getBlock());
				main.tickBlockX.add(x);
				main.tickBlockY.add(y);
			}
			nextIm = Background.values()[main.theWorld.getBack(x, y)].getBack().Icon;
			g.drawImage(nextIm, Math.round(screenX+ (main.camSize*(camPosRoundX - cameraPosX))), Math.round(screenY-(main.camSize*(camPosRoundY - cameraPosY))), main.camSize, main.camSize, null);
			nextIm = main.theBlocks.values()[main.theWorld.getBlockID(x, y)].getBlock().getImage(x, y, main.theWorld);
			g.drawImage(nextIm, Math.round(screenX+ (main.camSize*(camPosRoundX - cameraPosX))), Math.round(screenY-(main.camSize*(camPosRoundY - cameraPosY))), main.camSize, main.camSize, null);
			screenY += main.camSize;
		}
		screenX += main.camSize;
		screenY = 0;
	}
	if (playerIcon == null){
		playerIcon = main.thePlayer.entityIcon;
	}
	//g.drawImage(main.thePlayer.entityIcon,plx, ply-(int)((main.camSize*2)-(main.camSize*0.5)), main.camSize, main.camSize*2, null);
	
	for (int i = 0; i < main.entities.size(); i++){
		g.drawImage(main.entities.get(i).entityIcon,plx - (int)((main.thePlayer.posX - main.entities.get(i).posX)* main.camSize),(ply - (int)((main.entities.get(i).posY - main.thePlayer.posY )* main.camSize))-(main.entities.get(i).height/2)*main.camSize-main.camSize/3,main.entities.get(i).width*main.camSize,main.entities.get(i).height*main.camSize,null);
	}
	
	
	g.setColor(Color.white);
	g.drawString("Atrox Adventrum Alpha 0.4", 1100, 20);
	}catch (Exception e){}
	
	
}

public int camPosTrueRoundX;
public int camPosTrueRoundY;
public int height;
public int width;
public int diffX;
public int diffY;
int test;
public atroxMain main;
private Image playerIcon;


}

