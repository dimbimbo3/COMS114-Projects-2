import java.util.Random;

public class Chpt5ProjectEvenOdd {
    public static void main(String[] args) {
        Random randomNum = new Random();
        int even = 0;
        int odd = 0;
        
        //loop tests 100 random numbers and accumulates whether they are even or odd
        for(int i = 0; i < 100; i++){
            int number = randomNum.nextInt(1000);
            if(isEven(number))
                even++;
            else
                odd++;
        }
        System.out.println("Number of Even Numbers: " + even);
        System.out.println("Number of Odd Numbers: " + odd);
    }
    
    /**
     * The isEven method determines whether the parameter is even or odd
     * @param num A random integer
     * @return A boolean value of True for even and False for odd
     */
    public static boolean isEven(int num){
        boolean test;
        
        if((num % 2) == 0)
            test = true; //even
        else 
            test = false; //odd
        
        return test;
    }
}
