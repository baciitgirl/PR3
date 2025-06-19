package at.campus02.pr3.file.ue11_product_manager_readwrite_to_file;

import java.io.*;
import java.security.Principal;
import java.util.ArrayList;

public class ProductManager {
    ArrayList<Product> products = new ArrayList<>();
    
    public void add(Product product) {
        products.add(product);
    }

    public void saveToFile(String filepath) throws FileNotFoundException {
        //öffnen das File
        PrintWriter writer = new PrintWriter(filepath);

        //Schreiben
        //writer.println("Test Schreiben");
        for (Product product : products) {
            writer.println(product.toString());
        }
        //flush + close
        writer.flush(); writer.close();
    }

    public void readFromFile(String path) throws IOException {
        System.out.println("--------- LESE FILE ---------");
        String meineZeile;
        // VON UE 7 ----------------------------
        BufferedReader br = new BufferedReader(new FileReader(path));
        //Variante 1 mit WHILE
        int i =0;
        while ((meineZeile = br.readLine()) != null) {
            System.out.println("Zeile " + i + ": '" + meineZeile + "'");
            i++;
        }
    }
}
