import java.awt.Graphics2D;
import java.awt.Window;
import java.util.*;


public class atroxMain extends Core {

	public static void main(String[] args) {
		new atroxMain().run();
	}

	public void update(long timePassed){
		if (running){
			//EntityBunny b = new EntityBunny(500, theWorld);
			//entities.add(b);
			//System.out.println(entities.size());
			thePlayer.fall(theWorld);
			Random r = new Random();
			r.setSeed(System.currentTimeMillis());

			for (int i = 0; i < tickBlocks.size(); i++){
				if (r.nextInt(tickBlocks.get(i).ticknum) == 0){
				tickBlocks.get(i).onTick(tickBlockX.get(i), tickBlockY.get(i), theWorld);
				}
			}
			tickBlocks.clear();
			tickBlockX.clear();
			tickBlockY.clear();
			
		r = null;
		
		for (int i = 0; i<entities.size(); i++){
			entities.get(i).onAi();
			entities.get(i).fall(theWorld);
		}
		
		if (walking){
			thePlayer.walk(walkingleft, theWorld);
		}

	}
}
	
	public void init(){
		super.init();
		playing = false;
		rf = new ReadAndWriteToFile();
		Window w = s.getFullScreenWindow();
		collisionMaster = new CollisionMaster();
		renderer = new ScreenOutput(w,this);
		gui = new GuiOverlay(this);
		menu = new Menu(this);
		w.setFocusTraversalKeysEnabled(false);
		KeyEventImplementor ki = new KeyEventImplementor(this);
		KeyInputManager kim = new KeyInputManager(ki);
		w.addKeyListener(kim);
		w.addMouseWheelListener(kim);
		w.addMouseListener(kim);
		w.addMouseMotionListener(kim);
	}
	
	public void draw(Graphics2D g) {
		if (playing){
		renderer.render(g);
		gui.render(g);
		}else{
		menu.render(g);
		gui.render(g);
		}
		
	}
	
public ScreenOutput renderer;
public World theWorld;
public Menu menu;
public CollisionMaster collisionMaster;
public EntityPlayer thePlayer;
public GuiOverlay gui;
public Block theBlocks;
public Item theItems;
public boolean running = false;
public List<BlockBase> tickBlocks = new LinkedList<BlockBase>();
public List<Integer> tickBlockX = new LinkedList<Integer>();
public List<Integer> tickBlockY = new LinkedList<Integer>();
public ReadAndWriteToFile rf;
public String WorldName = "World";
public int WorldSize = 1000;
public boolean playing;
public boolean walking;
public boolean walkingleft;
public int time = 2;
public List<Entity> entities = new LinkedList<Entity>();

public int camSize = 35;
MultiplayerConnections mpc = new MultiplayerConnections();
}
