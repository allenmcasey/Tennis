package tennis;

import java.awt.Color;
import java.awt.Graphics;

public class Ball {
	
	double xVel, yVel, x, y;
	int streak;
	
	public Ball() {
		streak = 0;
		x = 350;
		y = 250;
		xVel = 2 * getRandomDirection();
		yVel = 2 * getRandomDirection();
	}
	
	public int getRandomDirection() {
		int rand = (int)(Math.random() * 2);
		if(rand == 1)
			return 1;
		else
			return -1;
	}
	
	public void move() {
		x += xVel;
		y += yVel;
		
		if (y < 10)
			yVel = -yVel;
		if (y > 490)
			yVel = -yVel;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillOval((int)x - 10, (int)y - 10, 20, 20);
	}
	
	public int getStreak() {
		return streak;
	}
	
	public void checkPaddleCollision(Paddle p1, Paddle p2) {
		if(x <= 42) {
			if (y >= p1.getY() && y <= p1.getY() + 80) {
				xVel = -xVel;
				streak++;
			}
		}	
		else if (x >= 650) {
			if (y >= p2.getY() && y <= p2.getY() + 80)
				xVel = -xVel;
		}
			
	}
	
	public int getX() {
		return (int)x;
	}
	
	public int getY() {
		return (int)y;
	}
}