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

        System.out.println("Are you a student or a teacher? 1 for student, 2 for teacher, q to quit");
        String s = scan.nextLine();
        while (!s.equals("q")) {
            if (s.equals("1")) {
                System.out.println("What is your name?");
                String name = scan.nextLine();
                System.out.println("What is your year?");
                int year = scan.nextInt();
                Student student = new Student(name, year);
                String x;
                do {
                    System.out.println("What would you like to do?");
                    System.out.println("1 to check status, 2 to purchase a course, 3 to check balance, 4 to pay tuition");
                    x = String.valueOf(scan.nextLine());
                    if (x.equals("1")) {
                        student.status();
                    } else if (x.equals("2")) {
                        student.courses();
                    } else if (x.equals("3")) {
                        System.out.println(student.getBalance());

                    } else if (x.equals("4")) {
                        student.payTuition();
                        System.out.println("Tuition paid");

                    }
                    if(x.equals("q")){
                        s = x;
                    }
                }while(!x.equals("q"));

            } else if (s.equals("2")) { //teacher interface


                HashMap<String,Student>students = new HashMap<>();

                System.out.println("How many students will be added to the database?");
                int num = scan.nextInt();
                //adding students loop
                for (int i = 0; i < num; i++) {
                    String test = scan.nextLine();
                    System.out.println("Enter the name of the student");
                    String name = scan.nextLine();
                    System.out.println("Enter the year of the student (if single digit year add 0 in front (ex: 09))");
                    int year = scan.nextInt();
                    Student student = new Student(name,year);
                    students.put(student.ID, student);

                }
                System.out.println("Added students: ");
                System.out.println(students);

                System.out.println("Access a students status using their ID number");
                String test = scan.nextLine();
                test = scan.nextLine();
                students.get(test).status();

                s = scan.nextLine();
                s = scan.nextLine();
            } else {
                System.out.println("that is not a correct entry.");
                s = scan.nextLine();
            }
        }



    }
}
