/**
 * @author Daniel Pade
 * @version 1, 4 Wednesday 2013
 * This program confirms a password typed into a console window
 */
import java.util.Scanner;
public class PasswordChecker {
    private static final String INTERNAL_PASS = "password";
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Please enter your username: ");
        String user = input.next();

        System.out.print("Please enter your password: ");
        String pass = input.next();

        if (pass.equals(INTERNAL_PASS)) {
            System.out.println("You are approved by access control!");
        } else {
            System.out.println("Sorry!");
        }
    }
}
