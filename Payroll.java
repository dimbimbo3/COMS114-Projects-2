/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author student
 */
//program to compute gross pay

public class Payroll { 
    public static void main(String[] args) { 
        int hours = 42;
        double grossPay, payRate = 30.0;

        grossPay = hours * payRate;

        System.out.println("Your gross pay is $" + grossPay);
        System.out.println("New hours: " + hours);
        System.out.println("New PayRate: " + payRate);
    } 
}

/*Your gross pay is $1260.0
New hours: 42
New PayRate: 30.0*/
