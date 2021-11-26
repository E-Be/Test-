package states;

import java.awt.Graphics;

import main.Handler;

public abstract class States {
	
	private static States currentState = null;

	public static States getCurrentState() {
		return currentState;
	}

	public static void setCurrentState(States currentState) {
		States.currentState = currentState;
	}
	
	public States(Handler handler) {
		this.handler = handler;
	}
	
	protected Handler handler;

	public abstract void tick();
	
	public abstract void render(Graphics g);
	

}
