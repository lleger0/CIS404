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

class Student {
    String name = " ";
    int year;
    String ID;
    double balance = 100000;

    double tuition = 0;

    ArrayList<String> courses = new ArrayList<String>();

    //courses

    Student(String name, int year){
        this.name = name;
        this.year = year;
        //ID will take up first to numbers, whether that means 09 or 10
        ID = String.valueOf(year);
        while(ID.length()<5) {
            ID += (String.valueOf ((int)(Math.random()*9)));
        }

    }
    void status(){
        System.out.println("Name: " + name);
        System.out.println("Year: " + year);
        System.out.println("ID: " + ID);
        System.out.println("Balance: " + balance);
        System.out.println("Remaining tuition: " + tuition);
    }

    void courses(){
        System.out.println("Select a course:");
        System.out.println("1 for CIS 404");//1
        System.out.println("2 for Java 101");//2
        System.out.println("3 for CIS 103");//3

        Scanner scan = new Scanner(System.in);

        String c = scan.nextLine();
        if (c.equals("1")){
            courses.add("CIS 404");
            tuition+=600;
        } else if (c.equals("2")) {
            courses.add("Java 101");
            tuition+=600;
        } else if (c.equals("3")) {
            courses.add("CIS 103");
            tuition+=600;
        } else{
            System.out.println("Not a valid entry");
        }
    }

    void payTuition(){
        balance-=tuition;
        tuition = 0;
        status();
    }
    double getBalance(){
        return balance;
    }


}


