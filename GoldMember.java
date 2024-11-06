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
public class GoldMember implements CustomerState {
    
    @Override
    public boolean onlinePurchase(Customer customer, double price)
    {
        double fee=10;
        double cost=fee+price;
        double balance=customer.getBalance();
        
        if(price>=50)
        {
            customer.withdraw(cost);
            System.out.println("Purchase successful.");
            return true;
        }
        
        System.out.println("Purchase unsuccessful.");
        return false;
    }
    
}
