package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ProgramProduct {
    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);

        List<Product> products = new ArrayList<>();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 1; i <= n ; i++) {
            System.out.printf("Product #%d data:%n", i);
            System.out.print("Common, used or imported (c/u/i)? ");
            char answer = sc.nextLine().charAt(0);
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Price: ");
            Double price = sc.nextDouble();
            sc.nextLine();
            if (answer == 'c') {
                Product product = new Product(name, price);
                products.add(product);
            } else if (answer == 'i') {
                System.out.print("Customs fee: ");
                Double fee = sc.nextDouble();
                sc.nextLine();
                Product product = new ImportedProduct(name, price, fee);
                products.add(product);
            } else if (answer == 'u') {
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                Date manufacturedDate = sdf.parse(sc.next());
                Product product = new UsedProduct(name, price, manufacturedDate);
                products.add(product);
            }
        }

        System.out.println();
        System.out.println("PRICE TAGS");
        for (Product p : products) {
            System.out.println(p.priceTag());
        }

        sc.close();
    }
}
