package Project4;
import java.util.*;

//This program is made with 5 different classes: one for the account, the user, the transaction, the bank, and the ATM.
// Once complete, the program will prompt the user to enter their unique user id to access their account. After that,
// the user will be prompted to enter their pin number. If entered successfully, they will be granted access to their
// account. Once inside their account, they will be able to view the balance in the checking and savings account, as
// well as the following options:
//
//• Show account transactions
//• Withdraw
//• Deposit
//• Transfer
//• Quit
//
//Feel free to use Java Swing/JAVA AWT
//
//https://www.javatpoint.com/awt-and-swing-in-java

class Account{
    Scanner scan = new Scanner(System.in);

    float balance = 10000000;

    void viewBalance(){
        System.out.println(this.balance);
    }

    void transactions(String option){
        Transactions transactions = new Transactions();
        float amount;
        if (option.equals("withdraw")){
            System.out.println("Withdraw amount?");
            amount = Float.valueOf(scan.nextLine());
            balance = transactions.withdraw(amount,balance);
        } else if (option.equals("deposit")) {
            System.out.println("Deposit amount?");
            amount = Float.valueOf(scan.nextLine());
            balance = transactions.deposit(amount, balance);
        } else if (option.equals("transfer")) {
            System.out.println("Transfer amount? ");
            amount = Float.valueOf(scan.nextLine());
            //transactions.transfer();
        } else if (option.equals("quit")) {
            Exception e = new Exception();
        }
    }

}

class User{
    Scanner scan = new Scanner(System.in);

    String username;
    String password="4444";

    User(String username){
        this.username = username;
        System.out.println("Enter your password: ");
        String input = scan.nextLine();
        validate(input);
    }

    void changeUsername(String username){
        this.username = username;

    }
    void changePassword(String password){
        this.password = password;
    }

    void validate(String password){
        int x;
        if (this.password.equals(password)){

            ATM atm = new ATM();
        }else{
            System.out.println("Try again.");
            password = scan.nextLine();
            validate(password);

        }
    }

}

class Transactions{



    float withdraw(float amount, float balance){
        System.out.println("Here is " + amount);
        return balance - amount;

    }
    float deposit(float amount, float balance){

        return balance + amount;

    }
    void transfer(float amount, Account recieve, Account giving){
        System.out.println("Where would you like to transfer to?");
        recieve.balance = amount + recieve.balance;
        giving.balance = giving.balance - amount;


    }
    void quit(){
        RuntimeException exception = new RuntimeException();

    }
}

class Bank {
    Bank(){

    }
    void signIn(String username){
        User user = new User(username);
    }
}

class ATM{
    Scanner scan = new Scanner(System.in);
    Account checking = new Account();

    Account savings = new Account();

    ATM(){
        System.out.println("Would you like to go to your checking account or your savings account? ");
        String account = scan.nextLine();
        if (account.equals("checking") || account.equals("CHECKING") || account.equals("Checking")){
            System.out.println("What would you like to do? 1. Withdraw, 2. deposit, 3. Transfer, 4. View Balance 5. Quit");
            int option = Integer.valueOf(scan.nextLine());
            if (option == 1){
                checking.transactions("withdraw");
            } else if (option == 2) {
                checking.transactions("deposit");
            } else if (option == 3) {
                checking.transactions("transfer");
            } else if (option == 4) {
                checking.viewBalance();
            } else if (option == 5) {
                RuntimeException runtimeException = new RuntimeException("Quitting...");
            }
        } else if (account.equals("savings")) {
            System.out.println("Wait for your money to increase.");
        }
    }
}



public class ATMSimulation {

    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter your user ID");
        String ID = scan.nextLine();
        System.out.println("Enter your pin");
        String pin = scan.nextLine();

        //maybe have a bool function to check if they account is right

        //there are two accounts. A checking and a savings account. Honestly this would probably be inside of user...

        //options to change password.

        Bank BOA = new Bank();
        BOA.signIn(ID);

    }

}
