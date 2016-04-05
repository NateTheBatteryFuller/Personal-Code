/**
 * @author Daniel Pade
 * @version 1.0
 */
public class Rectangle
{
    private Point botLeft;
    private Point topRight;

    /**
     * Constructs a rectangle given two points
     * @param a The lower left point of the rectangle
     * @param b The upper right point of the rectangle
     */
    public Rectangle(Point a, Point b)
    {
        botLeft  = a;
        topRight = b;
    }

    /**
     * Calculates the perimeter of the rectangle
     * @return the perimeter
     */
    public double perimeter()
    {
        return 2 * ( topRight.getX() - botLeft.getX()
                + topRight.getY() - botLeft.getY());
    }

    /**
     * Calculates the area of the rectangle
     * @return the area
     */
    public double area()
    {
        return ( topRight.getX() - botLeft.getX() ) *
                ( topRight.getY() - botLeft.getY() );
    }
}
