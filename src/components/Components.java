package components;

import entities.Entity;
import main.Handler;

public abstract class Components {

	private Entity entity;

	public final void setEntity(Entity e) {
		entity = e;
	}

	public final Entity getEntity() {
		return entity;
	}

	final protected <T> T getSystem(Class<T> clazz) throws IllegalArgumentException,
	NullPointerException {
		return entity.getHandler().getSystem(clazz);
	}
	
	final protected <T> T getComponent(Class<T> clazz)
            throws IllegalArgumentException, NullPointerException {
        return entity.getComponent(clazz);
    }
	
	final protected Handler getHandler() throws NullPointerException {
        return entity.getHandler();
    }

}
