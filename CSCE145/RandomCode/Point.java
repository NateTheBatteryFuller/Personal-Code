/**
 * @author Daniel Pade
 * @version 1.0
 */
public class Point
{
    private double x;
    private double y;

    public double getX()
    {
        return x;
    }
    public double getY()
    {
        return y;
    }

    /**
     * Finds the distance between this point and the given point
     * @param that The point to calculate the distance from this one
     * @return this distance between "this" point and "that" point
     */
    public double getDistance(Point that)
    {
        double xDiff = this.getX() - that.getX();
        double yDiff = this.getY() - that.getY();

        double dstSq = Math.pow(xDiff,2) + Math.pow(yDiff,2);
        return Math.sqrt(dstSq);
    }

    /**
     * Construct an instance of a point from two coordinates.
     * @param x
     * @param y
     */
    public Point( double x, double y )
    {
        this.x = x;
        this.y = y;
    }

    /**
     * Print out a point object
     * @return point formatted as (x, y)
     */
    @Override
    public String toString()
    {
        return "(" + String.format("%.2f", x)
            + ", " + String.format("%.2f", y) + ")";
    }

}
