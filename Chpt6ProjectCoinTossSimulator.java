public class Chpt6ProjectCoinTossSimulator {
    public static void main(String[] args) {
        int headsCount = 0;
        int tailsCount = 0;
        Coin coin = new Coin();
        
        System.out.println("Initial side facing up: " + coin.getSideUp());
        
        
        for(int i = 0; i < 20; i++){
            coin.toss();
            System.out.println("[" + (i+1) + "] Side Up: " + coin.getSideUp());
            if(coin.getSideUp().equals("heads"))
                headsCount++;
            else if(coin.getSideUp().equals("tails"))
                tailsCount++;
        }
        System.out.println("Total Heads: " + headsCount);
        System.out.println("Total Tails: " + tailsCount);
    }
}
/*
Initial side facing up: heads
[1] Side Up: tails
[2] Side Up: heads
[3] Side Up: heads
[4] Side Up: heads
[5] Side Up: heads
[6] Side Up: tails
[7] Side Up: tails
[8] Side Up: heads
[9] Side Up: heads
[10] Side Up: heads
[11] Side Up: heads
[12] Side Up: tails
[13] Side Up: heads
[14] Side Up: tails
[15] Side Up: heads
[16] Side Up: tails
[17] Side Up: heads
[18] Side Up: tails
[19] Side Up: heads
[20] Side Up: tails
Total Heads: 12
Total Tails: 8
*/