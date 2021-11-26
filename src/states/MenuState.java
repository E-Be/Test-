package states;

import java.awt.Graphics;

import components.Health;
import entities.Entity;
import main.Handler;
import systems.Interaction;
import userInterface.Button;
import userInterface.UIManager;
import userInterface.UIObject;

public class MenuState extends States {
	
	private UIManager uiManager;
	
	public MenuState(Handler handler) {
		super(handler);
		uiManager = new UIManager(handler);
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		uiManager.tick();
		UIObject b = new Button(200,200, 100, 50);
	}

	@Override
	public void render(Graphics g) {
		//TODO
		uiManager.render(g);
	}
	
	public void init() {
		
	}

}
