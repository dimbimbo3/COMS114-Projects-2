import java.util.Scanner;

public class Chpt7Lab {
    private static Scanner keyboard = new Scanner(System.in);
    
    public static void main(String[] args) {
        int length;
        
        System.out.print("Please enter the length of the sending message:");
        length = keyboard.nextInt();
        int[] sending = new int[length];
        readCode(sending);
        
        System.out.print("Please enter the length of the receiving message:");
        length = keyboard.nextInt();
        int[] receiving = new int[length];
        readCode(receiving);
        
        compareCode(sending, receiving);
    }
    
    /**
     * The readCode method accepts an array and has the user assign values to it
     * @param array integer array
     */
    public static void readCode(int[] array){
        for(int i = 0; i < array.length; i++){
            System.out.print("Number " + (i + 1) + ":");
            array[i] = keyboard.nextInt();
        }
    }
    
    /**
     * The compareCode method accepts two arrays, compares them,
     * and outputs a message depending on if they are the equal or not
     * @param sent integer array (containing the sent message)
     * @param received integer array (containing the received message)
     */
    public static void compareCode(int[] sent, int[] received){
        boolean messageOkay = true;
        
        if(sent.length != received.length)
           messageOkay = false;
        
        for(int i = 0; messageOkay && i < sent.length; i++){
            if(sent[i] != received[i])
                messageOkay = false;
        }
              
        if(messageOkay)
            System.out.println("Message transmitted okay");
        else
            System.out.println("Error in transmission");
    }
}

/*
Please enter the length of the sending message:5
Number 1:1
Number 2:2
Number 3:3
Number 4:4
Number 5:5
Please enter the length of the receiving message:5
Number 1:1
Number 2:2
Number 3:3
Number 4:4
Number 5:5
Message transmitted okay
*/

/*
Please enter the length of the sending message:5
Number 1:1
Number 2:2
Number 3:3
Number 4:4
Number 5:5
Please enter the length of the receiving message:6 //different length
Number 1:1
Number 2:2
Number 3:3
Number 4:4
Number 5:5
Number 6:6
Error in transmission
*/

/*
Please enter the length of the sending message:5
Number 1:1
Number 2:2
Number 3:3
Number 4:4
Number 5:5
Please enter the length of the receiving message:5
Number 1:1
Number 2:2
Number 3:3
Number 4:4
Number 5:0 //different value
Error in transmission
*/
