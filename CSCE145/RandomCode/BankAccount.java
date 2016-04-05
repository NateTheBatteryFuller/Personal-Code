/**
 * @author Daniel Pade
 * A class to keep track of a player's winnings in a game
 * of dice.
 */

public class BankAccount {
    private String name;
    private int balance;
    /**
     * Default Constructor
     */
    public BankAccount() {
        name = "default";
        balance = 0;
    }
    /**
     * A constructor to set the name and balance of the account
     * @param balance The integer amount of initial money for the player
     * @param name    The string value for the players name
     */
    public BankAccount(int balance, String name) {
        this.balance = balance;
        this.name = name;
    }
    /**
     * Gives the balance contained in the account
     * @return Returns the integer balance of the player
     */
    public int getBalance() {
        return balance;
    }
    /**
     * Gives the name of the owner of the account
     * @return Returns the players name
     */
    public String getName() {
        return name;
    }
    /**
     * Gives a String representation of the account
     * @return A string of the form "Name: <balance>"
     */
    public String toString() {
        return (name + ": " + balance);
    }
    /**
     * Adds money to the player's balance.
     * @param amount The integer amount to deposit
     */
    public void deposit(int amount) {
        balance += amount;
    }
    /**
     * Withdraws money from the player's balance
     * @param amount The integer amount to withdraw
     */
    public void withdraw(int amount) {
        balance -= amount;
    }

}
