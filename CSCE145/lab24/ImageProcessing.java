import java.awt.image.*;
import java.awt.geom.*;
import java.awt.*;

public class ImageProcessing{
  public static void main(String[] args) {
    int x = 300, y = 80;
    DrawingKit dk = new DrawingKit("Jesus", 800, 800);
    BufferedImage pict = dk.loadPicture("picture_jesus_4.jpg");

    // get pixel value at location (500, 80)
    int encodedPixelColor = pict.getRGB(x, y);
    Color pixelColor = new Color(encodedPixelColor);
    System.out.println(pixelColor);     
    int red =  pixelColor.getRed() ;
    int green =  pixelColor.getGreen() ;
    int blue =  pixelColor.getBlue();
    // change the color of the pixel to be pure red
    red = 255;
    green = 0;
    blue = 0;
    // update the pixel color in picture 
    for (int i = 0; i<300; i++)
    {
    	x=i;
    	for (int j = 0; j<450; j++)
    	{
    		y=j;
    		if (pict.getRGB(x, y) <-10000000)
    		{
    			Color newPixelColor = new Color(red, green, blue);
    			int newRgbvalue = newPixelColor.getRGB();
    			pict.setRGB(x, y, newRgbvalue);		
    			}
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
  }
}
