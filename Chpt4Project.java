import java.util.Scanner;
import java.util.Random;

public class Chpt4Project {
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        Random randomNumber = new Random();
        
        //Problem 1
        int num;
        int sum = 0;
        
        System.out.println("-------------------------------------------------");
        System.out.println("Sum of Numbers");
        System.out.println("-------------------------------------------------");
        
        //loop ensures that a positive non-zero number is entered
        do{
            System.out.print("Please enter a positive non-zero integer value:");
            num = keyboard.nextInt();
            if(num <= 0)
                System.out.println("Error - Number must be greater than 0");
        }while(num <= 0);
        
        System.out.print("The sum of ");
        
        //loop sums all integers from 1 to the number entered
        for(int i = 0; num > 0; i++){
            System.out.print(num);
            sum += num;
            num -= 1;
            if(num > 0)
                System.out.print(" + ");
        }
        
        System.out.println(" is " + sum);
        System.out.println("");
        
        //Problem 2
        int answer = randomNumber.nextInt(1000);
        int guess;
        int count = 0;
        String again = "";
        
        System.out.println("-------------------------------------------------");
        System.out.println("Random Number Guessing Game");
        System.out.println("-------------------------------------------------");
        
        //loop continues to ask user to guess the random number until they are correct or stop guessing
        do{
            System.out.print("Please guess the random integer value:");
            guess = keyboard.nextInt();
            keyboard.nextLine(); //consumes new line character
            count++;
            if(guess > answer || guess < answer){
            	if(guess > answer)
	            System.out.println("too high, try again...");
	        else if(guess < answer)
	            System.out.println("too low, try again...");
                
	        System.out.print("Would you like to guess again?(Y/N):");
	        again = keyboard.nextLine();
	        if(again.toUpperCase().charAt(0) != 'Y' && again.toUpperCase().charAt(0) != 'N'){
	            System.out.println("ERROR: Invalid Input - Yes will be automatically selected.");
	            again = "yes";
	        }
            }
            else if(guess == answer){
	        System.out.println("Congratulations, you guessed right!");
	        again = "no";
            }
        }while(again.toUpperCase().charAt(0) != 'N');
        
        System.out.println("Number of Guesses: " + count);
        System.out.println("");

        //Problem 3
        double enteredAmount;
        double totalAmount = 0;
        double totalWon = 0;
        int symbols;
        String values;
        String slots;
        String play;
        
        System.out.println("-------------------------------------------------");
        System.out.println("Slot Machine Simulation");
        System.out.println("-------------------------------------------------");
        
        //loop continues to ask user to enter money into slot machine and play until they choose to stop
        do{
            System.out.print("How much money would you like to enter?: $");
            enteredAmount = keyboard.nextDouble();
            while(enteredAmount <= 0){
                System.out.println("ERROR: Invalid Amount Entered!");
                System.out.print("Please re-enter your amount of money: $");
                enteredAmount = keyboard.nextDouble();
            }
            keyboard.nextLine(); //consumes new line character
            totalAmount += enteredAmount;

            //reset slots & values for loops
            values = "";
            slots = "";

            for(int i = 0; i < 3; i++){
                symbols = randomNumber.nextInt(6);
                switch(symbols){
                    case 0:
                        values += "0";
                        slots += "cherries ";
                        break;
                    case 1:
                        values += "1";
                        slots += "oranges ";
                        break;
                    case 2:
                        values += "2";
                        slots += "plums ";
                        break;
                    case 3:
                        values += "3";
                        slots += "bells ";
                        break;
                    case 4:
                        values += "4";
                        slots += "melons ";
                        break;
                    case 5:
                        values += "5";
                        slots += "bars ";
                        break;
                }
            }

            System.out.println(slots);

            if(values.charAt(0) == values.charAt(1) || values.charAt(0) == values.charAt(2) || values.charAt(1) == values.charAt(2)){
                totalWon += (enteredAmount * 2);
                System.out.printf("Two matching symbols - you win $%.2f\n", ((enteredAmount * 2)));
            }
            else if(values.charAt(0) == values.charAt(1) && values.charAt(0) == values.charAt(2)){
                totalWon += (enteredAmount * 3);
                System.out.printf("Three matching symbols - you win $%.2f\n", ((enteredAmount * 3)));
            }
            else{
                System.out.println("No matching symbols - you win $0");
            }
            
            System.out.print("Would you like to play again?(Y/N):");
	    play = keyboard.nextLine();
	    if(play.toUpperCase().charAt(0) != 'Y' && play.toUpperCase().charAt(0) != 'N'){
	        System.out.println("ERROR: Invalid Input - Yes will be automatically selected.");
	        play = "yes";
            }
        }while(play.toUpperCase().charAt(0) != 'N');
        
        System.out.printf("Total Amount Entered: $%.2f\n", (totalAmount));
        System.out.printf("Total Amount Won: $%.2f\n", (totalWon));
        System.out.printf("Profit: $%.2f\n", (totalWon - totalAmount));
    }
}

/*
-------------------------------------------------
Sum of Numbers
-------------------------------------------------
Please enter a positive non-zero integer value:-1
Error - Number must be greater than 0
Please enter a positive non-zero integer value:5
The sum of 5 + 4 + 3 + 2 + 1 is 15
*/

/*
-------------------------------------------------
Random Number Guessing Game
-------------------------------------------------
Please guess the random integer value:500
too low, try again...
Would you like to guess again?(Y/N):a
ERROR: Invalid Input - Yes will be automatically selected.
Please guess the random integer value:900
too high, try again...
Would you like to guess again?(Y/N):y
Please guess the random integer value:800
too high, try again...
Would you like to guess again?(Y/N):y
Please guess the random integer value:700
too high, try again...
Would you like to guess again?(Y/N):y
Please guess the random integer value:600
too high, try again...
Would you like to guess again?(Y/N):y
Please guess the random integer value:550
too low, try again...
Would you like to guess again?(Y/N):y
Please guess the random integer value:560
too low, try again...
Would you like to guess again?(Y/N):y
Please guess the random integer value:580
too low, try again...
Would you like to guess again?(Y/N):y
Please guess the random integer value:590
too low, try again...
Would you like to guess again?(Y/N):y
Please guess the random integer value:596
too high, try again...
Would you like to guess again?(Y/N):y
Please guess the random integer value:595
too high, try again...
Would you like to guess again?(Y/N):y
Please guess the random integer value:593
too high, try again...
Would you like to guess again?(Y/N):y
Please guess the random integer value:591
Congratulations, you guessed right!
Number of Guesses: 13
*/

/*
-------------------------------------------------
Slot Machine Simulation
-------------------------------------------------
How much money would you like to enter?: $0
ERROR: Invalid Amount Entered!
Please re-enter your amount of money: $10
melons cherries plums 
No matching symbols - you win $0
Would you like to play again?(Y/N):a
ERROR: Invalid Input - Yes will be automatically selected.
How much money would you like to enter?: $50
melons plums bells 
No matching symbols - you win $0
Would you like to play again?(Y/N):y
How much money would you like to enter?: $600
cherries melons cherries 
Two matching symbols - you win $1200.00
Would you like to play again?(Y/N):n
Total Amount Entered: $660.00
Total Amount Won: $1200.00
Profit: $540.00
*/