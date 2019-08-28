package views;

import com.franco.Bean.CustomerBean;
import com.franco.Bean.ProductBean;
import com.franco.Bean.RecieveBean;
import com.franco.controller.Main;
import com.franco.models.Product;
import com.franco.models.Recievings;
import com.franco.models.Product;
import com.franco.models.Recievings;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductUI {
    String choice = null;
    int ch = 0;
    Scanner scan = new Scanner(System.in);

    public ProductUI() {
        mainMenu();
    }

    public void mainMenu() {
        do {
            System.out.println("*******************************");
            System.out.println("Welcome to the product sector..\n\"*******************************\"\nSelect option\n1.Add product\n2.View product by id\n3.View All products\n4.Edit product\n5.Delete products\n6.Back to Main Menu");
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
                    createProduct();
                    break;
                case 2:
                    readProduct();
                    break;
                case 3:
                    viewAllProducts();
                    break;
                case 4:
                   updateProduct();
                    break;
                case 5:
                    deleteProduct();
                    break;
                case 6:
                    System.out.println("_____________________");
                    System.out.println("Main menu");
                    Main.mainMenu();

            }

        } while (ch != 6);


    }

    public void createProduct() {
        System.out.println("Enter product name: ");
        String name = scan.nextLine();
        if (name.length() != 0) {
            System.out.println("Enter description: ");
            String description = scan.nextLine();
            Product product = new Product(name, description);
            ProductBean productBean = new ProductBean();

            try {
                try {
                    String answer;
                    System.out.println("\n1.commit\n2.rollback");
                    answer = scan.nextLine();
                    if (answer.equals("1")) {
                        CustomerBean.commit();
                    }
                    if (answer.equals("2")) {
                        CustomerBean.rollBack();
                    }


                    System.out.println("Want to add more records y/n");
                    String ans = scan.nextLine();
                    if (ans.equals("n")) {
                    } else createProduct();

                } catch (Exception e) {
                    e.printStackTrace();
                }
                CustomerBean.commit();
                productBean.create(product);
                System.out.println("Records updated successfully...");
                System.out.println("________________________________________________");

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }else {
            System.out.println("Please enter a valid name");
        }
    }

    public void readProduct() {
        ProductBean productBean = new ProductBean();
        try {
            System.out.println("Enter id: ");
            int id = Integer.parseInt(scan.nextLine());
            try {
                Product product = productBean.read(id);
                System.out.println(product);

            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (NumberFormatException e) {
            System.out.println("Please enter an integer....");
            e.printStackTrace();
        }
    }
    public void updateProduct() {
//        ProductBean productBean = new ProductBean();
        try {
            System.out.println("Enter Product id");
            int id = Integer.parseInt(scan.nextLine());

            try {
                Recievings recievings = new RecieveBean().read(id);
                Product product = new ProductBean().read(id);
                ProductBean productBean = new ProductBean();
                if (product != null && recievings != null) {
                    System.out.println("Name: " + productBean.read(id).getName() + " Id: " + id + " Description: " + productBean.read(id).getDescription());
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println("Enter product Name: ");
            String name = scan.nextLine();
            System.out.println("Enter product Description: ");
            String description = scan.nextLine();
            try {
                Recievings recievings = new RecieveBean().read(id);
                Product product = new ProductBean().read(id);
                if (product != null && recievings != null) {
                    String answer = null;

                    product.setName(name);
                    product.setDescription(description);
                    new ProductBean().update(product);
                }
                System.out.println("Updated successfully,...");
            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid inputs....");
            e.printStackTrace();
        }
    }
    public void deleteProduct() {
        try {
            System.out.println("Enter Product id");
            int id = Integer.parseInt(scan.nextLine());
            try {
                Product product = new ProductBean().read(id);
                if (product != null) {
                    new ProductBean().delete(product);
                    System.out.println(product.getName() + " deleted...");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }


        }catch (NumberFormatException e) {
            System.out.println("Please enter an integer....");
            e.printStackTrace();
        }

    }
    public void viewAllProducts(){
        try {
            ArrayList<Product> products  = new ProductBean().readAll();

            System.out.println("ID     NAME      DESCRIPTION      PRICE         QUANTITY AVAILABLE");
            for (Product product:products){

                Recievings productId = new RecieveBean().read(product.getId());
                System.out.println(product.getId()+"         "+product.getName()+"        "+product.getDescription()+"           "+productId.getSellingPrice()+"            "+productId.getQuantity());
                System.out.println("________________________________________________________________________");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

