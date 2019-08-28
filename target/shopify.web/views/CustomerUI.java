package views;

import com.franco.Bean.CustomerBean;
import com.franco.Bean.SaleBean;
import com.franco.controller.Main;
import com.franco.models.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class CustomerUI {
    String choice = null;
    int ch = 0;
    Scanner scan = new Scanner(System.in);

    public CustomerUI() {
        mainMenu();
    }

    public void mainMenu() {
        do {
            System.out.println("*******************************");
            System.out.println("Welcome to the customer UI..\n\"*******************************\"\nSelect option\n1.Add customer\n2.View customer by id\n3.View All customers\n4.Edit customer\n5.Delete customer\n6.Back to Main Menu");
            choice = scan.nextLine();



            try {
                ch = Integer.parseInt(choice);
                if (ch < 1 || ch > 6) {
                    System.out.println("________________________________________________________________________________________");
                    System.out.println("That was an incorrect input (input out of range). Try Again" );
                    System.out.println("________________________________________________________________________________________");
                }
            } catch (NumberFormatException ex) {
                System.out.println("_______________________________________");
                System.out.println("Please enter a valid number not x-ter" + " ," + ex);
                ex.printStackTrace();
                System.out.println("___________________________________________");
            }
            switch (ch) {
                case 1:
                    try {
                        createCustomer();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    readCustomer();
                    break;
                case 3:
                    viewAllCustomers();
                    break;
                case 4:
                    updateCustomer();
                    break;
                case 5:
                    deleteCustomer();
                    break;
                case 6:
                    Main.mainMenu();

            }


        } while (ch != 6);


    }


    public void createCustomer() throws SQLException {
        System.out.println("Enter customer name: ");
        String name = scan.nextLine();
        if (name.length() != 0) {

            Customer customer = new Customer(name);
            CustomerBean customerBean = new CustomerBean();


            String answer = null;
            try {
                customerBean.create(customer);
//                System.out.println("\n1.commit\n2.rollback");
//                answer = scan.nextLine();
//                if (answer.equals("1")) {
//                    CustomerBean.commit();
//                }
//                if (answer.equals("2")) {
//                    CustomerBean.rollBack();
//                }


                System.out.println("Want to add more records y/n");
                String ans = scan.nextLine();
                if (ans.equals("n")) {
                } else createCustomer();

            } catch (SQLException e) {
                e.printStackTrace();
            }
//            CustomerBean.commit();
//            if (answer.equals("1")) {
                System.out.println("Customer record successfully saved");
                System.out.println("________________________________________________");
//            }else {
//                System.out.println("________________________________________________");
//                System.out.println("Customer not added cause of rollback...");
//            }

            } else {
                System.out.println("Please enter a valid name");
            }


        }


    public void readCustomer() {
        double totalAmount =0;
        try {
            System.out.println("Enter customer User Id: ");
            int UserId = Integer.parseInt(scan.nextLine());
            try {
                try {
                    if (CustomerBean.isCustomerExists(UserId)){
                        Customer customer = new CustomerBean().read(UserId);
                        Sale sale= new SaleBean().read(UserId);
                        totalAmount += sale.getTotalAmount();
                    System.out.println(customer +" total amount on sales"+" "+ totalAmount);

                }else{
                        System.out.println("No Customer found with specified id..");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (NumberFormatException e) {
            System.out.println("Please enter an integer....");
            e.printStackTrace();
        }
        }

    public void updateCustomer() {
        try {
            System.out.println("Enter customer User id");
            int id = Integer.parseInt(scan.nextLine());

            try {
                Customer customer = new CustomerBean().read(id);
                CustomerBean customerBean = new CustomerBean();
                if (customer != null && CustomerBean.isCustomerExists(id)) {
                    System.out.println("Name: " + customerBean.read(id).getName() + " Id: " + customerBean.read(id).getUserId());

                    System.out.println("Enter customer Name: ");
                    String name = scan.nextLine();

                    customer.setName(name);

                    new CustomerBean().update(customer);
                    System.out.println("____________________________________");
                    System.out.println("Customer Updated successfully,...");
                    System.out.println("Name: " + customerBean.read(id).getName() + " Id: " + customerBean.read(id).getUserId());
                    System.out.println("____________________________________");
                } else {
                    System.out.println("_______________________________________");
                    System.out.println("Customer user Id does not exist....");
                    System.out.println("_______________________________________");
                    System.out.println("Available customers are...");
                    viewAllCustomers();
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid inputs....");
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
    public void deleteCustomer() {
        try {
            System.out.println("Enter Customer userId: ");
            int userId = Integer.parseInt(scan.nextLine());
            Customer customer = new CustomerBean().read(userId);
            if (customer != null) {
                new CustomerBean().delete(customer);
                System.out.println(customer + " deleted...");
            }else {
                System.out.println("Not deleted..");
            }


        }catch (NumberFormatException | SQLException e) {
            System.out.println("Please enter an integer....");
            e.printStackTrace();
        }

    }
    public void viewAllCustomers(){
        try {
            ArrayList<Customer> customers  = new CustomerBean().readAll();

            System.out.println("ID              NAME");
            for (Customer customer:customers){

                customer = new CustomerBean().read(customer.getUserId());

                System.out.println(customer.getUserId()+"               "+customer.getName());
                System.out.println("________________________________");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
