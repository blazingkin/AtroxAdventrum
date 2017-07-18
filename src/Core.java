import java.awt.*;


public abstract class Core {

	private static DisplayMode modes[] = {

		new DisplayMode(1080,720,32,0),
		new DisplayMode(1080,720,24,0),
		new DisplayMode(1080,720,16,0),
		//new DisplayMode(800,600,32,0),
		//new DisplayMode(800,600,24,0),
		//new DisplayMode(800,600,16,0),

	};
	private boolean running = true;
	public ScreenManager s;
	
	public void stop(){
		running = false;
	}
	
	public void run(){
		try{
			init();
			gameLoop();
		}finally{
			s.restoreScreen();
		}
	}
	
	public void init(){
		s = new ScreenManager();
		DisplayMode dm = s.findFirstCompatibleMode(modes);
		s.setFullScreen(dm);
		
		
		Window w = s.getFullScreenWindow();
		w.setFont(new Font("Arial", Font.PLAIN, 20));
		w.setBackground(Color.black);
		w.setForeground(Color.white);
	}
	
	public void gameLoop(){
		long startTime = System.currentTimeMillis();
		long cumTime = startTime;
		
		while (running)
		{
			long timePassed = System.currentTimeMillis() - cumTime;
			cumTime += timePassed;
			
			update(timePassed);
			Graphics2D g = s.getGraphics();
			draw(g);
			g.dispose();
			s.update();
			try{
				Thread.sleep(2);
			}catch(Exception ex){}
		}
	}
	
	public void update(long timePassed){
	}
	public abstract void draw(Graphics2D g);
	
	
}
