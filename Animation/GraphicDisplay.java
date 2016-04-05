import java.awt.*;
import javax.swing.*;
public class GraphicDisplay extends JFrame {
	
	private Point[] node = new Point[7];
	
	public GraphicDisplay() throws HeadlessException
	{
		super("Graph Display");
		setSize(400, 400);
		setVisible(true);
		node[0]= new Point(360, 140);
		node[1]= new Point(130, 78);
		node[2]= new Point(38, 300);
		node[3]= new Point(275, 275);
		node[4]= new Point(280, 45);
		node[5]= new Point(350, 190);
		node[6]= new Point(30, 90);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBackground(Color.LIGHT_GRAY);
	}
	public void paint(Graphics g)
	{
		
		g.setColor(Color.GREEN);
//		g.drawArc(x, y, width, height, startAngle, arcAngle);
		g.drawArc(node[0].getX(), node[0].getY(), 30, 30, 0, 360);
		g.drawArc(node[1].getX(), node[1].getY(), 30, 30, 0, 360);
		g.drawArc(node[2].getX(), node[2].getY(), 30, 30, 0, 360);
		g.drawArc(node[3].getX(), node[3].getY(), 30, 30, 0, 360);
		g.drawArc(node[4].getX(), node[4].getY(), 30, 30, 0, 360);
		g.drawArc(node[5].getX(), node[5].getY(), 30, 30, 0, 360);
		g.drawArc(node[6].getX(), node[6].getY(), 30, 30, 0, 360);
		g.setColor(Color.GREEN);
//		g.drawLine(x1, y1, x2, y2);
		g.drawLine(node[0].getX()+15, node[0].getY()+15, node[1].getX()+15, node[1].getY()+15);
		g.drawLine(node[1].getX()+15, node[1].getY()+15, node[2].getX()+15, node[2].getY()+15);
		g.drawLine(node[2].getX()+15, node[2].getY()+15, node[3].getX()+15, node[3].getY()+15);
		g.drawLine(node[3].getX()+15, node[3].getY()+15, node[4].getX()+15, node[4].getY()+15);
		g.drawLine(node[4].getX()+15, node[4].getY()+15, node[5].getX()+15, node[5].getY()+15);
		g.drawLine(node[5].getX()+15, node[5].getY()+15, node[6].getX()+15, node[6].getY()+15);
		g.drawLine(node[5].getX()+15, node[5].getY()+15, node[3].getX()+15, node[3].getY()+15);
		g.setColor(Color.BLACK);
//		g.drawString(str, x, y);
		g.drawString("0", node[0].getX(), node[0].getY());
		g.drawString("1", node[1].getX(), node[1].getY());
		g.drawString("2", node[2].getX(), node[2].getY());
		g.drawString("3", node[3].getX(), node[3].getY());
		g.drawString("4", node[4].getX(), node[4].getY());
		g.drawString("5", node[5].getX(), node[5].getY());
		g.drawString("6", node[6].getX(), node[6].getY());
	}
	
	public static void main(String[] args) {
		new GraphicDisplay();
		
		
	}

}
