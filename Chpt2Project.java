/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dan
 */
import java.util.Scanner;

public class Chpt2Project {
    public static void main(String[] args){       
        //Task 1
        String name = "Dan Imbimbo";
        String address = "71 Sammis Road";
        String city = "Sussex";
        String state = "NJ";
        String zip = "07461";
        String phone = "973-459-9315";
        String college = "SCCC";
        
        //Single println
        System.out.println("***********************************************");
        System.out.print("Personal Information\n");
        System.out.print("***********************************************\n");
        System.out.print("Name: " + name + "\n");
        System.out.print("Address, City, State, ZIP Code: " + address + ", " +
                city + ", " + state + ", " + zip + "\n");
        System.out.print("Phone Number: " + phone + "\n");
        System.out.print("College Name: " + college + "\n");
        System.out.print("***********************************************\n");
        System.out.print("\n");
        
        //Task 2
        Scanner input = new Scanner(System.in);
        String favCity = "";
        int i;
        
        System.out.print("***********************************************\n");
        System.out.print("String Manipulator\n");
        System.out.print("***********************************************\n");
        System.out.print("Please enter the name of your favorite City: ");
        
        //Loop ensures that something is inputted before continuing
        for(i = 0; i <= 0;){
            favCity = input.nextLine();
            if(favCity.length() > 0){
                i++;
            }
            else{
                System.out.print("ERROR - NOTHING WAS ENTERED\n");
                System.out.print("Please re-enter the name of " +
                        "your favorite City: ");
            }
        }
        
        //Checks for spaces to remove from character length (i.e. New York)
        int length = 0;
        for(i = 0; i < favCity.length(); i++){
            if(favCity.charAt(i) != ' ')
                length++;
        }
        
        System.out.print("\n");
        System.out.print("Number of Characters: " + length + "\n");
        System.out.print("Uppercase: " + favCity.toUpperCase() + "\n");
        System.out.print("Lowercase: " + favCity.toLowerCase() + "\n");
        System.out.print("First Character: " + favCity.charAt(0) + "\n");
        System.out.print("***********************************************\n");
        System.out.print("\n");

        //Task 3
        int stockShares = 1000;
        double boughtPerShare = 32.87;
        double commissionPercent = .02;
        double soldPerShare = 33.92;
        double boughtFor = stockShares * boughtPerShare;
        double soldFor = stockShares * soldPerShare;
        double boughtCommission = boughtFor * commissionPercent;
        double soldCommission = soldFor * commissionPercent;
        double total = boughtFor - soldFor - boughtCommission - soldCommission;
        
        System.out.print("***********************************************\n");
        System.out.print("Stock Transaction Program\n");
        System.out.print("***********************************************\n");
        System.out.print("Joe paid $" + boughtFor + " for the stock\n");
        System.out.print("Joe paid his broker a commission of $" + 
                boughtCommission + " when he bought the stock\n");
        System.out.print("Joe sold his stock for $" + soldFor + "\n");
        System.out.print("Joe paid his broker a commission of $" + 
                soldCommission + " when he sold the stock\n");
        System.out.print("Joe made $" + total + " profit when he sold his " +
                "stock and paid his two commissions\n");
        System.out.print("***********************************************\n");
    }
}

/*
***********************************************
Personal Information
***********************************************
Name: Dan Imbimbo
Address, City, State, ZIP Code: 71 Sammis Road, Sussex, NJ, 07461
Phone Number: 973-459-9315
College Name: SCCC
***********************************************

***********************************************
String Manipulator
***********************************************
Please enter the name of your favorite City: 
ERROR - NOTHING WAS ENTERED
Please re-enter the name of your favorite City: New York

Number of Characters: 7
Uppercase: NEW YORK
Lowercase: new york
First Character: N
***********************************************

***********************************************
Stock Transaction Program
***********************************************
Joe paid $32870.0 for the stock
Joe paid his broker a commission of $657.4 when he bought the stock
Joe sold his stock for $33920.0
Joe paid his broker a commission of $678.4 when he sold the stock
Joe made $-2385.8 profit when he sold his stock and paid his two commissions
***********************************************
*/
