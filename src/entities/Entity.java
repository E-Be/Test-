package entities;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import components.Components;
import main.Handler;

public class Entity {
	
	protected Handler handler;
	protected Set<Components> components = new HashSet<Components>();

	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	public void tick() {
		// TODO Auto-generated method stub
		
	}

	public void onMouseMove(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void onMouseRelease(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public Set<Components> getComponents() {
		return components;
	}

	public void setComponents(Set<Components> components) {
		this.components = components;
	}
	
	public void addComponents(Components c) {
		
		components.add(c);
		components.
		
	}
	

}
