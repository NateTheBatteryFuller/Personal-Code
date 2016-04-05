/**
 * The main class that starts a game of dice.
 * @author Daniel Pade
 * @version 1.0
 */
import javax.swing.JOptionPane;
import java.util.Scanner;
import java.util.Random;
public class PlayDice {
    public static void main(String[] args) {
        String welcome = "Let's play Dice!\n";
        welcome += "Please input the names of the two players,\n"
            + "separated by a comma";
        String playerNames = JOptionPane.showInputDialog(welcome);
        Scanner nameScan = new Scanner(playerNames);
        nameScan.useDelimiter(",");
        String p1Name = nameScan.next();
        String p2Name = nameScan.next();
        nameScan.close();

        BankAccount p1 = new BankAccount(1000, p1Name);
        BankAccount p2 = new BankAccount(1000, p2Name);

        boolean p1Lost   = false;
        boolean p2Lost   = false;

        Die d1 = new Die();
        Die d2 = new Die();
        String message;
        while ( true ) {
            if ( p2.getBalance() == 0 ) {
                p2Lost = true;
                break;
            } else if ( p1.getBalance() == 0 ) {
                p1Lost = true;
                break;
            }
            boolean properP1Wager = false;
            boolean properP2Wager = false;
            int p1Wager = 0;
            int p2Wager = 0;
            // Player 1 wagers
            message = p1.getName() + ": Enter your wager (no decimals!)\n"
                + "Total Balance: " + p1.getBalance();
            String strP1Wager = JOptionPane.showInputDialog(message);
            p1Wager = Integer.parseInt(strP1Wager);
            if (p1Wager <= p1.getBalance()) {
                p1.withdraw(p1Wager);
            } else {
                message = "Cheaters aren't allowed to play!";
                JOptionPane.showMessageDialog(null, message);
                p1Lost = true;
                break;
            }
            if (p1Wager <= 0) {
                p1Lost = true;
                break;
            }
            //Player 2 wagers
            message = p2.getName() + ": Enter your wager (no decimals!)\n"
                + "Total Balance: " + p2.getBalance();
            String strP2Wager = JOptionPane.showInputDialog(message);
            p2Wager = Integer.parseInt(strP2Wager);
            if (p2Wager <= p2.getBalance()) {
                p2.withdraw(p2Wager);
            } else {
                message = "Cheaters aren't allowed to play!";
                JOptionPane.showMessageDialog(null, message);
                p2Lost = true;
                break;
            }
            if (p2Wager <= 0) {
                p2Lost = true;
                break;
            }

            int fullWager = p1Wager + p2Wager;

            int p1Roll = d1.roll();
            int p2Roll = d2.roll();
            ShowDie sd1 = d1.display(0,0);
            ShowDie sd2 = d2.display(110,0);
            message = p1.getName() + " rolls a " + p1Roll + ".\n"
                + p2.getName() + " rolls a " + p2Roll + ".\n";
            if (p1Roll > p2Roll) {
                message += "\n" + p1.getName() + " Wins!\n"
                    + fullWager + " added to " + p1.getName()
                    + "'s account";
                p1.deposit(fullWager);
            } else if (p2Roll > p1Roll) {
                message += "\n" + p2.getName() + " Wins!\n"
                    + fullWager + " added to " + p2.getName()
                    + "'s account";
                p2.deposit(fullWager);
            } else {
                // tie -> split the pot and if its odd, randomly select
                //        who gets the remainder
                message += "It's a tie!\n";
                p1.deposit(fullWager / 2);
                p2.deposit(fullWager / 2);
                if ((fullWager % 2) != 0) {
                    Random rand = new Random();
                    if (rand.nextInt(2) == 1) {
                        p2.deposit(1);
                        message += p1.getName() + " receives"
                            + " " + (fullWager / 2) + "\n"
                            + p2.getName() + " receives"
                            + " " + ((fullWager / 2) + 1);
                    } else {
                        p1.deposit(1);
                        message += p1.getName() + " receives"
                            + " " + ((fullWager / 2) + 1) + "\n"
                            + p2.getName() + " receives"
                            + " " + ((fullWager / 2));
                    }

                } else {
                    message += p1.getName() + " receives"
                        + " " + ((fullWager / 2)) + "\n"
                        + p2.getName() + " receives"
                        + " " + ((fullWager / 2));
                }

            }
            JOptionPane.showMessageDialog(null, message);
            d1.undisplay(sd1);
            d2.undisplay(sd2);

        }
        if (p1Lost) {
            message = "Congratulations " + p2.getName() + ", you won!";
        } else{
            message = "Congratulations " + p1.getName() + ", you won!";
        }
        JOptionPane.showMessageDialog(null, message);

    }
}
