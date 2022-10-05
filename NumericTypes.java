//This program demonstrates how numeric types and operators behave
//TASK #2 Add import statement here to use the Scanner class
import java.util.Scanner;

public class NumericTypes {
    public static void main (String [] args) {
        //TASK #2 Create a Scanner object here
        Scanner keyboard = new Scanner(System.in);
        
        // identifier declarations

        final int NUMBER = 2 ; // number of scores

        final double SCORE1 = 100; // first test score

        final double SCORE2 = 95; // second test score

        final int BOILING_IN_F = 212; // freezing temperature

        double fToC; // temperature in Celsius

        double average; // arithmetic average

        String output; // line of output to print out

        // Find an arithmetic average

        average = (SCORE1 + SCORE2) / NUMBER;

        output = SCORE1 + " and " + SCORE2 + " have an average of " + average;

        System.out.println(output);

        // Convert Fahrenheit temperatures to Celsius

        fToC = (5.0/9) * (BOILING_IN_F - 32);

        output = BOILING_IN_F + " in Fahrenheit is " + fToC + " in Celsius.";

        System.out.println(output);

        System.out.println(); // to leave a blank line

        //TASK #2 declare variables used here
        // ADD LINES FOR TASK #2 HERE

        // prompt the user for first name
        System.out.print("Enter your first name: ");

        // read the userâ€™s first name
        String firstName = keyboard.nextLine();

        // prompt the user for last name
        System.out.print("Enter your last name: ");

        // read the userâ€™s last name
        String lastName = keyboard.nextLine();

        // concatenate the userâ€™s first and last names
        String fullName = firstName + " " + lastName;

        // print out the userâ€™s full name
        System.out.println("My full name is " + fullName);

        System.out.println(); // to leave a blank line

        // ADD LINES FOR TASK #3 HERE
        //TASK #3 declare variables used here

        // get the first character from the userâ€™s first name
        char firstInitial = firstName.charAt(0);
        
        // print out the userâ€™s first initial
        System.out.println("My first initial is " + firstInitial);
        
        // convert the userâ€™s full name to all capital letters
        fullName = fullName.toUpperCase();
        
        // print out the userâ€™s full name in all capital        
        // letters and the number of characters in it
        System.out.println(fullName + " contains " + fullName.length() + 
                " characters");

        System.out.println(); // to leave a blank line

        // ADD LINES FOR TASK #4 HERE
        //TASK #4 declare variables used here

        // prompt the user for a diameter of a sphere
        System.out.print("Please enter the diameter of the sphere: ");

        // read the diameter
        double diameter = keyboard.nextDouble();

        // calculate the radius
        double radius = diameter / 2;

        // calculate the volume
        double volume = (4.0/3) * Math.PI * Math.pow(radius, 3);

        // print out the volume
        System.out.println("The volume of the sphere is " + volume);
    }

}

/*100.0 and 95.0 have an average of 97.5
212 in Fahrenheit is 100.0 in Celsius.

Enter your first name: Dan
Enter your last name: Imbimbo
My full name is Dan Imbimbo

My first initial is D
DAN IMBIMBO contains 11 characters

Please enter the diameter of the sphere: 2
The volume of the sphere is 4.1887902047863905*/


/*Please enter the diameter of the sphere: 25.4
The volume of the sphere is 8580.24664605096*/


/*Please enter the diameter of the sphere: 5000
The volume of the sphere is 6.544984694978735E10*/