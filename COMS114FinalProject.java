import java.util.Scanner;//used for user input via the keyboard
import java.util.Random;//used to determine the computer's choices

public class COMS114FinalProject {
    private static Die sixDie = new Die(6);
    private static Scanner keyboard = new Scanner(System.in);

    //main START - main program
    public static void main(String[] args){
        int[] points = new int[3]; //creates an integer array with two elements
                                  //element 0 represents the player's points
                                  //element 1 represents the computer's points
                                  //element 2 represents the accumulated points, prior to hold being selected
        
        do{
            points[0] = 0; //resets the player's score for repeated playings
            points[1] = 0;//resets the computer's score for repeated playings
            System.out.println("Welcome to Pig!");
            System.out.print("Would you like to know how to play?(Y/N):");
            instructValidation();
            play(points);
        }while(keepPlaying());//while - loops if the player chooses to play again
    }//main END
    
    /**
     * The play method loops multiple method calls, continuing
     * the computer and player's turns until one of them hits 100 points
     * @param points An integer array containing the values for the player's points,
     * the computer's points, and temporarily stores the current accumulated point total
     */
    public static void play(int[] points){
        int turnNum = 1;//keeps track of the current turn number
        
        while(points[0] < 100 && points[1] < 100){
            points[2] = 0;//resets temporary point accumulator
            if(turnNum % 2 == 0){//ensures that the computer's turn only happens on even numbers
                System.out.println("\nThe computer is completing their turn...");
                computerTurn(points);
                System.out.println("The computer's turn has ended.");
            }//if
            else
                playerMenu(points);
            
            turnNum++;//increments the turn number
            
            score(points);
            
            if(points[0] >= 100)//checks if the player has won
                System.out.println("You got to 100 points, you win!");
            else if(points[1] >= 100)//checks if the computer has won
                System.out.println("The Computer got to 100 points, you lose...");
        }//while - loops until the computer or player reaches 100 points
    }//play
    
    /**
     * The roll method performs a random die roll with the Die Class, and stores it's value in
     * a temporary total inside the points array
     * @param points An integer array containing the values for the player's points,
     * the computer's points, and value that temporarily stores the current accumulated point total
     * @return An integer containing the value of the die roll
     */
    public static int roll(int[] points){
        int rollValue;//used to assign the die roll value
        
        sixDie.roll();
        rollValue = sixDie.getValue();
        points[2] += rollValue;//adds the rolled value to the temporary accumulator
        
        return rollValue;
    }//roll
    
    /**
     * The score method displays the current score of the player and the computer
     * @param points An integer array containing the values for the player's points,
     * the computer's points, and value that temporarily stores the current accumulated point total
     */
    public static void score(int[] points){
        System.out.println("--------------------");
        System.out.println("Player Points: " + points[0]);
        System.out.println("Computer Points: " + points[1]);
        System.out.println("--------------------");
    }//score
    
    /**
     * The playerMenu method presents the player with the options to roll the dice,
     * hold their current turn total, check the current score, and reread the instructions of Pig
     * @param points An integer array containing the values for the player's points,
     * the computer's points, and value that temporarily stores the current accumulated point total
     */
    public static void playerMenu(int[] points){
        String input;//used in conjuction with the keyboard Scanner object
        int dieValue = 0;//used to contain the die roll value, for the loop conditions
        boolean hold = false;//boolean value used to determine if the user has chosen to hold
        
        while(dieValue != 1 && !hold){
            System.out.println("\nTurn total: " + points[2]);
            System.out.print("Please type 'R' to Roll, 'H' to Hold, 'S' for the current score, " +
                    "or 'I' to see the instructions again:");
            input = keyboard.nextLine();
            switch(input.toUpperCase().charAt(0)){
                case 'R':
                    dieValue = roll(points);
                    System.out.println("You rolled a " + dieValue + ".");
                    if(dieValue == 1)
                        System.out.println("Your turn is now over.");
                    break;
                case 'H':
                    hold = true;
                    points[0] += points[2];//adds accumulated points to the player's points
                    break;
                case 'S':
                    score(points);
                    break;
                case 'I':
                    instructions();
                    break;
                default:
                    System.out.println("ERROR: Invalid Input - Roll will be automatically selected.");
                    dieValue = roll(points);
                    System.out.println("You rolled a " + dieValue + ".");
                    if(dieValue == 1)
                        System.out.println("Your turn is now over.");
            }//switch
        }//while - loops until a 1 is rolled or the player holds
    }//playerMenu
    
     /**
     * The computerTurn method performs the computer's turn through a loop with a random
     * number deciding whether it rolls the dice or holds the current turn total
     * @param points An integer array containing the values for the player's points,
     * the computer's points, and value that temporarily stores the current accumulated point total
     */
    public static void computerTurn(int[] points){
        int dieValue = 0;//used to contain the die roll value, for the loop conditions
        boolean hold = false;//boolean value used to determine if the computer has chosen to hold
        Random randomNum = new Random();//random object used to determine the computer's action
        
        for(int compTurn = 1; dieValue != 1 && !hold; compTurn++){
            int choice = randomNum.nextInt(2)+1;//random number of 1 or 2 to decide the computer's action
            switch(choice){
                case 1:
                    dieValue = roll(points);
                    break;
                case 2:
                    if(compTurn == 1){
                        dieValue = roll(points);
                    }//if - prevents the computer from holding on their first turn
                    else{
                        hold = true;
                        points[1] += points[2];//adds accumulated points to the computer's points
                    }//else
                    break;
            }//switch
        }//for - loops until a 1 is rolled or the computer holds, also increments a value for the computer's turn
    }//computerTurn
    
    /**
     * The instructValidation method performs input validation for the user's choice of whether
     * or not to read the instructions to Pig
     */
    public static void instructValidation(){
        String input;
        input = keyboard.nextLine();
        if(input.toUpperCase().charAt(0) == 'Y')
            instructions();
        else if(input.toUpperCase().charAt(0) != 'Y' && input.toUpperCase().charAt(0) != 'N'){
            System.out.println("ERROR: Invalid Input - Yes will be automatically selected.");
            instructions();
        }//else if - prevents unexpected String input   
    }//instructValidation
    
    /**
     * The instructions method displays the instructions to the game Pig
     */
    public static void instructions(){
        System.out.println("\n-Pig-");
        System.out.println("The game of Pig is a very simple jeopardy dice game\n" + 
                "in which two players race to reach 100 points.\n" + 
                "Each turn, a player repeatedly rolls a die until either a 1 is rolled\n" + 
                "or the player holds and scores the sum of the rolls (i.e. the turn total).\n" +  
                "At any time during a player's turn, the player is faced with two decisions:\n" +
                "\nROLL - If the player rolls a \n" + 
                "1: the player scores nothing and it becomes the opponent's turn.\n" + 
                "2 - 6: the number is added to the player's turn total and the player's turn continues.\n" +
                "\nHOLD - The turn total is added to the player's score and it becomes the opponent's turn.");
    }
    
    /**
     * The keepPlaying method asks the user whether they want to play again
     * @return A boolean value of True to play again or False to stop playing
     */
    public static boolean keepPlaying(){
        boolean playAgain = false;
        String answer;
        
        System.out.print("Do you want to play again?(Y/N):");
        answer = keyboard.nextLine();
        if(answer.toUpperCase().charAt(0) == 'Y')
            playAgain = true;
        else if(answer.toUpperCase().charAt(0) != 'Y' && answer.toUpperCase().charAt(0) != 'N'){
            System.out.println("ERROR: Invalid Input - No will be automatically selected.");
        }//else if - prevents unexpected String input
        System.out.println("");
        
        return playAgain;
    }//keepPlaying
}//COMS114FinalProject

/*
Welcome to Pig!
Would you like to know how to play?(Y/N):x
ERROR: Invalid Input - Yes will be automatically selected.

-Pig-
The game of Pig is a very simple jeopardy dice game
in which two players race to reach 100 points.
Each turn, a player repeatedly rolls a die until either a 1 is rolled
or the player holds and scores the sum of the rolls (i.e. the turn total).
At any time during a player's turn, the player is faced with two decisions:

ROLL - If the player rolls a 
1: the player scores nothing and it becomes the opponent's turn.
2 - 6: the number is added to the player's turn total and the player's turn continues.

HOLD - The turn total is added to the player's score and it becomes the opponent's turn.

Turn total: 0
Please type 'R' to Roll, 'H' to Hold, 'S' for the current score, or 'I' to see the instructions again:x
ERROR: Invalid Input - Roll will be automatically selected.
You rolled a 1.
Your turn is now over.
--------------------
Player Points: 0
Computer Points: 0
--------------------

The computer is completing their turn...
The computer's turn has ended.
--------------------
Player Points: 0
Computer Points: 9
--------------------

Turn total: 0
Please type 'R' to Roll, 'H' to Hold, 'S' for the current score, or 'I' to see the instructions again:r
You rolled a 3.

Turn total: 3
Please type 'R' to Roll, 'H' to Hold, 'S' for the current score, or 'I' to see the instructions again:r
You rolled a 6.

Turn total: 9
Please type 'R' to Roll, 'H' to Hold, 'S' for the current score, or 'I' to see the instructions again:r
You rolled a 6.

Turn total: 15
Please type 'R' to Roll, 'H' to Hold, 'S' for the current score, or 'I' to see the instructions again:s
--------------------
Player Points: 0
Computer Points: 9
--------------------

Turn total: 15
Please type 'R' to Roll, 'H' to Hold, 'S' for the current score, or 'I' to see the instructions again:r
You rolled a 3.

Turn total: 18
Please type 'R' to Roll, 'H' to Hold, 'S' for the current score, or 'I' to see the instructions again:h
--------------------
Player Points: 18
Computer Points: 9
--------------------

The computer is completing their turn...
The computer's turn has ended.
--------------------
Player Points: 18
Computer Points: 9
--------------------

Turn total: 0
Please type 'R' to Roll, 'H' to Hold, 'S' for the current score, or 'I' to see the instructions again:r
You rolled a 5.

Turn total: 5
Please type 'R' to Roll, 'H' to Hold, 'S' for the current score, or 'I' to see the instructions again:r
You rolled a 6.

Turn total: 11
Please type 'R' to Roll, 'H' to Hold, 'S' for the current score, or 'I' to see the instructions again:r
You rolled a 3.

Turn total: 14
Please type 'R' to Roll, 'H' to Hold, 'S' for the current score, or 'I' to see the instructions again:r
You rolled a 6.

Turn total: 20
Please type 'R' to Roll, 'H' to Hold, 'S' for the current score, or 'I' to see the instructions again:r
You rolled a 3.

Turn total: 23
Please type 'R' to Roll, 'H' to Hold, 'S' for the current score, or 'I' to see the instructions again:r
You rolled a 3.

Turn total: 26
Please type 'R' to Roll, 'H' to Hold, 'S' for the current score, or 'I' to see the instructions again:h
--------------------
Player Points: 44
Computer Points: 9
--------------------

The computer is completing their turn...
The computer's turn has ended.
--------------------
Player Points: 44
Computer Points: 15
--------------------

Turn total: 0
Please type 'R' to Roll, 'H' to Hold, 'S' for the current score, or 'I' to see the instructions again:i

-Pig-
The game of Pig is a very simple jeopardy dice game
in which two players race to reach 100 points.
Each turn, a player repeatedly rolls a die until either a 1 is rolled
or the player holds and scores the sum of the rolls (i.e. the turn total).
At any time during a player's turn, the player is faced with two decisions:

ROLL - If the player rolls a 
1: the player scores nothing and it becomes the opponent's turn.
2 - 6: the number is added to the player's turn total and the player's turn continues.

HOLD - The turn total is added to the player's score and it becomes the opponent's turn.

Turn total: 0
Please type 'R' to Roll, 'H' to Hold, 'S' for the current score, or 'I' to see the instructions again:r
You rolled a 4.

Turn total: 4
Please type 'R' to Roll, 'H' to Hold, 'S' for the current score, or 'I' to see the instructions again:r
You rolled a 2.

Turn total: 6
Please type 'R' to Roll, 'H' to Hold, 'S' for the current score, or 'I' to see the instructions again:r
You rolled a 2.

Turn total: 8
Please type 'R' to Roll, 'H' to Hold, 'S' for the current score, or 'I' to see the instructions again:r
You rolled a 2.

Turn total: 10
Please type 'R' to Roll, 'H' to Hold, 'S' for the current score, or 'I' to see the instructions again:r
You rolled a 4.

Turn total: 14
Please type 'R' to Roll, 'H' to Hold, 'S' for the current score, or 'I' to see the instructions again:r
You rolled a 4.

Turn total: 18
Please type 'R' to Roll, 'H' to Hold, 'S' for the current score, or 'I' to see the instructions again:r
You rolled a 3.

Turn total: 21
Please type 'R' to Roll, 'H' to Hold, 'S' for the current score, or 'I' to see the instructions again:r
You rolled a 2.

Turn total: 23
Please type 'R' to Roll, 'H' to Hold, 'S' for the current score, or 'I' to see the instructions again:h
--------------------
Player Points: 67
Computer Points: 15
--------------------

The computer is completing their turn...
The computer's turn has ended.
--------------------
Player Points: 67
Computer Points: 24
--------------------

Turn total: 0
Please type 'R' to Roll, 'H' to Hold, 'S' for the current score, or 'I' to see the instructions again:r
You rolled a 6.

Turn total: 6
Please type 'R' to Roll, 'H' to Hold, 'S' for the current score, or 'I' to see the instructions again:r
You rolled a 1.
Your turn is now over.
--------------------
Player Points: 67
Computer Points: 24
--------------------

The computer is completing their turn...
The computer's turn has ended.
--------------------
Player Points: 67
Computer Points: 24
--------------------

Turn total: 0
Please type 'R' to Roll, 'H' to Hold, 'S' for the current score, or 'I' to see the instructions again:r
You rolled a 3.

Turn total: 3
Please type 'R' to Roll, 'H' to Hold, 'S' for the current score, or 'I' to see the instructions again:r
You rolled a 3.

Turn total: 6
Please type 'R' to Roll, 'H' to Hold, 'S' for the current score, or 'I' to see the instructions again:r
You rolled a 3.

Turn total: 9
Please type 'R' to Roll, 'H' to Hold, 'S' for the current score, or 'I' to see the instructions again:r
You rolled a 1.
Your turn is now over.
--------------------
Player Points: 67
Computer Points: 24
--------------------

The computer is completing their turn...
The computer's turn has ended.
--------------------
Player Points: 67
Computer Points: 26
--------------------

Turn total: 0
Please type 'R' to Roll, 'H' to Hold, 'S' for the current score, or 'I' to see the instructions again:r
You rolled a 6.

Turn total: 6
Please type 'R' to Roll, 'H' to Hold, 'S' for the current score, or 'I' to see the instructions again:r
You rolled a 5.

Turn total: 11
Please type 'R' to Roll, 'H' to Hold, 'S' for the current score, or 'I' to see the instructions again:r
You rolled a 6.

Turn total: 17
Please type 'R' to Roll, 'H' to Hold, 'S' for the current score, or 'I' to see the instructions again:r
You rolled a 6.

Turn total: 23
Please type 'R' to Roll, 'H' to Hold, 'S' for the current score, or 'I' to see the instructions again:r
You rolled a 1.
Your turn is now over.
--------------------
Player Points: 67
Computer Points: 26
--------------------

The computer is completing their turn...
The computer's turn has ended.
--------------------
Player Points: 67
Computer Points: 29
--------------------

Turn total: 0
Please type 'R' to Roll, 'H' to Hold, 'S' for the current score, or 'I' to see the instructions again:r
You rolled a 2.

Turn total: 2
Please type 'R' to Roll, 'H' to Hold, 'S' for the current score, or 'I' to see the instructions again:r
You rolled a 4.

Turn total: 6
Please type 'R' to Roll, 'H' to Hold, 'S' for the current score, or 'I' to see the instructions again:r
You rolled a 4.

Turn total: 10
Please type 'R' to Roll, 'H' to Hold, 'S' for the current score, or 'I' to see the instructions again:r
You rolled a 1.
Your turn is now over.
--------------------
Player Points: 67
Computer Points: 29
--------------------

The computer is completing their turn...
The computer's turn has ended.
--------------------
Player Points: 67
Computer Points: 33
--------------------

Turn total: 0
Please type 'R' to Roll, 'H' to Hold, 'S' for the current score, or 'I' to see the instructions again:r
You rolled a 2.

Turn total: 2
Please type 'R' to Roll, 'H' to Hold, 'S' for the current score, or 'I' to see the instructions again:r
You rolled a 2.

Turn total: 4
Please type 'R' to Roll, 'H' to Hold, 'S' for the current score, or 'I' to see the instructions again:r
You rolled a 3.

Turn total: 7
Please type 'R' to Roll, 'H' to Hold, 'S' for the current score, or 'I' to see the instructions again:r
You rolled a 2.

Turn total: 9
Please type 'R' to Roll, 'H' to Hold, 'S' for the current score, or 'I' to see the instructions again:r
You rolled a 3.

Turn total: 12
Please type 'R' to Roll, 'H' to Hold, 'S' for the current score, or 'I' to see the instructions again:r
You rolled a 3.

Turn total: 15
Please type 'R' to Roll, 'H' to Hold, 'S' for the current score, or 'I' to see the instructions again:r
You rolled a 2.

Turn total: 17
Please type 'R' to Roll, 'H' to Hold, 'S' for the current score, or 'I' to see the instructions again:r
You rolled a 2.

Turn total: 19
Please type 'R' to Roll, 'H' to Hold, 'S' for the current score, or 'I' to see the instructions again:r
You rolled a 5.

Turn total: 24
Please type 'R' to Roll, 'H' to Hold, 'S' for the current score, or 'I' to see the instructions again:h
--------------------
Player Points: 91
Computer Points: 33
--------------------

The computer is completing their turn...
The computer's turn has ended.
--------------------
Player Points: 91
Computer Points: 33
--------------------

Turn total: 0
Please type 'R' to Roll, 'H' to Hold, 'S' for the current score, or 'I' to see the instructions again:r
You rolled a 3.

Turn total: 3
Please type 'R' to Roll, 'H' to Hold, 'S' for the current score, or 'I' to see the instructions again:r
You rolled a 6.

Turn total: 9
Please type 'R' to Roll, 'H' to Hold, 'S' for the current score, or 'I' to see the instructions again:r
You rolled a 1.
Your turn is now over.
--------------------
Player Points: 91
Computer Points: 33
--------------------

The computer is completing their turn...
The computer's turn has ended.
--------------------
Player Points: 91
Computer Points: 40
--------------------

Turn total: 0
Please type 'R' to Roll, 'H' to Hold, 'S' for the current score, or 'I' to see the instructions again:r
You rolled a 1.
Your turn is now over.
--------------------
Player Points: 91
Computer Points: 40
--------------------

The computer is completing their turn...
The computer's turn has ended.
--------------------
Player Points: 91
Computer Points: 49
--------------------

Turn total: 0
Please type 'R' to Roll, 'H' to Hold, 'S' for the current score, or 'I' to see the instructions again:r
You rolled a 4.

Turn total: 4
Please type 'R' to Roll, 'H' to Hold, 'S' for the current score, or 'I' to see the instructions again:r
You rolled a 6.

Turn total: 10
Please type 'R' to Roll, 'H' to Hold, 'S' for the current score, or 'I' to see the instructions again:r
You rolled a 6.

Turn total: 16
Please type 'R' to Roll, 'H' to Hold, 'S' for the current score, or 'I' to see the instructions again:r
You rolled a 5.

Turn total: 21
Please type 'R' to Roll, 'H' to Hold, 'S' for the current score, or 'I' to see the instructions again:r
You rolled a 3.

Turn total: 24
Please type 'R' to Roll, 'H' to Hold, 'S' for the current score, or 'I' to see the instructions again:h
--------------------
Player Points: 115
Computer Points: 49
--------------------
You got to 100 points, you win!
Do you want to play again?(Y/N):x
ERROR: Invalid Input - No will be automatically selected.
*/