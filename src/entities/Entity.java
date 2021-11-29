package entities;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import components.Components;
import main.Handler;

public class Entity {

	protected Handler handler;
	private List<Components> components = new ArrayList<>();
	private Map<Class<?>, Components> cache = new HashMap<>();

	public void render(Graphics g) {
		// TODO Auto-generated method stub

	}

	public void tick() {
		// TODO Auto-generated method stub

	}

	public boolean hasComponent(Class<?> clazz) {
		if (cache.containsKey(clazz)) {
			return true;
		}

		for (Components c : components) {
			if (clazz.isInstance(c)) {
				return true;
			}
		}
		return false;
	}

	public <T> T getComponent(Class<T> clazz) throws IllegalArgumentException {
		Components cached = cache.get(clazz);
		if (cached != null) {
			return clazz.cast(cached);
		}

		for (Components c : components) {
			if (clazz.isInstance(c)) {
				cache.put(clazz, c);
				return clazz.cast(c);
			}
		}
		throw new IllegalArgumentException("component not found "
				+ clazz.getName());
	}

	public <T> List<T> getAllComponents(Class<T> clazz) {
		ArrayList<T> result = new ArrayList<T>();
		for (Components c : components) {
			if (clazz.isInstance(c)) {
				result.add(clazz.cast(c));
			}
		}

		return result;
	}

	public void addComponent(Components c) {
		components.add(c);
		c.setEntity(this);
	}

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}
	
}
