/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_coe528;
import java.util.ArrayList;

/**
 *
 * @author maria
 */
public class Manager {
    
// Overview: The manager class represents the manager of the bank. It will keep track
//           of the customers in the bank and will be allowed to add and delete customers 
//           along with keeping track of a logged in customer. This class is immutable.
//
// The abstraction function is:
//AF: The manager class will create and ArrayList "customers" that hold Customer objects
//    m_user and m_password hold the username and password for the manager
//    loggedincustomer is responsible for holding the currently logged in customer
//    
//
// The rep invariant is:
//RI: Customers can't have the same username
//    No elements in the customers ArrayList are null
//    
//     
//
//
    
    public ArrayList<Customer> customers;
    private String m_user="admin";
    private String m_password="admin";
    private Customer loggedInCustomer;
    
    public Manager()
    {
        this.customers= new ArrayList<>();
    }
    
    public void addCustomer(Customer person)
    {
        if(person.balance>=100)
        {
            this.customers.add(person);
        }
    }
    
    public void deleteCustomer(Customer person)
    {
        System.out.println("Deletion successful");
        this.customers.remove(person);
    }
    
    public void loggedInCustomer(Customer person)
    {
        loggedInCustomer=person;
    }
    
    public Customer getloggedInCustomer()
    {
        return loggedInCustomer;
    }
    
    public String getM_password()
    {
        return m_password;
    }
    
    public String getM_user()
    {
        return m_user;
    }
    
    public boolean repOK()
    {
        //Checking that no customers have the same username
        for(int i=0; i<customers.size() ;i++)
        {
            for(int j=i+1 ;j<customers.size() ;j++)
            {
                if(customers.get(i).getC_name().equals(customers.get(j).getC_name()))
                {
                    return false;
                }
            }
        }
        
        //Checking that no element in the ArrayList is null
        for(Customer customer: customers)
        {
            if(customer==null)
            {
                return false;
            }

        }
        
        return true;
    }
    
    @Override
    public String toString()
    {
        return(""+ m_user+""+m_password);
    }
    
}