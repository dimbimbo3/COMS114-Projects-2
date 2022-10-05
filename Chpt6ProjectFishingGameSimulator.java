import java.util.Scanner;

public class Chpt6ProjectFishingGameSimulator {
    public static void main(String[] args) {
        int round = 1;
        int pointTotal = 0;
        Die sixDie = new Die(6);
        
        message();
        do{
            System.out.println("[Round " + round + "]");
            sixDie.roll();
            pointTotal += fishCaught(sixDie);
            round++;
        }while(keepPlaying());
        
        System.out.println("Total Fishing Points: " + pointTotal);
        checkScore(pointTotal);
    }
    
    public static void message(){
        System.out.println("Welcome to Fishing Game Simulator!!!");
        System.out.println("---------Points Chart---------");
        System.out.println("Huge fish: 100");
        System.out.println("Large fish: 75");
        System.out.println("Medium fish: 50");
        System.out.println("Small fish: 25");
        System.out.println("Tin Can: -25");
        System.out.println("Dirty Boot: -50");
        System.out.println("------------------------------\n");
    }
    
    public static int fishCaught(Die sixDie){
        int points = 0;
        
        switch(sixDie.getValue()){
            case 1:
                points = 25;
                System.out.println("You caught a small fish!");
                break;
            case 2:
                points = -25;
                System.out.println("You caught an tin can...");
                break;
            case 3:
                points = 50;
                System.out.println("You caught a medium fish!");
                break;
            case 4:
                points = -50;
                System.out.println("You caught a dirty boot...");
                break;
            case 5:
                points = 75;
                System.out.println("You caught a large fish!");
                break;
            case 6:
                points = 100;
                System.out.println("You caught a HUGE fish!!!");
                break;
        }
        
        return points;
    }
    
    public static void checkScore(int points){
        if(points < 50)
            System.out.println("Better luck next time...");
        else if(points >= 50 && points <= 200)
            System.out.println("Nice job fishing!");
        else if(points >= 200 && points <= 400)
            System.out.println("Great job fishing!");
        else if(points >= 400)
            System.out.println("Excellent job fishing!!!");
    }
    
    public static boolean keepPlaying(){
        Scanner keyboard = new Scanner(System.in);
        boolean playAgain = false;
        String answer;
        
        System.out.print("Do you want to continue fishing?(Y/N):");
        answer = keyboard.nextLine();
        if(answer.toUpperCase().charAt(0) == 'Y')
            playAgain = true;
        else if(answer.toUpperCase().charAt(0) != 'Y' && answer.toUpperCase().charAt(0) != 'N'){
            System.out.println("ERROR: Invalid Input - Yes will be automatically selected.");
            playAgain = true;
        }
        System.out.println("");
        
        return playAgain;
    }
}
/*
Welcome to Fishing Game Simulator!!!
---------Points Chart---------
Huge fish: 100
Large fish: 75
Medium fish: 50
Small fish: 25
Tin Can: -25
Dirty Boot: -50
------------------------------

[Round 1]
You caught an tin can...
Do you want to continue fishing?(Y/N):z
ERROR: Invalid Input - Yes will be automatically selected.

[Round 2]
You caught a small fish!
Do you want to continue fishing?(Y/N):y

[Round 3]
You caught a dirty boot...
Do you want to continue fishing?(Y/N):y

[Round 4]
You caught a medium fish!
Do you want to continue fishing?(Y/N):y

[Round 5]
You caught a medium fish!
Do you want to continue fishing?(Y/N):y

[Round 6]
You caught a small fish!
Do you want to continue fishing?(Y/N):n

Total Fishing Points: 75
Nice job fishing!
*/