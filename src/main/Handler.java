package main;

import input.MouseManager;

public class Handler {
	
	private Game game;
	
	public Handler(Game game) {
		this.game = game;
	}

	public Game getGame() {
		return game;
	}
	
	public MouseManager getMouseManager() {
		return game.getMouseManager();
	}

	public void setGame(Game game) {
		this.game = game;
	}
	
	public int getWidth() {
		return game.getWidth();
	}
	
	public int getHeight() {
		return game.getHeight();
	}

}
