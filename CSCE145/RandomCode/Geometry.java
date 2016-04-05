/**
 * @author Daniel Pade
 * @version 1.0
 */
import java.util.Scanner;
public class Geometry
{
    public static void main(String[] args)
    {
        Scanner console = new Scanner(System.in);
        System.out.println("Give x & y for the first point:");
        double p0x = console.nextDouble();
        double p0y = console.nextDouble();

        System.out.println("Give x & y for the second point:");
        double p1x = console.nextDouble();
        double p1y = console.nextDouble();

        System.out.println("Give x & y for the third point:");
        double p2x = console.nextDouble();
        double p2y = console.nextDouble();

        Point p0     = new Point(p0x, p0y);
        Point p1     = new Point(p1x, p1y);
        Point p2     = new Point(p2x, p2y);
        Triangle tri = new Triangle(p0, p1, p2);

        System.out.println("Area of the triangle = "
                + String.format("%.1f", tri.area()));
        System.out.println("Perimeter of the triangle = "
                + String.format("%.3f", tri.perimeter()));

        Rectangle rect = new Rectangle( p0, p1 );
        System.out.println("Area of the rectangle = "
                + String.format("%.1f", rect.area()));
        System.out.println("Perimeter of the rectangle = "
                + String.format("%.3f", rect.perimeter()));
    }
}
