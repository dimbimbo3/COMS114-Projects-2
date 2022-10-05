import java.util.Scanner;
import java.util.Random;

public class Chpt5ProjectRockPaperScissors {
    public static void main(String[] args) {
        Random randomNum = new Random();
        
        int computerValue;
        String computerChoice;
        int playerValue;
        String playerChoice;
        String winnerIs;
        boolean tie = false;
        
        System.out.println("Welcome to... Rock, Paper, Scissors!");
        do{//loop if the user decides to play again
            do{//loop in case of a tie
                System.out.println("*Rock beats Scissors, Scissors beats Paper, and Paper beats Rock*");
                computerValue = randomNum.nextInt(3)+1;
                computerChoice = convertChoice(computerValue);
                playerValue = playerMenu();
                playerChoice = convertChoice(playerValue);
                System.out.println("Computer's Choice:" + computerChoice);
                System.out.println("Player's Choice:" + playerChoice);
                tie = checkWinner(computerValue, playerValue);
            }while(tie);
        }while(keepPlaying());
    }
    
    /**
     * The playerMenu method asks the user to input 1, 2 or 3 (for rock, paper or scissors)
     * @return An integer value of 1, 2 or 3
     */
    public static int playerMenu(){
        Scanner input = new Scanner(System.in);
        int playerVal = 0;
        
        //loop ensures that the user only enters 1, 2 or 3
        do{
            System.out.print("Please type 1 for Rock, 2 for Paper, or 3 for Scissors:");
            playerVal = input.nextInt();
            input.nextLine(); //consumes newline character
            if(playerVal != 1 && playerVal != 2 && playerVal != 3)
                System.out.println("ERROR: Invalid Input");
        }while(playerVal != 1 && playerVal != 2 && playerVal != 3);
        
        return playerVal;
    }
    
    /**
     * The convertChoice method determines the choice based on the value of the parameter
     * @param val An integer of 1, 2 or 3
     * @return A string representing the choice
     */
    public static String convertChoice(int val){
        String choice = "";
        
        switch(val){
            case 1:
                choice = "Rock";
                break;
            case 2:
                choice = "Paper";
                break;
            case 3:
                choice = "Scissors";
                break;
        }
        
        return choice;
    }
    
    /**
     * The checkWinner method compares the computer value with the player value to determine the winner
     * @param computer An integer of 1, 2 or 3 that represents the computer's choice
     * @param player An integer of 1, 2 or 3 that represents the player's choice
     * @return A boolean value that determines whether there is a tie
     */
    public static boolean checkWinner(int computer, int player){
        boolean tie = false;
        
        switch(player){
            case 1:
                if(computer == 1){
                    System.out.println("There is a tie, play again to determine winner.");
                    tie = true;
                }
                else if(computer == 2)
                    System.out.println("Paper wraps Rock. The Computer wins...");
                else if(computer == 3)
                    System.out.println("Rock smashes Scissors. You win!");
                break;
            case 2:
                if(computer == 1)
                    System.out.println("Paper wraps Rock. You win!");
                else if(computer == 2){
                    System.out.println("There is a tie, play again to determine winner.");
                    tie = true;
                }
                else if(computer == 3)
                    System.out.println("Scissors cut Paper. The Computer wins...");
                break;
            case 3:
                if(computer == 1)
                    System.out.println("Rock smashes Scissors. The Computer wins...");
                else if(computer == 2)
                    System.out.println("Scissors cut Paper. You win!");
                else if(computer == 3){
                    System.out.println("There is a tie, play again to determine winner.");
                    tie = true;
                }
                break;
        }
        System.out.println("");
        
        return tie;
    }
    
    /**
     * The keepPlaying method asks the user whether they want to play again
     * @return A boolean value of True to play again or False to stop playing
     */
    public static boolean keepPlaying(){
        Scanner readIn = new Scanner(System.in);
        boolean playAgain = false;
        
        System.out.print("Do you want to play again?(Y/N):");
        String answer = readIn.nextLine().toUpperCase();
        char ans = answer.charAt(0);
        if(ans == 'Y')
            playAgain = true;
        else if(ans != 'Y' && ans != 'N'){
            System.out.println("ERROR: Invalid Input - Yes will be automatically selected.");
            playAgain = true;
        }
        System.out.println("");
        
        return playAgain;
    }
}

/*
Welcome to... Rock, Paper, Scissors!
*Rock beats Scissors, Scissors beats Paper, and Paper beats Rock*
Please type 1 for Rock, 2 for Paper, or 3 for Scissors:4
ERROR: Invalid Input
Please type 1 for Rock, 2 for Paper, or 3 for Scissors:1
Computer's Choice:Paper
Player's Choice:Rock
Paper wraps Rock. The Computer wins...

Do you want to play again?(Y/N):x
ERROR: Invalid Input - Yes will be automatically selected.

*Rock beats Scissors, Scissors beats Paper, and Paper beats Rock*
Please type 1 for Rock, 2 for Paper, or 3 for Scissors:2
Computer's Choice:Scissors
Player's Choice:Paper
Scissors cut Paper. The Computer wins...

Do you want to play again?(Y/N):n
*/