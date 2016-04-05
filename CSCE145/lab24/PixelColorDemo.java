import java.awt.image.*;
import java.awt.geom.*;
import java.awt.*;

public class PixelColorDemo {
  public static void main(String[] args) {
    int x = 300, y = 80;
    DrawingKit dk = new DrawingKit("Jesus and Scenery", 1600, 800);
    BufferedImage pict = dk.loadPicture("picture_jesus_4.jpg");
    BufferedImage pict2 = dk.loadPicture("beautifulscenery.jpg");

    // get pixel value at location (500, 80)
    // change the color of the pixel to be pure red
  
    // update the pixel color in picture 
    for (int i = 44; i<295; i++)
    {
    	x=i;
    	for (int j = 43; j<321; j++)
    	{
    		y=j;
    		int encodedPixelColor = pict.getRGB(x, y);
    		Color pixelColor = new Color(encodedPixelColor);
    		int encodedPixelColor2 = pict2.getRGB(x, y);
    		Color pixelColor2 = new Color(encodedPixelColor2);
    		System.out.println(pixelColor);     
    		int red =  (int)((pixelColor.getRed()*.9)+(pixelColor2.getRed()*.1));
    		int green = (int)((pixelColor.getGreen()*.9)+(pixelColor2.getGreen()*.1));
    		int blue =  (int)((pixelColor.getBlue()*.9)+(pixelColor2.getBlue()*.1)); 
    		Color newPixelColor = new Color(red, green, blue);
    		pict2.setRGB(x+275, y+75, newPixelColor.getRGB());
    	}
    }
    // display the approximate location of the pixel
    dk.drawPicture(pict, 0, 0);    
    BasicStroke s = new BasicStroke(3);
    dk.setStroke(s);
    Ellipse2D.Float e = new Ellipse2D.Float(x-3, y-3, 8, 8);
    dk.draw(e);
    dk.drawString("(600, 150)", x-3, y-5);
    Rectangle2D rect = new Rectangle2D.Float(45, 45, 255, 280);
    dk.draw(rect);
    dk.drawPicture(pict2, 380, 0);
 
  }
}
