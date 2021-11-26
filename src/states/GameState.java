package states;

import java.awt.Color;
import java.awt.Graphics;

import graphics.Assets;
import graphics.AssetsFonts;
import graphics.Text;
import main.Handler;

public class GameState extends States{
	
	private int x=0;
	
	public GameState(Handler handler) {
		super(handler);
		
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		x+=1;
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(Assets.sword, 500, 0, null);
		Text.drawText(g, "Coucou", x, 200, true, Color.BLACK, AssetsFonts.typeWriter24);
	}
	
}
