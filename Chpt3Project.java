/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
/**
 *
 * @author student
 */
public class Chpt3Project {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        String internetPackage = "";
        double costA = 9.95;
        double costB = 13.95;
        final double costC = 19.95;
        final int accessHoursA = 10;
        final int accessHoursB = 20;
        final double additionalHoursA = 2.00;
        final double additionalHoursB = 1.00;
        double hours;
        double hoursA;
        double hoursB;

        System.out.println("Please enter the package initial that you currently have...");
        System.out.print("Package(A, B, or C): ");
        
        //does not continue until initial A, B, or C is entered
        for(int i = 0; i <= 0;){
            internetPackage = input.nextLine();
            switch(internetPackage.toUpperCase().charAt(0)){
	        case 'A':
	            i++;
	            break;
	        case 'B':
	            i++;
	            break;
	        case 'C':
	            i++;
	            break;
	        default:
	            System.out.println("ERROR - Invalid package!");
	            System.out.print("Please re-enter your Package INITIAL(A, B, or C): ");
            }
    	}
        
        //checks if package is C, unlimited access, in which case it does not ask for the hours
        if(internetPackage.toUpperCase().charAt(0) != 'C'){
	    System.out.print("Please enter the number of hours that were used: ");
            hours = input.nextDouble();
                
            hoursA = accessHoursA - hours;
            hoursB = accessHoursB - hours;
            //determines additional hour cost, if any, for package A
            if(hoursA < 0){
                hoursA *= -1;
                costA += hoursA * additionalHoursA;
            }
            //determines additional hour cost, if any, for package B
            if(hoursB < 0){
                hoursB *=  -1;
                costB += hoursB * additionalHoursB;
            }
        }
        
        //determines output based upon package initial inputted
        switch(internetPackage.toUpperCase().charAt(0)){
            case 'A':
                System.out.printf("Total Charge (Package A): $%.2f\n", (costA));
                //checks if you would have saved from purchasing package B
                //if so, displays message showing how much
                if((costA - costB) > 0){
	            System.out.printf("You would save $%.2f" + 
	                " if you switched to Package B\n", ((costA - costB)));
                }
                //checks if you would have saved from purchasing package C
                //if so, displays message showing how much
	        if((costA - costC) > 0){
                    System.out.printf("You would save $%.2f" + 
	                " if you switched to Package C\n", ((costA - costC)));
            	}
                break;
            case 'B':
            	//checks if you would have saved from purchasing package C
                //if so, displays message showing how much
            	System.out.printf("Total Charge (Package B): $%.2f\n", (costB));
            	if((costB - costC) > 0){
            		System.out.printf("You would save $%.2f" + 
	                	" if you switched to Package C\n", ((costB - costC)));
            	}
            	break;
            case 'C':
            	System.out.printf("Total Charge (Package C): $%.2f\n", (costC));
               	break;
            default:
            	System.out.println("Unexpected error has occured!");
        }
    }
}

//(Package A) Shows error and cost output when within allotted access hours
/*
Please enter the package initial that you currently have...
Package(A, B, or C): d
ERROR - Invalid package!
Please re-enter your Package INITIAL(A, B, or C): A
Please enter the number of hours that were used: 9
Total Charge (Package A): $9.95
*/

//(Package A) Shows price increase when over additional hours and savings if switched to B 
/*
Please enter the package initial that you currently have...
Package(A, B, or C): a
Please enter the number of hours that were used: 15
Total Charge (Package A): $19.95
You would save $6.00 if you switched to Package B
*/

//(Package A) Shows savings if switched to B or C
/*
Please enter the package initial that you currently have...
Package(A, B, or C): a
Please enter the number of hours that were used: 20
Total Charge (Package A): $29.95
You would save $16.00 if you switched to Package B
You would save $10.00 if you switched to Package C
*/

//(Package B) Shows price increase when over additional hours and savings if switched to C
/*
Please enter the package initial that you currently have...
Package(A, B, or C): b
Please enter the number of hours that were used: 30
Total Charge (Package B): $23.95
You would save $4.00 if you switched to Package C
*/

//(Package C) Shows lack of request for hours if Package C and cost output
/*
Please enter the package initial that you currently have...
Package(A, B, or C): C
Total Charge (Package C): $19.95
*/