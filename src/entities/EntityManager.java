package entities;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import main.Handler;
import userInterface.UIObject;

public class EntityManager {
	
	private Handler handler;
	private ArrayList<Entity> entities;
	
	public EntityManager(Handler handler) {
		super();
		this.handler = handler;
		this.entities = new ArrayList<Entity>();
	}
	
	public void tick() {
		for (Entity  e : entities) {
			e.tick();
		}
	}
	
	public void render(Graphics g) {
		for (Entity  e : entities) {
			e.render(g);
		}
	}
	
	public void onMouseMove(MouseEvent e) {
		for (Entity  E : entities) {
			E.onMouseMove(e);
		}
	}
	
	public void onMouseRelease(MouseEvent e) {
		for (Entity  E : entities) {
			E.onMouseRelease(e);
		}
	}
	
	public void addObject(Entity e) {
		entities.add(e);
	}
	
	public void removeObject(Entity e) {
		entities.remove(e);
	}

	public Handler getHandler() {
		return handler;
	}
	
	
	

}
