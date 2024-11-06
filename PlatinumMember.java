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
public class PlatinumMember implements CustomerState {
    
    @Override
    public boolean onlinePurchase(Customer customer, double price)
    {
        double balance=customer.getBalance();
        
        if(price>=50)
        {
            customer.withdraw(price);
            System.out.println("Purchase successful.");
            return true;
        }
        
        System.out.println("Purchase unsuccessful.");
        return false;
    }
}
