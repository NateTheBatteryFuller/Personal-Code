import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

/**
 * The purpose of this program is to show the movement of several graphical objects in a frame
 * 
 * @author Prof. Michael Huhns
 * @version 1.0 Beta
 */
public class MovingBall2 extends JFrame implements Runnable, MouseListener {
	private Thread thread;
	private int xBall = 0;
	private int yBall = 0;
	private Color ballColor = Color.BLUE;
	final static long MILLISECONDS_DELAY = 100;
	private static JFrame window = new JFrame("Moving Ball");
	private int runCount = 0;
	private int threadCount = 100;

	// Constructor
	public MovingBall2(int xB, int yB, Color bColor, int tC) {
		xBall = xB;
		yBall = yB;
		ballColor = bColor;
		threadCount = tC;
	}
	
	public void run() {
		System.out.println("Thread count = " + threadCount);
		for (int n = 0; n < 100; n++) {
			Graphics g = window.getContentPane().getGraphics();
			g.setColor(Color.WHITE);
			g.fillOval(xBall, yBall, 20, 20);
			yBall = (int) (yBall + Math.random()*10-5);
			xBall = (int)(xBall + Math.random()*10-5);
			if (yBall > 380) yBall = 0;
			g.setColor(ballColor);
			g.fillOval(xBall, yBall, 20, 20);
//			System.out.println("Thread " + Thread.currentThread().getName() + " Run count = " + runCount++);
			try {
				Thread.sleep(MILLISECONDS_DELAY * threadCount);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	private Color createRandomColor() 
	{
		return new Color ((int) (Math.random()*128)+128, (int)(Math.random() *128)+128, (int)(Math.random()*128)+128);
	}
	
	
	public void mouseClicked(MouseEvent arg0) {
		System.out.println("Mouse clicked event");
		MovingBall2 mb = new MovingBall2(arg0.getX(), arg0.getY(), createRandomColor(), 1);
		mb.thread = new Thread(mb);
		mb.thread.start();
	}
	public void mouseEntered(MouseEvent arg0) {
		System.out.println("Mouse entered event");
	}
	public void mouseExited(MouseEvent arg0) {
		System.out.println("Mouse exited event");
	}
	public void mousePressed(MouseEvent arg0) {
		System.out.println("Mouse pressed event");
	}
	public void mouseReleased(MouseEvent arg0) {
		System.out.println("Mouse released event");
	}

	public static void main(String[] args) {
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			window.setSize(400, 400);
			Container c = window.getContentPane();
			c.setBackground(Color.WHITE);
			window.setVisible(true);
			MouseListener mouseListener = null;
			c.addMouseListener(mouseListener);
			MovingBall2 mb1 = new MovingBall2(20, 0, Color.BLUE, 1);
			mb1.thread = new Thread(mb1);
			mb1.thread.start();
//			MovingBall2 mb2 = new MovingBall2(40, 0, Color.RED, 2);
//			mb2.thread = new Thread(mb2);
//			mb2.thread.start();
//			MovingBall2 mb3 = new MovingBall2(60, 0, Color.GREEN, 3);
//			mb3.thread = new Thread(mb3);
//			mb3.thread.start();
			c.addMouseListener(mb1);
			
		}
}
