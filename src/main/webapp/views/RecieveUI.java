package views;

import com.franco.Bean.ProductBean;
import com.franco.Bean.RecieveBean;
import com.franco.Bean.SaleBean;
import com.franco.controller.Main;
import com.franco.models.Product;
import com.franco.models.Recievings;
import com.franco.models.Sale;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class RecieveUI {
    String choice = null;
    int ch = 0;
    Scanner scan = new Scanner(System.in);

    public RecieveUI() {
        mainMenu();
    }

    public void mainMenu() {
        do {
            System.out.println("Welcome to the recievings..\nSelect option\n1.Make a Recieving..\n2.View recievings.\n3.Delete Receiving by Id.\n4.Back to Main Menu");
            choice = scan.nextLine();

            try {
                ch = Integer.parseInt(choice);
                if (ch < 1 || ch > 4) {
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
                                createOrder();
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                            break;
                        case 2:
                            readAllRecievings();
                            break;
                        case 3:
                            deleteRecievingById();
                            break;
                        case 4:
                            System.out.println("_____________________");
                            System.out.println("Main menu");
                            Main.mainMenu();
                    }
                }while (ch != 4);


            }




    public void createOrder() throws SQLException {
        try {
            System.out.println("Enter batch no: ");
            int batchNo = Integer.parseInt(scan.nextLine());
            Date date = new Date();
            System.out.println("Enter product Id: ");
            int id = Integer.parseInt(scan.nextLine());
            RecieveBean recieveBean = new RecieveBean();
            System.out.println("Enter quantity: ");
            int quantity = Integer.parseInt(scan.nextLine());
            System.out.println("Enter buyingPrice: ");
            double buyingPrice = Integer.parseInt(scan.nextLine());
            System.out.println("Enter sellingPrice: ");
            double sellingPrice = Integer.parseInt(scan.nextLine());
            System.out.println("Supplier name: ");
            String supplier = scan.nextLine();
            int runningBalance = quantity;

            Recievings recievings = new Recievings(batchNo, date, id, quantity, buyingPrice, sellingPrice, supplier,runningBalance);
            System.out.println("_______________________________");
            System.out.println("Recieved successfully...");
            System.out.println("_______________________________");

            try {

                recieveBean.create(recievings);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter an integer....");
            e.printStackTrace();
        }

    }

    public void readAllRecievings(){
        try {
            ArrayList<Recievings> recievings1  = new RecieveBean().readAll();

            Product product = new Product();
            ProductBean productBean = new ProductBean();
            SaleBean saleBean  = new SaleBean();

            Sale sale = new Sale();
            System.out.println("ID     BATCH NO       DATE      SUPPLIER      SELLINGPRICE     BUYINGPRICE     TOTAL       PRODUCT NAME        QUANTITY RECEIVED");
            for (Recievings recievings:recievings1){
                double total = 0;
                total += (recievings.getQuantity() * recievings.getSellingPrice());
                System.out.println("__________________________________________________________________________________________________");
                System.out.println(recievings.getId()+"         "+recievings.getBatchNo()+"         "+recievings.getDate()+"        "+recievings.getSupplier()+"     "+recievings.getSellingPrice()+"       "+recievings.getBuyingPrice()+ "                 " +total+ "        "+productBean.read(recievings.getId()).getName()+ "     "+recievings.getQuantity()+"        "+(recievings.getQuantity() - (saleBean.read(product.getId()).getQuantity())));
                System.out.println("__________________________________________________________________________________________________");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deleteRecievingById(){
        try {
            System.out.println("Enter Receiving id");
            int id = Integer.parseInt(scan.nextLine());
            try {
                Recievings recievings = new RecieveBean().read(id);
                if (recievings != null) {
                    System.out.println(recievings.getId());
                    if( new RecieveBean().delete(recievings)){
                        System.out.println("____________________");
                        System.out.println(recievings +" deleted...");
                        System.out.println("____________________");

                    }
                    else{
                        System.out.println("____________________");
                        System.out.println("sure enough");
                        System.out.println("____________________");

                    }
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }


        }catch (NumberFormatException e) {
            System.out.println("Please enter an integer....");
            e.printStackTrace();
        }
    }

}

