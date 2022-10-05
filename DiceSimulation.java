/**
   This class simulates rolling a pair of dice 10,000 times and
   counts the number of times doubles of are rolled for each different
   pair of doubles.
*/

import java.util.Random;		//to use the random number generator 
import java.util.Scanner;
import java.io.*;

public class DiceSimulation
{
	public static void main(String[] args) throws IOException
	{
		final int NUMBER = 10000;	//the number of times to roll the dice

		//a random number generator used in simulating rolling a dice
		Random generator = new Random();
		
		int die1Value;      	// number of spots on the first die
		int die2Value;      	// number of spots on the second die
		int count = 0;	     	// number of times the dice were rolled
		int snakeEyes = 0;  	// number of times snake eyes is rolled
		int twos = 0;			// number of times double two is rolled
		int threes = 0;		    // number of times double three is rolled
		int fours = 0;			// number of times double four is rolled
		int fives = 0;			// number of times double five is rolled
		int sixes = 0;			// number of times double six is rolled
		String filename;		//name of file to write/read
		int accumulator = 0;
		double mean = 0;
		int count2 = 0;

		// add code for TASK #3 
		Scanner keyboard = new Scanner(System.in);
                System.out.println("Please enter the filename in the correct format (i.e a:\\documents\\dicesimulation):");
                filename = keyboard.nextLine();
                PrintWriter outputfile = new PrintWriter(filename);

		//loop while count is less than NUMBER of times
		//adjust code in while loop as instructed in TASK #3
		
		while(count < NUMBER)
		{
			//roll the dice
			die1Value = generator.nextInt(6)+1;
			die2Value = generator.nextInt(6)+1;
			count++;
                        
			//Check to see if you have doubles
			//Enter code for Task 1 if statements here
                        if(die1Value == die2Value){
                            if(die1Value == 1)
                                snakeEyes++;
                            if(die1Value == 2)
                                twos++;
                            if(die1Value == 3)
                                threes++;
                            if(die1Value == 4)
                                fours++;
                            if(die1Value == 5)
                                fives++;
                            if(die1Value == 6)
                                sixes++;
                        }
			
		}	//while(count < NUMBER) ending braces;
                
	//add code that closes the output file for TASK #3 here
                outputfile.println(snakeEyes);
                outputfile.println(twos);
                outputfile.println(threes);
                outputfile.println(fours);
                outputfile.println(fives);
                outputfile.println(sixes);
                outputfile.close();
                
		System.out.println ("\nOutput for while loop");
		System.out.println ("You rolled snake eyes " + snakeEyes +
			" out of " + count + " rolls.");
		System.out.println ("You rolled double twos " + twos +
			" out of " + count + " rolls.");
		System.out.println ("You rolled double threes " + threes +
			" out of " + count + " rolls.");
		System.out.println ("You rolled double fours " + fours +
			" out of " + count + " rolls.");
		System.out.println ("You rolled double fives " + fives +
			" out of " + count + " rolls.");
		System.out.println ("You rolled double sixes " + sixes +
			" out of " + count + " rolls.");

	//Enter code for TASK #2 here for do while loop
                count = 0;
		snakeEyes = 0;
		twos = 0;
		threes = 0;
		fours = 0;
		fives = 0;
		sixes = 0;
                
                do{
                    die1Value = generator.nextInt(6)+1;
                    die2Value = generator.nextInt(6)+1;
                    count++;

                    if(die1Value == die2Value){
                        if(die1Value == 1)
                            snakeEyes++;
                        if(die1Value == 2)
                            twos++;
                        if(die1Value == 3)
                            threes++;
                        if(die1Value == 4)
                            fours++;
                        if(die1Value == 5)
                            fives++;
                        if(die1Value == 6)
                            sixes++;
                    }
                }while(count < NUMBER);
                
		System.out.println ("\nOutput for do while loop");
		System.out.println ("You rolled snake eyes " + snakeEyes +
			" out of " + count + " rolls.");
		System.out.println ("You rolled double twos " + twos +
			" out of " + count + " rolls.");
		System.out.println ("You rolled double threes " + threes +
			" out of " + count + " rolls.");
		System.out.println ("You rolled double fours " + fours +
			" out of " + count + " rolls.");
		System.out.println ("You rolled double fives " + fives +
			" out of " + count + " rolls.");
		System.out.println ("You rolled double sixes " + sixes +
			" out of " + count + " rolls.");
	// Enter code for TASK #2 here for for loop
                snakeEyes = 0;
		twos = 0;
		threes = 0;
		fours = 0;
		fives = 0;
		sixes = 0;
                
                for(count = 0; count < NUMBER; count++){
                    die1Value = generator.nextInt(6)+1;
                    die2Value = generator.nextInt(6)+1;
                    
                    if(die1Value == die2Value){
                        if(die1Value == 1)
                            snakeEyes++;
                        if(die1Value == 2)
                            twos++;
                        if(die1Value == 3)
                            threes++;
                        if(die1Value == 4)
                            fours++;
                        if(die1Value == 5)
                            fives++;
                        if(die1Value == 6)
                            sixes++;
                    }
                }
                
		System.out.println ("\nOutput for for loop");
		System.out.println ("You rolled snake eyes " + snakeEyes +
			" out of " + count + " rolls.");
		System.out.println ("You rolled double twos " + twos +
			" out of " + count + " rolls.");
		System.out.println ("You rolled double threes " + threes +
			" out of " + count + " rolls.");
		System.out.println ("You rolled double fours " + fours +
			" out of " + count + " rolls.");
		System.out.println ("You rolled double fives " + fives +
			" out of " + count + " rolls.");
		System.out.println ("You rolled double sixes " + sixes +
			" out of " + count + " rolls.");

	// add code for TASK #4 here
                File file = new File(filename);
                Scanner inputfile = new Scanner(file);
                
                while(inputfile.hasNext()){
                    int number = inputfile.nextInt();
                    accumulator += number;
                    count2++;
                }
                inputfile.close();
                
                mean = (double)accumulator / count2;
                System.out.println("\nWhile loop mean: " + mean);
	}
}