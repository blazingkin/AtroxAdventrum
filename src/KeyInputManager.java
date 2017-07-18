import java.awt.*;
import java.awt.event.*;
public class KeyInputManager implements KeyListener, MouseListener, MouseWheelListener, MouseMotionListener
{
	
	
	
	public KeyInputManager(KeyEventImplementor k){
		ki = k;
	}

	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if (ki.main.playing || keyCode == e.VK_ESCAPE){
		if (keyCode == e.VK_ESCAPE)
		{
			ki.exitGame();
		}if(keyCode == e.VK_E){
			ki.openInventory();
		}if (keyCode == e.VK_Q){
			ki.dropItem();
		}if (keyCode == e.VK_TAB){
			ki.pauseGame();
		} if(keyCode == e.VK_A || keyCode == e.VK_LEFT){
			ki.Walk(true);
		} if(keyCode == e.VK_D || keyCode == e.VK_RIGHT){
			ki.Walk(false);
		} if(keyCode == e.VK_SPACE){
			ki.Jump();
		} if(keyCode == e.VK_1){
			ki.changeInventorySelected(1, 0);
		} if(keyCode == e.VK_2){
			ki.changeInventorySelected(2, 0);
		} if(keyCode == e.VK_3){
			ki.changeInventorySelected(3, 0);
		} if(keyCode == e.VK_4){
			ki.changeInventorySelected(4, 0);
		} if(keyCode == e.VK_5){
			ki.changeInventorySelected(5, 0);
		} if(keyCode == e.VK_6){
			ki.changeInventorySelected(6, 0);
		} if(keyCode == e.VK_7){
			ki.changeInventorySelected(7, 0);
		} if(keyCode == e.VK_8){
			ki.changeInventorySelected(8, 0);
		} 
		}else{
			
			if (keyCode != e.VK_ENTER && keyCode != e.VK_SHIFT && keyCode != e.VK_QUOTE){
			String text = e.getKeyText(keyCode);
			text = text.equals("Space")?" ":text;
			ki.menuType(text);
			}
		}
		
	}

	public void keyReleased(KeyEvent e) {
	int keyCode = e.getKeyCode();
		if (keyCode == e.VK_A||keyCode == e.VK_D || keyCode == e.VK_LEFT || keyCode == e.VK_RIGHT){
			ki.stopWalk();
		}
		
	}

	public void keyTyped(KeyEvent e) {
	}

	public void mouseClicked(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	if (e.getButton() == e.BUTTON1){
		ki.leftClick(e.getXOnScreen(), e.getYOnScreen());
	}else{
		ki.useItem(e.getX(), e.getY());
	}
	}

	public void mouseReleased(MouseEvent e) {
	}
	
	public void mouseWheelMoved(MouseWheelEvent mwe) {
		ki.changeInventorySelected(mwe.getWheelRotation());
	}

public KeyEventImplementor ki;

public void mouseDragged(MouseEvent me) {
	ki.handleMousePosition(me);
}

public void mouseMoved(MouseEvent me) {
	ki.handleMousePosition(me);
}

}
