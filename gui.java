/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_coe528;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


/**
 *
 * @author maria
 */
public class gui extends Application{
    
    private static Manager manager;
    private static ListView<String> deletecustomer_list= new ListView<String>();

    public static void setManager(Manager managerInstance) 
    {
        manager=managerInstance;
    }
    
    @Override
    public void start(Stage primaryStage) 
    {
        
        primaryStage.setTitle("Bank Application");
        
        //log in scene
        GridPane root=new GridPane();
        root.setGridLinesVisible(false);
        root.setHgap(17);
        root.setVgap(5);
        Scene scene =new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
        //manager scene
        Pane root1= new Pane();
        Scene manager_scene=new Scene(root1, 600, 400);
        
            //delete_customer scene
            Pane root1_1=new Pane();
            Scene delete_customer_scene=new Scene(root1_1, 520, 400);
            
            //add_customer scene
            GridPane root1_2 = new GridPane();
            root1_2.setHgap(17);
            root1_2.setVgap(5);
            Scene add_customer_scene=new Scene(root1_2, 557, 248);
            root1_2.setGridLinesVisible(false);
            
            
        //customer scene
        Pane root2= new Pane();
        Scene customer_scene=new Scene(root2, 590,325);
        
            //deposit_scene
            GridPane root2_1= new GridPane();
            root2_1.setHgap(17);
            root2_1.setVgap(5);
            Scene deposit_scene= new Scene(root2_1, 500, 325);
            root2_1.setGridLinesVisible(false);
            
            //withdraw_scene
            GridPane root2_2=new GridPane();
            root2_2.setHgap(17);
            root2_2.setVgap(5);
            Scene withdraw_scene=new Scene(root2_2, 500, 325);
            root2_2.setGridLinesVisible(false);
            
            //onlinepurchase_scene
            GridPane root2_3=new GridPane();
            root2_3.setHgap(17);
            root2_3.setVgap(5);
            Scene onlinepurchase_scene=new Scene(root2_3, 500, 355);
            root2_3.setGridLinesVisible(false);
        
        
            
        //log in screen labels
        Label title_1= new Label("Sign in");
        title_1.setFont(new Font("", 18));
        Label title_2= new Label("To use online banking");
        title_2.setFont(new Font("", 13));
        Label lbl1= new Label("Username");
        lbl1.setFont(new Font("", 14));
        Label lbl2= new Label("Password");
        lbl2.setFont(new Font("", 14));
        Label lbl3=new Label("Role");
        lbl3.setFont(new Font("", 14));
        root.add(lbl1, 4, 3);
        root.add(lbl2, 4, 4);
        root.add(lbl3, 4, 6);
        root.add(title_2, 1, 3);
        root.add(title_1, 1, 2);
        //log in screen textboxes
        TextField username= new TextField();
        root.add(username, 5, 3);
        PasswordField pass= new PasswordField();
        root.add(pass, 5, 4);
        //log in screen list of roles
        ComboBox<String> role=new ComboBox<String>();
        role.getItems().add("Customer");
        role.getItems().add("Manager");
        role.setPrefWidth(150);
        root.add(role, 5, 6);
        //log in screen buttons
        Button log_in= new Button("Enter");
        log_in.setPrefWidth(75);
        root.add(log_in, 5, 9);
        
        
        
        //manager screen labels
        Label management_screen=new Label("Management Page");
        management_screen.setFont(Font.font("", FontWeight.BOLD ,22));
        management_screen.setLayoutX(77);
        management_screen.setLayoutY(45);
        root1.getChildren().add(management_screen);
        //manager screen listview
        ListView<String> customer_list= new ListView<String>();
        for(Customer person_:manager.customers)
        {
           customer_list.getItems().add(person_.toString());
        }
        customer_list.setLayoutX(350);
        customer_list.setLayoutY(0);
        root1.getChildren().add(customer_list);
        //manager screen buttons
        Button add_customer= new Button("Add Customer");
        add_customer.setPrefWidth(160);
        add_customer.setPrefHeight(65);
        add_customer.setFont(new Font("", 16));
        add_customer.setLayoutX(90);
        add_customer.setLayoutY(120);
        Button delete_customer= new Button("Delete Customer");
        delete_customer.setPrefWidth(160);
        delete_customer.setPrefHeight(65);
        delete_customer.setFont(new Font("", 16));
        delete_customer.setLayoutX(90);
        delete_customer.setLayoutY(240);
        Button log_out =new Button("Log out");
        log_out.setLayoutX(0);
        log_out.setLayoutY(0);
        root1.getChildren().add(log_out);
        root1.getChildren().add(add_customer);
        root1.getChildren().add(delete_customer);
        
        
            //delete_customer screen labels
            Label deleteCustomer= new Label("Select a customer");
            deleteCustomer.setFont(new Font("", 22));
            deleteCustomer.setLayoutX(300);
            deleteCustomer.setLayoutY(30);
            root1_1.getChildren().add(deleteCustomer);
            //delete_customer screen listview
 
            deletecustomer_list.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
            for(Customer person_:manager.customers)
            {
                deletecustomer_list.getItems().add(person_.getC_name());
            }
            deletecustomer_list.setLayoutX(0);
            deletecustomer_list.setLayoutY(0);
            root1_1.getChildren().add(deletecustomer_list);
            //delete_customer buttons
            Button delete=new Button("Delete");
            delete.setPrefWidth(100);
            delete.setPrefHeight(30);
            delete.setLayoutX(330);
            delete.setLayoutY(80);
            root1_1.getChildren().add(delete);
            Button cancel_1=new Button("Cancel");
            cancel_1.setLayoutX(465);
            cancel_1.setLayoutY(370);
            root1_1.getChildren().add(cancel_1);
            
            
            //add_customer screen labels //SET POSITIONS
            Label addCustomer1=new Label("Add Customer");
            Label addCustomer=new Label("Input customer information");
            addCustomer1.setFont(new Font("", 18));
            addCustomer.setFont(new Font("", 14));
            root1_2.add(addCustomer1,1 ,2);
            root1_2.add(addCustomer,1,3);
            Label addusername = new Label("Username");
            addusername.setFont(new Font("", 14));
            root1_2.add(addusername, 4, 3);
            Label addpassword= new Label("Password");
            addpassword.setFont(new Font("", 14));
            root1_2.add(addpassword, 4, 4);
            Label addbalance= new Label("Balance");
            addbalance.setFont(new Font("", 14));
            root1_2.add(addbalance, 4, 5);
            //add_customer textfields
            TextField add_username= new TextField();
            root1_2.add(add_username,5 ,3);
            TextField add_password=new TextField();
            root1_2.add(add_password,5, 4);
            TextField add_balance=new TextField();
            root1_2.add(add_balance,5 ,5);
            //add_customer buttons
            Button add=new Button("Add");
            add.setPrefWidth(75);
            root1_2.add(add,5,8);
            Button cancel_2=new Button("Cancel");
            root1_2.add(cancel_2,7,18);
            
            
            
        //customer_scene labels
        Label customerscreen= new Label("Customer Page");
        customerscreen.setFont(Font.font("",FontWeight.BOLD ,22));
        customerscreen.setLayoutX(70);
        customerscreen.setLayoutY(44);
        root2.getChildren().add(customerscreen);
        //customer_scene buttons
        Button deposit=new Button("Deposit");
        deposit.setPrefWidth(178);
        deposit.setPrefHeight(35);
        deposit.setLayoutX(60);
        deposit.setLayoutY(105);
        root2.getChildren().add(deposit);
        Button withdraw=new Button("Withdraw");
        withdraw.setPrefWidth(178);
        withdraw.setPrefHeight(35);
        withdraw.setLayoutX(60);
        withdraw.setLayoutY(173);
        root2.getChildren().add(withdraw);
        Button online_purchase=new Button("Online Purchase");
        online_purchase.setPrefWidth(178);
        online_purchase.setPrefHeight(35);
        online_purchase.setLayoutX(60);
        online_purchase.setLayoutY(240);
        root2.getChildren().add(online_purchase);
        Button log_out2= new Button("Log out");
        log_out2.setLayoutX(525);
        log_out2.setLayoutY(5);
        root2.getChildren().add(log_out2);
        //rectangle
        Rectangle display= new Rectangle(192, 171, Color.ALICEBLUE);
        display.setStroke(Color.LIGHTBLUE);
        display.setStrokeWidth(2);
        display.setStrokeType(StrokeType.INSIDE);
        display.setLayoutX(327);
        display.setLayoutY(105);
        root2.getChildren().add(display);
        //info labels on display
        Label customeruser=new Label();
        customeruser.setLayoutX(360);
        customeruser.setLayoutY(145);
        customeruser.setFont(Font.font("", FontWeight.BOLD, 14));
        root2.getChildren().add(customeruser);
        Label customerbalance=new Label();
        customerbalance.setLayoutX(360);
        customerbalance.setLayoutY(180);
        customerbalance.setFont(Font.font("", FontWeight.BOLD, 14));
        root2.getChildren().add(customerbalance);
        Label customerrank=new Label();
        customerrank.setLayoutX(360);
        customerrank.setLayoutY(215);
        customerrank.setFont(Font.font("", FontWeight.BOLD, 14));
        root2.getChildren().add(customerrank);
        customeruser.toFront();
        customerbalance.toFront();
        customerrank.toFront();
        
        
            //deposit_scene labels
            Label deposit_0=new Label("Deposit");
            deposit_0.setFont(Font.font("", FontWeight.BOLD, 20));
            root2_1.add(deposit_0, 1,1);
            Label deposit_1=new Label("Enter amount:");
            deposit_1.setFont(new Font("", 14));
            root2_1.add(deposit_1, 2, 4);
            Label dep_balance=new Label();
            dep_balance.setFont(new Font("", 16));
            root2_1.add(dep_balance, 1, 2);
            //deposit_scene textbox
            TextField deposit_amount=new TextField();
            root2_1.add(deposit_amount,3 ,4);
            //deposit_scene buttons
            Button deposit_2=new Button("Deposit");
            root2_1.add(deposit_2, 3, 6);
            Button cancel_3= new Button("Cancel");
            root2_1.add(cancel_3, 6, 0);
            
            
            //withdraw_scene labels
            Label withdraw_0= new Label("Withdraw");
            withdraw_0.setFont(Font.font("", FontWeight.BOLD, 20));
            root2_2.add(withdraw_0, 1, 1);
            Label with_balance=new Label();
            with_balance.setFont(new Font("", 16));
            root2_2.add(with_balance, 1, 2);
            Label withdraw_1= new Label("Enter amount:");
            withdraw_1.setFont(new Font("", 14));
            root2_2.add(withdraw_1, 2, 4);
            //withdraw_scene textbox
            TextField withdraw_amount=new TextField();
            root2_2.add(withdraw_amount, 3, 4);
            //withdraw_scene buttons
            Button withdraw_2=new Button("Withdraw");
            root2_2.add(withdraw_2, 3, 6);
            Button cancel_4=new Button("Cancel");
            root2_2.add(cancel_4, 6,0);
            
            
            //onlinepurchase_scene labels
            Label purchase_0=new Label("Online Purchase");
            purchase_0.setFont(Font.font("", FontWeight.BOLD, 18));
            root2_3.add(purchase_0,1,1);
            Label purchase_balance= new Label();
            purchase_balance.setFont(new Font("", 16));
            root2_3.add(purchase_balance, 1, 2);
            Label purchase_1=new Label("Enter price:");
            purchase_1.setFont(new Font("", 14));
            root2_3.add(purchase_1, 3, 5);
            Label fee=new Label();
            fee.setFont(new Font("", 12));
            root2_3.add(fee, 4,6);
            //onlinepurchase_scene textbox
            TextField purchase_amount=new TextField();
            root2_3.add(purchase_amount,4,5);
            //onlinepurchase_scene buttons
            Button purchase=new Button("Purchase");
            root2_3.add(purchase, 4,8);
            Button cancel_5=new Button("Cancel");
            root2_3.add(cancel_5, 5,0);
            
            
         


//giving the buttons function

        log_in.setOnAction(event -> {
            
            String user=username.getText();
            String password=pass.getText();
            String role_=role.getValue();
            
            if(!user.isEmpty() && !password.isEmpty())
            {
                if(role_.equals("Manager"))
                {
                    if(user.equals(manager.getM_user()) && password.equals(manager.getM_password()))
                    {
                        System.out.println("Manager log in successful.");
                        primaryStage.setScene(manager_scene);
                    }
                    else 
                    {
                        System.out.println("Manager log in not successful.");
                    }
                }
                
                if(role_.equals("Customer"))
                {
                    boolean customer_find=false;
                    
                    for(Customer person:manager.customers)
                    {
                        if(user.equals(person.getC_name()) && password.equals(person.getC_password()))
                        {
                            System.out.println("Customer log in successful.");
                            customer_find =true;
                            manager.loggedInCustomer(person);
                            customeruser.setText("User: "+person.getC_name());
                            customerbalance.setText("Balance: $" + Double.toString(person.getBalance()));
                            customerrank.setText(person.customerRank(person.getBalance()));
                            primaryStage.setScene(customer_scene);
                            break;
                        }
                    }

                    if(!customer_find)
                    {
                        System.out.println("Customer log in not successful.");
                    }
                }
               
            }
            
            else
            {
                System.out.println("Please fill in all required fields.");
            }
        });
        
        
        delete_customer.setOnAction(event -> {
            
            primaryStage.setScene(delete_customer_scene);
        });
        
        cancel_1.setOnAction(event -> {
            
            primaryStage.setScene(manager_scene);
        });
        
        cancel_2.setOnAction(event -> {
            
            primaryStage.setScene(manager_scene);
        });
        
        cancel_2.setOnAction(event -> {
            
            primaryStage.setScene(manager_scene);
        });
        
        cancel_3.setOnAction(event -> {
            
            primaryStage.setScene(customer_scene);
        });
        
        cancel_4.setOnAction(event -> {
            
            primaryStage.setScene(customer_scene);
        });
        
        cancel_5.setOnAction(event -> {
            
            primaryStage.setScene(customer_scene);
        });
        
        log_out.setOnAction(event -> {
            
            username.clear();
            pass.clear();
            role.setValue("");
            primaryStage.setScene(scene);
        });
        
        log_out2.setOnAction(event -> {
            
            username.clear();
            pass.clear();
            role.setValue("");
            primaryStage.setScene(scene);
        });
        
        deposit.setOnAction(event -> {
            
            String balance=customerbalance.getText();
            dep_balance.setText(balance);
            primaryStage.setScene(deposit_scene);
        });
        
        deposit_2.setOnAction(event -> {
            
            double deposit_=Double.parseDouble(deposit_amount.getText());
            Customer loginperson=manager.getloggedInCustomer();
            
            
            if(loginperson.deposit(deposit_))
            {
                customerbalance.setText("Balance: $" +loginperson.getBalance());
                customerrank.setText(loginperson.customerRank(loginperson.getBalance()));
                deposit_amount.clear();
                primaryStage.setScene(customer_scene);
            }
            
            else
            {
                System.out.println("Deposit unsuccessful.");
            }
            
            
        });
        

        withdraw.setOnAction(event -> {
            
            String balance=customerbalance.getText();
            with_balance.setText(balance);
            primaryStage.setScene(withdraw_scene);
        });
        
        
        withdraw_2.setOnAction(event -> {
            
            double withdraw_=Double.parseDouble(withdraw_amount.getText());
            Customer loginperson=manager.getloggedInCustomer();
            
            if(loginperson.withdraw(withdraw_))
            {
                customerbalance.setText("Balance: $" +loginperson.getBalance());
                customerrank.setText(loginperson.customerRank(loginperson.getBalance()));
                primaryStage.setScene(customer_scene);
            }
            
            else
            {
                System.out.println("Withdraw unsuccessful.");
            }
            
        });
        
        online_purchase.setOnAction(event -> {
            
            Customer loginperson=manager.getloggedInCustomer();
            String rank=loginperson.customerRank(loginperson.getBalance());
            if(rank.equals("Silver Member"))
            {
                fee.setText("Additional fee: $20");
            }
            if(rank.equals("Gold Member"))
            {
                fee.setText("Additional fee: $10");
            }
            if(rank.equals("Platinum Member"))
            {
                fee.setText("Additional fee: $0");
            }
            String balance=customerbalance.getText();
            purchase_balance.setText(balance);
            primaryStage.setScene(onlinepurchase_scene);
        });
        
        
        purchase.setOnAction(event -> {
            
            Double price=Double.parseDouble(purchase_amount.getText());
            Customer loginperson=manager.getloggedInCustomer();
            loginperson.customerState(loginperson.getBalance());
            
            if(loginperson.online_purchase(price))
            {
                customerbalance.setText("Balance: $"+loginperson.getBalance());
                customerrank.setText(loginperson.customerRank(loginperson.getBalance()));
                purchase_amount.clear();
                primaryStage.setScene(customer_scene);
            }
            
            else if(price<50)
            {
                System.out.println("Price must be greater than or equal to $50.");
            }
            
            else if(price>loginperson.getBalance())
            {
                System.out.println("Insufficient funds.");
            }
            
            else
            {
                System.out.println("Purchase unsuccessful.");
            }
        });
        
        
        delete.setOnAction(event -> {
            
            String selectedCustomerName =deletecustomer_list.getSelectionModel().getSelectedItem().trim();
            
            Customer customerToDelete= null;
            for(Customer customer:manager.customers) 
            {   
                if(customer.getC_name().equals(selectedCustomerName)) 
                {
                    customerToDelete=customer;
                    break;
                }
            }
    
            if(customerToDelete!= null) 
            {
                 manager.deleteCustomer(customerToDelete);
                //update the ListView
                update_deletecustomerlistview();
                customer_list.getItems().clear(); // Clear the ListView
                
                for(Customer person_ : manager.customers) 
                {
                    customer_list.getItems().add(person_.getC_name());
                }
                
                primaryStage.setScene(manager_scene); 
            }
                  
            else  
            {
                System.out.println("Please select a customer");
            }
            
        });
        
         add_customer.setOnAction(event -> {
            
            primaryStage.setScene(add_customer_scene);
        });
         
        
        add.setOnAction(event -> {
            
            String user=add_username.getText();
            String password=add_password.getText();
            double balance=Double.parseDouble(add_balance.getText());
            
            
            
            
            if(!user.isEmpty() && !password.isEmpty() && !add_balance.getText().isEmpty() && balance>=100)
            {
                boolean existingUser=manager.customers.stream().anyMatch(customer -> customer.getC_name().equals(user));
                if(existingUser)
                {
                    System.out.println("Username already exists.");
                }
                
                else
                {
                Customer person=new Customer(user, password, balance);
                manager.addCustomer(person);
                add_username.clear();
                add_password.clear();
                add_balance.clear();
                
                //update ListView
                update_deletecustomerlistview();
                customer_list.getItems().clear();
                for(Customer person_ : manager.customers) 
                {
                    customer_list.getItems().add(person_.toString());
                }
                primaryStage.setScene(manager_scene);
                }
            }
            
            if(balance<100)
            {
                System.out.println("Initial balance must be greater than or equal to $100.");
            }
            
            else
            {
                System.out.println("Please fill in all required fields");
            }
            
        });
        
        
    }
    
    private void update_deletecustomerlistview()
            {
                deletecustomer_list.getItems().clear();
                
                for(Customer person:manager.customers)
                {
                    deletecustomer_list.getItems().add(person.getC_name());
                }
            }
    
    
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Manager manager=new Manager();
        Customer customer1= new Customer("John123", "54321", 15000);
        manager.addCustomer(customer1);
        Customer customer2=new Customer("chuchu123", "1", 100);
        manager.addCustomer(customer2);
        
        setManager(manager);
        
        launch(args);

    }
    
}
