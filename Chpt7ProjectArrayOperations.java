import java.util.Random;

public class Chpt7ProjectArrayOperations {
    public static void main(String[] args){
        Random randomNum = new Random();
        
        int length = 10;
        int[] array = new int[length];
        
        for(int i = 0; i < array.length; i++){
            array[i] = randomNum.nextInt(200)+1;
            System.out.println("Num " + (i + 1) + ":" + array[i]);
        }
        
        System.out.println("Total:" + getTotal(array));
        System.out.println("Average:" + getAverage(array));
        System.out.println("Highest:" + getHighest(array));
        System.out.println("Lowest:" + getLowest(array));
    }
    /**
     * The getTotal method accepts an integer array, adds together its values, 
     * and returns the total
     * @param array integer array
     * @return An integer containing the sum of the array's elements
     */
    public static int getTotal(int[] array){
        int total = 0;
        
        for(int i = 0; i < array.length; i++){
            total += array[i];
        }
        
        return total;
    }
    /**
     * The getAverage method accepts an integer array and returns the average
     * of its values
     * @param array integer array
     * @return A double containing the average of the array's elements
     */
    public static double getAverage(int[] array){
        double total = getTotal(array);
        double average = total/array.length;
        
        return average;
    }
    /**
     * The getHighest method accepts an integer array and returns highest value
     * of its elements
     * @param array integer array
     * @return An integer containing the highest value of the array's elements
     */
    public static int getHighest(int[] array){
        int highest = array[0];
        for(int i = 1; i < array.length; i++){
            if(array[i] > highest)
                highest = array[i];
        }
        
        return highest;
    }
    /**
     * The getLowest method accepts an integer array and returns lowest value
     * of its elements
     * @param array integer array
     * @return An integer containing the lowest value of the array's elements
     */
    public static int getLowest(int[] array){
        int lowest = array[0];
        for(int i = 1; i < array.length; i++){
            if(array[i] < lowest)
                lowest = array[i];
        }
        
        return lowest;
    }
}
