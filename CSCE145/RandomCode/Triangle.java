/**
 * @author Daniel Pade
 * @version 1.0
 */
public class Triangle
{
    private Point a;
    private Point b;
    private Point c;

    /**
     * Construct an instance of a triangle from three points (vertices)
     * @param a Point 1
     * @param b Point 2
     * @param c Point 3
     */
    public Triangle(Point a, Point b, Point c)
    {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * @return the perimeter of the triangle
     */
    public double perimeter()
    {
        return side1() + side2() + side3();
    }

    /**
     * Area found with Heron's formula
     * @return area of the triangle
     */
    public double area()
    {
        // s = semiperimeter
        double s = perimeter() / 2.;
        double aSqr = s*( s - side1() ) * ( s - side2() ) * ( s - side3() );
        return Math.sqrt(aSqr);
    }

    /**
     * Measures the length between points a and b
     * @return distance between points a & b
     */
    public double side1()
    {
        return a.getDistance(b);
    }

    /**
     * Measures the length between points b and c
     * @return distance between points b & c
     */
    public double side2()
    {
        return b.getDistance(c);
    }

    /**
     * Measures the length between points a and c
     * @return distance between points a & c
     */
    public double side3()
    {
        return a.getDistance(c);
    }
}
