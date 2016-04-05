/**
 * @author Daniel Pade
 * @version 1, 4 Wednesday 2013
 * This program confirms a password typed into a console window
 */
import javax.swing.JOptionPane;
public class GPasswordChecker {
    private static final String INTERNAL_PASS = "password";
    public static void main(String[] args) {

        String message = "Please enter your username";
        String user = JOptionPane.showInputDialog(message);

        message = "Please enter your password:";
        String pass = JOptionPane.showInputDialog(message);

        if (pass.equals(INTERNAL_PASS)) {
            message = "You are approved by access control!";
            JOptionPane.showMessageDialog(null, message);
            System.exit(0);
        } else {
            message = "Sorry!";
            JOptionPane.showMessageDialog(null, message);
            System.exit(1);
        }
    }
}
