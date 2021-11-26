package main;

import graphics.Assets;
import graphics.AssetsFonts;
import graphics.Display;
import graphics.ImageLoader;
import graphics.SpriteSheet;
import graphics.Text;
import input.MouseManager;
import states.GameState;
import states.MenuState;
import states.States;

import java.awt.image.BufferStrategy;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferedImage;

public class Game implements Runnable{
	
	private Display display;
	public int width, height;
	public String title;
	
	private BufferStrategy bs;
	
	private int ticks;
	
	private Graphics g;
	
	private MouseManager mouseManager;
	
	private boolean running = false;
	
	private Thread thread;
	
	private States gameState;
	private States menuState;
	
	private Handler handler;
	
	public Game(String title, int width, int height) {
		
		this.title = title;
		this.width = width;
		this.height = height;	
		
		mouseManager = new MouseManager();
		
	}

	@Override
	public void run() {
		
		init();
		
		int fps = 60;
		double timePerTick = 1_000_000_000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		ticks = 0;
		
		while (running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += (now - lastTime);
			lastTime = now;
			
			if (delta >= 1) {
				tick();
				render();
				ticks++;
				delta --;
			}
			
			if (timer >= 1_000_000_000) {
				ticks = 0;
				timer = 0;
			}
			
		}
		
		stop();
		
	}
	
	public void tick() {
		if (States.getCurrentState() != null) {
			States.getCurrentState().tick();			
		}
	}
	
	private void render() {
		
		bs = display.getCanvas().getBufferStrategy();
		if (bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		//Clear the screen
		g.clearRect(0,0, width, height);
		//Draw here
		if (States.getCurrentState() != null) {
			States.getCurrentState().render(g);			
		}
		Text.drawText(g, "FPS : " + ticks, 5, 20, false, Color.BLACK, AssetsFonts.typeWriter24);
		//To here
		bs.show();
		g.dispose();
	}
	
	public void init() {
		
		display = new Display(title, width, height);
		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);
		
		Assets.init();
		AssetsFonts.init();
		
		handler = new Handler(this);
		
		gameState = new GameState(handler);
		menuState = new MenuState(handler);
		
		States.setCurrentState(menuState);
		
	}
	
	public synchronized void start() {
		if (running) {
			return;
		}
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop() {
		if (!running) {
			return;
		}
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public MouseManager getMouseManager() {
		return mouseManager;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	
	

}
