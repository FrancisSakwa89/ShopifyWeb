package views;

import com.franco.controller.Main;
import com.franco.models.*;
import com.franco.Bean.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class SaleUI {
    String choice = null;
    int ch = 0;
    Scanner scan = new Scanner(System.in);

    public SaleUI() {
        mainMenu();
    }

    public void mainMenu() {
        do {
            System.out.println("****************************");
            System.out.println("Welcome to the sale sector..\nSelect option\n1.Create Sale\n2.Get Sales by saleId\n3.Edit sale\n4.Delete sale\n5.Read all sales\n6.Back to Main Menu");
            choice = scan.nextLine();


            try {
                ch = Integer.parseInt(choice);
                switch (ch) {
                    case 1:
                        try {
                            createSale();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 2:
                        try {
                            readSale();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        break;
                    case 3:
                        try {
                            updateSale();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    case 4:
                        deleteSale();
                        break;
                    case 5:
                        readAll();
                        break;

                    case 6:
                        System.out.println("_____________________");
                        System.out.println("Main menu");
                        Main.mainMenu();
                }
            } catch (NumberFormatException e) {
                System.out.println("Enter valid input integer..");
                e.printStackTrace();
            }

        }while (ch != 6) ;
    }
    public void createSale() throws SQLException {

        ArrayList<Sale> sales = new ArrayList<>();
        Recievings recievings1 = new Recievings();
        ProductBean productBean = new ProductBean();
        RecieveBean recieveBean = new RecieveBean();
        SaleBean saleBean = new SaleBean();
        Date datetime = new Date();

        System.out.println("Enter product id: ");
        int productId = Integer.parseInt(scan.nextLine());

        if (recieveBean.isProductExists(productId)) {

            Recievings recievings = null;
            try {
                recievings = recieveBean.read(productId);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            Customer customer;
            Product product;
            try {

                new ProductBean().read(productId).getId();
                try {
                    if (recievings != null) {

                        System.out.println("Enter quantity: ");
                        int quantity = Integer.parseInt(scan.nextLine());

                        int sellingPrice = 0;
                        try {
                            sellingPrice = (int) recieveBean.read(productId).getSellingPrice();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        System.out.println("Enter customer UserId: ");
                        int UserId = Integer.parseInt(scan.nextLine());
                        customer = new CustomerBean().read(UserId);
                        if (CustomerBean.isCustomerExists(UserId) && recieveBean.isRecievingExists(productId)) {
                            if(recieveBean.read(productId).getQuantity() > quantity){
                            String customerName = customer.getName();

                            Sale sale = new SaleBean().read(productId);
                            try {
                                int runningBalance;

                                runningBalance = recieveBean.read(productId).setQuantity(sale.setRunningBalance(recieveBean.read(productId).getQuantity()) - (quantity));
                                double totalAmount = recieveBean.read(productId).getSellingPrice() * quantity;
                                sale = new Sale(datetime, productId, quantity, customerName, sellingPrice, runningBalance, totalAmount);
                            } catch (SQLException e) {
                                System.out.println("You got a null pointer error");
                                e.printStackTrace();
                            }

                            try {
//                                SaleBean  = new SaleBean();
                                saleBean.create(sale);
                                System.out.println("Created successfully..." + sale);
                                System.out.println("________________________________________________");

                            } catch (SQLException e) {
                                e.printStackTrace();
                            }

                            System.out.println("Want to add more sales y/n");
                            String answer = scan.nextLine();

                            if (answer.equals("n")) {

                            }else createSale();
                            sales.add(sale);
                        }
                            else {
                                System.out.println("_____________________________________________________________________________________________");
                                System.out.println("kindly check the available stock before you buy" +" the available quantity is: ");
                                System.out.println("Product name: "+productBean.read(productId).getName()+" quantity: "+recieveBean.read(productId).getQuantity());
                                System.out.println("_____________________________________________________________________________________________");
                            }
                    }else {
                            System.out.println("___________________________________________________________________________________________");
                            System.out.println("User with the user Id does not exist...or the product does not exist");
                            System.out.println("___________________________________________________________________________________________");

                        }


                    } else {
                        System.out.println("Receiving List is empty");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (NumberFormatException e) {
                    System.out.println("_____________________________");
                    System.out.println("Product doesn't exist...");
                    System.out.println("_____________________________");
                    e.printStackTrace();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }else {
            System.out.println("_____________________________");
            System.out.println("Product Has not been received...");
            System.out.println("_____________________________");
        }

    }

    public void readSale() throws SQLException {
        ArrayList<Sale> sales = new ArrayList<>();
        Recievings recievings = new Recievings();
        Sale sale = null;
        System.out.println("Enter product Id: ");
        int id = Integer.parseInt(scan.nextLine());
        RecieveBean recieveBean = new RecieveBean(); ;
        if(recieveBean.isRecievingExists(id) && recieveBean.read(id).getQuantity() > 0) {
            Product product = null;
            try {
                product = new ProductBean().read(id);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                sale = new SaleBean().read(id);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println("Enter Sale Id: ");
            int saleId = Integer.parseInt(scan.nextLine());
            try {
                Sale sale1 = new SaleBean().read(saleId);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (sale != null && product != null) {
                ProductBean productBean = new ProductBean();
                SaleBean saleBean = new SaleBean();
                System.out.println("Customer successfully got....");

                System.out.println("______________________________________________________________________________");
                System.out.println("Product id: " + saleBean.read(saleId).getProductId() + " Product Name: " + productBean.read(id).getName() + " Quantity: " + saleBean.read(saleId).getQuantity() + " Customer Name: " + saleBean.read(saleId).getCustomerName());
                System.out.println("______________________________________________________________________________");

            }
        }else {
            System.out.println("___________________________________");
            System.out.println("Product Id does not exist...");
            System.out.println("___________________________________");

        }

    }

    public void readAll() {

        try {
            ArrayList<Sale> sales = new SaleBean().readAll();
            ProductBean productBean = new ProductBean();
            System.out.println("SALE ID     DATE      QUANTITY      PRICE       PRODUCT NAME     CUSTOMER NAME     TOTAL");
            for (Sale sale : sales) {
                double total = 0;
                total += (sale.getQuantity() * sale.getSellingPrice());
                System.out.println("_____________________________________________________________________________________________");

                System.out.println(sale.getSaleId() + "         " + sale.getDatetime() + "        " + sale.getQuantity() + "      " + sale.getSellingPrice() + "               " + productBean.read(sale.getProductId()).getName() + "         " + sale.getCustomerName() + "           " + total);
                System.out.println("______________________________________________________________________________________________");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void updateSale() throws SQLException {

        System.out.println("Enter Sale Id: ");
        int saleId = Integer.parseInt(scan.nextLine());
        Sale sale = null;
        try {
            sale = new SaleBean().read(saleId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Product product;
        try {
            product = new ProductBean().read(saleId);
            Sale sale1 = new SaleBean().read(saleId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Update quantity value: ");
        int quantity = Integer.parseInt(scan.nextLine());


        sale.setQuantity(quantity);


        if (sale != null) {
            new SaleBean().update(sale);
            System.out.println("________________________________");
            System.out.println("Updated successfully...." + sale.getQuantity());
            System.out.println("________________________________");
        }
    }

    public void deleteSale() {
        System.out.println("Enter sale id");
        int id = Integer.parseInt(scan.nextLine());
        try {
            Sale sale = new SaleBean().read(id);
            if (sale != null) {
                System.out.println(sale.getSaleId());
                if (new SaleBean().delete(sale)) {

                    System.out.println(sale + " deleted...");
                } else {
                    System.out.println("sure enough");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}


