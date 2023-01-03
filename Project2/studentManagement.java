package Project2;
import java.util.*;
//Make a program to create a student management system
//
//Once completed, your program should do a few things:
//
//• Ask the user how many new students will be added to the database.
//• The user should be prompted to enter a name and year for each student.
//• The student should have a unique 5-digit id, with the first being their grade level.
//• The student should have several course options to choose from.
//• Each course costs $600 to enroll.
//• The student should be able to check their balance and pay tuition.
//• The status of the student should show their name, id, courses, and balance.
public class studentManagement {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args){
        System.out.println("How many students will be added to the database?");
        int num = scan.nextInt();

        for (int i = 0; i < num; i++) {
            System.out.println("Enter the name of the student");


            System.out.println("Enter the year of the student");
        }
    }
}
