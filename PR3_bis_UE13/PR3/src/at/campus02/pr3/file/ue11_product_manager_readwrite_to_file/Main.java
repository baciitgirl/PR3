package at.campus02.pr3.file.ue11_product_manager_readwrite_to_file;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("UE 11: Save and Load from file");
        ProductManager pm = new ProductManager();
        Product p1 = new Product("Name 1", 1.0, "Kategorie 1");
        Product p2 = new Product("Name 2", 2.0, "Kategorie 2");
        //System.out.println("Product 1: " + p1);
        pm.add(p1);
        pm.add(p2);
        pm.saveToFile("C:\\Testp3\\Products\\products.txt");
        pm.readFromFile("C:\\Testp3\\Products\\products.txt");
    }
}