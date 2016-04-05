/**
 * @author  Dan Pade
 * @version 1.2
 * Sep 12 2013
 */

import javax.swing.JOptionPane;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Color;
public class GeoGraph extends JFrame {
    private static final long serialVersionUID = 1;
    private static final double BUFFER = 1.2;

    int iDiam;
    int iRad;
    boolean fill;

    /**
     * Sets the internal diameter and radius fields based on the first
     * parameter; The boolean determines whether this object will draw filled
     * rectangles/circles or empty ones.
     * @param diameter The width of the largest square
     * @param fill Determines whether objects will be drawn empty (false) or filled.
     */
    public GeoGraph(int diameter, boolean fill) {
        this.iDiam = diameter;
        this.iRad  = iDiam / 2;
        this.fill = fill;
        setSize((int) (iDiam * BUFFER), (int) (iDiam * BUFFER));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    /**
     * A method to draw a circle with both an inscribed and circumscribed square
     * @param g The graphics object owned by this GeoGraph
     */
    @Override
    public void paint(Graphics g) {
        int center =  (int) (iDiam * BUFFER) / 2;
        int circumCoord = center - iDiam /2;
        int inscrbCoord = (int) (center - iRad / Math.sqrt(2));
        int inscrbLengt = (int) (iRad * Math.sqrt(2));
        if (fill) {
            g.setColor(Color.BLUE);
            g.fillRect(circumCoord, circumCoord, iDiam, iDiam);
            g.setColor(Color.PINK);
            g.fillOval(circumCoord, circumCoord, iDiam, iDiam);
            g.setColor(Color.YELLOW);
            g.fillRect(inscrbCoord, inscrbCoord, inscrbLengt, inscrbLengt);
        } else {
            g.drawRect(circumCoord, circumCoord, iDiam, iDiam);
            g.drawOval(circumCoord, circumCoord, iDiam, iDiam);
            g.drawRect(inscrbCoord, inscrbCoord, inscrbLengt, inscrbLengt);
        }
    }

    public static void main(String[] args) {
        String message = "Input a diameter";
        String userInput = JOptionPane.showInputDialog(message);
        double diam          = Double.parseDouble(userInput);
        double radius        = diam / 2.;
        double area          = Math.PI * Math.pow(radius,2);
        double circumference = Math.PI * diam;
        double circumSquareA = Math.pow(diam, 2);
        double inscrbSquareA = Math.pow(radius, 2) * 2; // = rad * diam
                                                        // = diam * diam / 2

        int iDiam = (int)Math.ceil(diam);

        GeoGraph win1 = new GeoGraph(iDiam, true);
        win1.setVisible(true);

        GeoGraph win2 = new GeoGraph(iDiam, false);
        win2.setVisible(true);

        String output = "";
        output += "Diameter: "           + diam   + "\n";
        output += "Radius: "             + radius + "\n";
        output += "Circumference: "      + circumference + "\n";
        output += "Inscribed Area: "     + inscrbSquareA + "\n";
        output += "Circumscribed Area: " + circumSquareA + "\n";

        JOptionPane.showMessageDialog(null, output);
    }
}
