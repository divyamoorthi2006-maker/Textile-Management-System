import java.util.ArrayList;
import java.util.Scanner;

class Product {
    int id;
    String name;
    String fabricType;
    double price;
    int quantity;

    Product(int id, String name, String fabricType, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.fabricType = fabricType;
        this.price = price;
        this.quantity = quantity;
    }

    void display() {
        System.out.println("--------------------------------");
        System.out.println("Product ID   : " + id);
        System.out.println("Product Name : " + name);
        System.out.println("Fabric Type  : " + fabricType);
        System.out.println("Price        : " + price);
        System.out.println("Quantity     : " + quantity);
    }
}

public class TextileManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Product> products = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n====== TEXTILE MANAGEMENT SYSTEM ======");
            System.out.println("1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Search Product");
            System.out.println("4. Calculate Inventory Value");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Product ID: ");
                    int id = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Product Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Fabric Type: ");
                    String fabric = sc.nextLine();

                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();

                    System.out.print("Enter Quantity: ");
                    int qty = sc.nextInt();

                    products.add(new Product(id, name, fabric, price, qty));

                    System.out.println("Product Added Successfully!");
                    break;

                case 2:
                    if (products.isEmpty()) {
                        System.out.println("No products available.");
                    } else {
                        for (Product p : products) {
                            p.display();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Product ID to Search: ");
                    int searchId = sc.nextInt();

                    boolean found = false;

                    for (Product p : products) {
                        if (p.id == searchId) {
                            p.display();
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Product Not Found.");
                    }

                    break;

                case 4:
                    double totalValue = 0;

                    for (Product p : products) {
                        totalValue += p.price * p.quantity;
                    }

                    System.out.println("Total Inventory Value = " + totalValue);

                    break;

                case 5:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}