package com.franco.controller;

import views.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        userName();
        Main.mainMenu();
        UI();

    }

    public static void mainMenu(){
        int choice;
        System.out.println("\nSelect option\n1.Products\n2.Receivings\n3.Sales\n4.Get product Running balance\n5.Go to Customers..\n6.Quit");
    }


    public static String userName() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your Name: ");
        String customerName = scan.nextLine();
        if (customerName.length() != 0) {
            System.out.println("Welcome to my mall store..." + customerName.toUpperCase());
            System.out.println("_____________________________________");
            return customerName;
        } else {
            System.out.println("_____________________________________");
            System.out.println("Please enter a valid name !!!");
            System.out.println("_____________________________________");

            userName();
        }
        return customerName;
    }

    public static void UI() {
        Scanner scan = new Scanner(System.in);
        int choice;
        do {
            choice = 0;
            try {
                choice = Integer.parseInt(scan.nextLine());
                if (choice < 1 || choice > 6) {
                    System.out.println("________________________________________________________________________________________");
                    System.out.println("That was an incorrect input (input out of range). Try Again");
                    System.out.println("________________________________________________________________________________________");
                }
            } catch (NumberFormatException ex) {
                System.out.println("_______________________________________");
                System.out.println("Please enter a valid number not x-ter" + " ," + ex);
                ex.printStackTrace();
                System.out.println("___________________________________________");
            }

            switch (choice) {
                case 1:
                    new ProductUI();
                    break;

                case 2:
                    new RecieveUI();

                    break;
                case 3:

                    new SaleUI();

                    break;
                case 4:

                    new RunningBalanceUI();
                    break;

                case 5:
                    new CustomerUI();
                    break;
                case 6:
                        System.out.println("__________________________________________________________________________");
                        System.out.println("Thanks for visiting us , Good bye");
                        System.out.println("__________________________________________________________________________");

                    break;

            }

        } while (choice != 6);

    }


}


