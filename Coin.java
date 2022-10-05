//Used with Chp6ProjectCoinTossSimulator & Chp6ProjectTossingCoinsForADollar

import java.util.Random;

public class Coin {
    private String sideUp;
    
    public Coin(){
        toss();
    }
    
    public void toss(){
        Random rand = new Random();
        int side = rand.nextInt(2)+1;
        if(side == 1)
            sideUp = "heads";
        else if(side == 2)
            sideUp = "tails";
    }
    
    public String getSideUp(){
        return sideUp;
    }
}
