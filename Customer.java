/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_coe528;

/**
 *
 * @author maria
 */
public class Customer {

// Overview: The customer class represents a customer using the bank application. It creates an object that
//           holds the username, password, balance, and state. This class also allows the customer to deposit, withdraw
//           and make online purchases. This class is mutable.
//
// The abstraction function is:
//AF: A Customer object that has;
//    c_name, which is the username of the customer
//    c_password, which is the password of the customer
//    balance, which is the amount of money in the account of the customer
//    state, which is the current membership of the customer (Silver, Gold, or Platinum)
//
// The rep invariant is:
//RI: state can't be null
//    balance can not be negative
//      
//     
//
//
    
    private String c_name;
    private String c_password;
    protected double balance;
    private CustomerState state;
    
    
    public Customer(String c_name, String c_password, double balance)
    {
        
    //REQUIRES: A string input c_name, string input c_password, and a double value balance.
    //EFFECTS: This will intitialize the variables that were inputted and will set the state of the customer based on their balance.
        
        this.c_name=c_name;
        this.c_password=c_password;
        this.balance=balance;
        customerState(balance);
    }

    
    public void customerState(double balance)
    {
    //REQUIRES: Double value balance.
    //MODIFIES: The state of the customer.
    //EFFECTS: Will set the state to SilverMember, GoldMember, or PlatinumMember depending on the balance.
        
        if(balance>10000 && balance<20000)
        {
            state= new GoldMember();
        }
        
        else if(balance>=20000)
        {
            state=new PlatinumMember();
        }
        
        else
        {
            state=new SilverMember();
        }
    }
    
    public String customerRank(double balance)
    {
    //REQUIRES: Double value balance.
    //MODIFIES: The rank of the customer.
    //EFFECTS: Depending on the balance, the string "Rank" will be assigned to its respective rank (Silver Member, Gold Member,
    //         or Platinum Member).
        
        String Rank;
        
        if(balance>10000 && balance<20000)
        {
            return Rank="Gold Member";
        }
        
        if(balance>20000)
        {
            return Rank="Platinum Member";
        }
        
        return Rank="Silver Member";
    }
    
    public boolean online_purchase(double price)
    {
    //REQUIRES: Double value price.
    //MODIFIES: The customer balance.
    //EFFECTS: depending on the state of the customer it will call the appropriate onlinePurchase method from the state classes
    //         (SilverMember, GoldMember, or PlatinumMember) and subtract the price along with their respective fees from the balance.
    //         The balance will then be updated and the method will return true, if the conditions are not met then it will return false.
        
        customerState(balance);
        
        if(state!= null && state.onlinePurchase(this, price))
        {
            return true;
        }
        
        System.out.println("State is not assigned.");
        return false;
    }
    
    
    /*Purpose: Allows user to deposit money to balance.*/
    public boolean deposit(double amount)
    {
    //REQUIRES: Double value amount.
    //MODIFIES: The balance of the customer.
    //EFFECTS: If the conditions are met (amount is greater than 0), it will add the deposit amount to the balance and
    //         update the new balance. When this is done it will return as true otherwise if conditions are not met it will return as false.
        
        if(amount>0)
        {
          balance=balance+amount;
          System.out.println("Deposit successful. Current balance: " + balance);
          return true;
          
        }
       
        System.out.println("Deposit unsuccessful, amount must be greater than zero.");
        return false;
    }
    
    
    /*Purpose: Allows the user to withdraw money from balance.*/
    public boolean withdraw(double amount)
    {
    //REQUIRES: Double value amount.
    //MODIFIES: The balance of the customer.
    //EFFECTS: If the conditions are met (amount is less than or equal to balance and amount is greater than 0), it will subract
    //         the withdrawal amount from the balance and update the new balance. When this is done it will return as true otherwise if conditions
    //         are not met it will return as false.
            
        if(amount>0 && amount<=balance)
        {
            balance=balance-amount;
            System.out.println("Withdrawal successful. Current balance: " + balance);
            return true;
        }
        
        System.out.println("Withdrawal unsuccessful, amount must be greater than zero.");
        return false;
    }
    

    public double getBalance()
    {
    //EFFECTS:Will return the double value balance for the customer.
        
        return balance;
    }
    
    public String getC_name()
    {
    //EFFECTS: Will return the String c_name for the customer.
        
        return c_name;
    }
    
    public String getC_password()
    {
    //EFFECTS: Will return the String c_password for the customer.
        
        return c_password;
    }
    
    public boolean repOK()
    {
    //EFFECTS: This method implements the rep invariant and will return true if the following conditions are met:
    //         customer balance is not negative
    //         customer state is not null
        
        //balance can't be negative
        if(balance<0)
        {
            return false;
        }
        
        //state can't be null
        if(state==null)
        {
            return false;
        }
        
        return true;
    }
    
    @Override
    public String toString()
    {
    //EFFECTS: This method implements the abstraction function and will return the string repersentation of the customer object.
        
        return("" + c_name + ", " + customerRank(balance) + ", Balance: $" + balance);
    }
    
    
}
