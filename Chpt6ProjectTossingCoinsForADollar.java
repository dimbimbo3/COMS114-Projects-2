public class Chpt6ProjectTossingCoinsForADollar {
    public static void main(String[] args) {
        double balance = 0;
        Coin quarter = new Coin();
        Coin dime = new Coin();
        Coin nickel = new Coin();
        
        for(int i = 1; balance < 1; i++){
            System.out.println("[Round " + i+ "]");
            quarter.toss();
            System.out.println("Quarter: " + quarter.getSideUp());
            if(quarter.getSideUp().equals("heads")){
                balance += .25;
                System.out.printf("Balance Update: $%.2f\n", balance);
            }
            dime.toss();
            System.out.println("Dime: " + dime.getSideUp());
            if(dime.getSideUp().equals("heads")){
                balance += .10;
                System.out.printf("Balance Update: $%.2f\n", balance);
            }
            nickel.toss();
            System.out.println("Nickel: " + nickel.getSideUp());
            if(nickel.getSideUp().equals("heads")){
                balance += .05;
                System.out.printf("Balance Update: $%.2f\n", balance);
            }
            System.out.println("");
        }
        
        if(balance == 1)
            System.out.println("Your balance is exactly $1, you win!");
        else if(balance > 1)
            System.out.println("Your balance exceeds $1, you lose...");
    }
}
/*
[Round 1]
Quarter: heads
Balance Update: $0.25
Dime: heads
Balance Update: $0.35
Nickel: heads
Balance Update: $0.40

[Round 2]
Quarter: tails
Dime: heads
Balance Update: $0.50
Nickel: tails

[Round 3]
Quarter: tails
Dime: tails
Nickel: tails

[Round 4]
Quarter: heads
Balance Update: $0.75
Dime: heads
Balance Update: $0.85
Nickel: tails

[Round 5]
Quarter: heads
Balance Update: $1.10
Dime: heads
Balance Update: $1.20
Nickel: tails

Your balance exceeds $1, you lose...
*/

/*
[Round 1]
Quarter: tails
Dime: tails
Nickel: heads
Balance Update: $0.05

[Round 2]
Quarter: heads
Balance Update: $0.30
Dime: heads
Balance Update: $0.40
Nickel: tails

[Round 3]
Quarter: tails
Dime: tails
Nickel: tails

[Round 4]
Quarter: heads
Balance Update: $0.65
Dime: tails
Nickel: heads
Balance Update: $0.70

[Round 5]
Quarter: heads
Balance Update: $0.95
Dime: tails
Nickel: heads
Balance Update: $1.00

Your balance is exactly $1, you win!
*/