package Project3;
import java.util.*;
//Make a simple banking application that acts as a checking account. It should utilize
// print statements, if/else statements, strings, ints, methods, loops, and more.
// Using these techniques, the bank program created allows the user to perform multiple
// different functions:
//
//1.    Check your balance
//
//2.    Make a deposit
//
//3.    Make a withdrawal
//
//4.    View the previous transaction
//
//5.    Calculate Interest
//
//6.    Exit the application

public class bankingApplication {
    static Scanner scan = new Scanner(System.in);
    static double balance = 100000;
    static ArrayList<String> transaction = new ArrayList();

    static double getBalance(){
        return balance;
    }

    static void deposit(double depositAmount){
        balance += depositAmount;
    }
    static void withdrawal(double withdrawAmount){
        balance-=withdrawAmount;
    }

    static void transactions(char q){
        switch (q){
            case '1':
                transaction.add("Check balance");
            case '2':
                transaction.add("Deposit made");
            case '3':
                transaction.add("Withdrawal Made");
            case '4':
                transaction.add("Previouse transaction viewed");
            case '5':
                transaction.add("Interested Calculated");
        }
    }
    static ArrayList getTransaction(){
        return transaction;
    }

    static double interest(){
        double interest;
        interest = balance *.05;
        return interest;
    }

    public static void main(String[] args){
        System.out.println("Welcome to the Bank");
        char q = ' ';


        while (q != 'q'){
            System.out.println("Enter 1 to check your balance, 2 to make a deposit, " +
                    "3 to withdrawal, 4 to view the previous transaction, 5 to Calculate " +
                    "interest, and q to quit.");

            q = scan.next().charAt(0);


            if (q=='1'){
                System.out.println(getBalance());
            } else if (q=='2') {
                System.out.println("How much would you like to deposit?");
                deposit(scan.nextDouble());
            } else if (q=='3') {
                System.out.println("How much would you like to withdraw");
                withdrawal(scan.nextDouble());
            } else if (q=='4') {
                System.out.println(getTransaction());
            } else if (q=='5') {
                System.out.println(interest());
            }
            else{
                System.out.println("That is not a valid entry, please try again.");
            }
            transactions(q);
            System.out.println("What would you like to do next?");

        }

    }
}
