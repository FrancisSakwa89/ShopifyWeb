package views;

import com.franco.Bean.RecieveBean;
import com.franco.Bean.RunningBalanceBean;
import com.franco.Bean.SaleBean;
import com.franco.controller.Main;
import com.franco.models.Recievings;
import com.franco.models.RunningBalance;
import com.franco.models.Sale;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class RunningBalanceUI {
    String choice = null;
    int ch = 0;
    Scanner scan = new Scanner(System.in);

    public RunningBalanceUI() {
        mainMenu();
    }

    public void mainMenu() {
        do {
            System.out.println("***************** Running balance**************");
            System.out.println("Welcome to the product sector..\n\"*******************************\"\nSelect option\n1.Get product runningBalance\n2.Get product Running balance quantity\n3.Back to main menu");
            choice = scan.nextLine();


            try {
                ch = Integer.parseInt(choice);
                if (ch < 1 || ch > 3) {
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
                        readRunningBalance();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    getBalance();
                    break;
                case 3:
                    System.out.println("_____________________");
                        System.out.println("Main menu");
                        Main.mainMenu();
            }
        } while (ch != 3);
    }

    public void createRunningBalance() {


    }

    public void readRunningBalance() throws SQLException {

        System.out.println("Enter product id: ");
        int id = Integer.parseInt(scan.nextLine());
        RunningBalanceBean runningBalanceBean=new RunningBalanceBean();
        RunningBalance runningBalance=null;

        try {
            runningBalance = runningBalanceBean.read(id);
            System.out.println(runningBalance);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (runningBalance != null ) {
            System.out.println("Product Name: " + runningBalance.getProductName() + " Id: " + id + " Received: " + runningBalance.getQuantity());
        }
    }


    public void getBalance(){
        try {
            ArrayList<Sale> sales  = new SaleBean().readAll();
            ArrayList<Recievings> recievings1  = new RecieveBean().readAll();
            Recievings recievings = new Recievings();

            double total = 0;
            int RB = 0;
            int runningBalance;
            System.out.println("SALE ID     DATE      QUANTITY      PRICE     CUSTOMER NAME     TOTAL");
            for (Sale sale:sales){
                total += (sale.getQuantity() * sale.getSellingPrice());
                runningBalance = recievings.getQuantity()*sale.getQuantity();
                RB += runningBalance;

                System.out.println("_______________________________________________________________________________");
//                System.out.println(sales);

                System.out.println(sale.getSaleId()+"         "+sale.getDatetime()+"        "+sale.getQuantity()+"     "+sale.getSellingPrice()+"       "+sale.getCustomerName()+ "                 " +total +" RB: "+ RB);
                System.out.println("_______________________________________________________________________________");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
