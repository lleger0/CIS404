package Project1;

//LuClandereine Leger
//Project 1
/*Make a program that simplifies the process of creating new email accounts for a particular business.

Once completed, the program should do a few things:

• It should generate a new email based on the employee’s first name, last name, and department.
• Generate a random string for their password.
• Have set methods to change the password.
• Have get methods to display name, email, and mailbox capacity.
*/
import java.util.*;

public class Email {

    String name;
    String email;
    String password = "";
    float mailboxCapacity = 15; //in GB
    Email(String firstName, String lastName, String department) {
        this.email = firstName+"."+ lastName + "@"+ department+ ".com";
        this.name = firstName +" " + lastName;

        for (int i = 0; i < 10; i++) {
            password += (char) (Math.random()*(122-64)+64);
        }

    }

    String getEmail(){
        return this.email;
    }

    String getPassword(){
        return this.password;
    }


    void setPassword(String newPassword){
        this.password = newPassword;

    }

    void getInfo(){
        System.out.println(name);
        System.out.println(email);
        System.out.println("Mailbox capacity: " + mailboxCapacity + " GB");
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the employee email application");
        System.out.print("Enter your first name: ");
        String firstName = scan.nextLine();
        System.out.print("Enter your last name: ");
        String lastName = scan.nextLine();
        System.out.print("Enter your department: ");
        String department = scan.nextLine();

        Email Employee1 = new Email(firstName, lastName, department);

        System.out.println("Your email is: " + Employee1.getEmail());
        System.out.println("Your password is: " + Employee1.getPassword());
        System.out.print("Please enter new password: ");
        String password = scan.nextLine();
        Employee1.setPassword(password);
        System.out.println("Your new password is " + Employee1.getPassword());
        System.out.println("Your all set-----------------");
        Employee1.getInfo();
    }
}

