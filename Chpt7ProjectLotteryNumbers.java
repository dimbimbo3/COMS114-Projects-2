import java.util.Random;
import java.util.Scanner;

public class Chpt7ProjectLotteryNumbers {
    private static Scanner keyboard = new Scanner(System.in);
    
    public static void main(String[] args){
        int length = determinePick();
        int[] lotteryNums = new int[length];
        int[] userNums = new int[length];
        
        randomizeLottery(lotteryNums);
        chooseNums(userNums);
        
        System.out.print("Your Numbers: ");
        printArray(userNums);
        System.out.print("Lottery Numbers: ");
        printArray(lotteryNums);
        
        compareArrays(lotteryNums, userNums);
    }
    
    public static int determinePick(){
        int input;
        int pick = 0;
        
        do{
            System.out.println("Which lottery game would you like to play?");
            System.out.print("Enter '3' for Pick 3, '4' for Pick 4, or '6' for Pick 6:");
            input = keyboard.nextInt();
            
            switch(input){
                case 3:
                    pick = 3;
                    break;
                case 4:
                    pick = 4;
                    break;
                case 6:
                    pick = 6;
                    break;
                default:
                    System.out.println("ERROR - Invalid Input");
            }
        }while(input != 3 && input != 4 && input != 6);
        
        return pick;
    }
    
    public static void randomizeLottery(int[] lottery){
        Random randomNums = new Random();
        
        for(int i = 0; i < lottery.length; i++){
            lottery[i] = randomNums.nextInt(10);
        }
    }
    
    public static void chooseNums(int[] user){
        int input;
        
        System.out.println("Please pick your " + user.length + " numbers(between 0 and 9)");
        for(int i = 0; i < user.length; i++){
            do{
                System.out.print("Number " + (i+1) + ":");
                input = keyboard.nextInt();
                if(input < 0 || input > 9)
                    System.out.println("ERROR - Invalid Input");
            }while(input < 0 || input > 9);
            user[i] = input;
        }
    }
    
    public static void compareArrays(int[] lottery, int[] user){
        int matching = 0;
        
        for(int i = 0; i < lottery.length; i++){
            if(user[i] == lottery[i]){
                matching++;
            }
        }
        
        System.out.println("You have " + matching + " matching number(s).");
        if(matching == lottery.length)
            System.out.println("Congratulations, you win!");
        else
            System.out.println("Sorry, you lose...");
    }
    
    public static void printArray(int[] array){
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i]);
        }
        System.out.println("");
    }
}

/*
Which lottery game would you like to play?
Enter '3' for Pick 3, '4' for Pick 4, or '6' for Pick 6:1
ERROR - Invalid Input
Which lottery game would you like to play?
Enter '3' for Pick 3, '4' for Pick 4, or '6' for Pick 6:4
Please pick your 4 numbers(between 0 and 9)
Number 1:10
ERROR - Invalid Input
Number 1:5
Number 2:7
Number 3:2
Number 4:3
Your Numbers: 5723
Lottery Numbers: 5815
You have 1 matching number(s).
Sorry, you lose...
*/