package tennis;

import java.awt.Color;
import java.awt.Graphics;

public class AIPaddle implements Paddle{

	double y, yVel;
	boolean upAccel, downAccel;
	int player, x;
	Ball b1;
	
	public AIPaddle(int player, Ball b) {
		upAccel = false; downAccel = false;
		b1 = b;
		y = 210; yVel =0;
		if (player == 1)
			x = 20;
		else
			x = 660;
	}
	public void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(x, (int)y, 12, 80);
		
	}

	public void move() {
		y = b1.getY() - 40;
		if (y < 0)
			y = 0;
		if (y > 420)
			y = 420;
	}
	
	public void setUpAccel(boolean input) {
		upAccel = input;
	}
	
	public void setDownAccel(boolean input) {
		downAccel = input;
	}
	
	public int getY() {
		return (int)y;
	}
}