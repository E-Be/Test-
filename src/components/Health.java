package components;

public class Health extends Components {
	
	int maxHealth;
	int currentHealth;
	
	public Health(int maxHealth) {
		super();
		this.maxHealth = maxHealth;
		this.currentHealth = maxHealth;
	}
	public int getMaxHealth() {
		return maxHealth;
	}
	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}
	public int getCurrentHealth() {
		return currentHealth;
	}
	public void setCurrentHealth(int currentHealth) {
		this.currentHealth = currentHealth;
	}
	
	

}
