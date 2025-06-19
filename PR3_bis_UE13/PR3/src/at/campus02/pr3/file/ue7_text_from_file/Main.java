package at.campus02.pr3.file.ue7_text_from_file;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("UE7");
        File file = new File("C:\\Users\\b50394\\IdeaProjects\\PR3_local\\test\\test.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        /*
        System.out.println( "erste Zeile: '" + br.readLine() + "'");
        System.out.println( "zweite Zeile: '" + br.readLine()+ "'");
        System.out.println( "dritte Zeile: '" + br.readLine()+ "'");
        System.out.println( "vierte Zeile: '" + br.readLine()+ "'");
        */
        String meineZeile;
        //Variante 1 mit WHILE
        int i =0;
        while ((meineZeile = br.readLine()) != null) {
            System.out.println("Zeile " + i + ": '" + meineZeile + "'");
            i++;
        }

        //Variante 2 mit FOR
        //for(int o = 0;(meineZeile = br.readLine()) != null ;o++)
        //{
        //    System.out.println("Zeile " + o + ": '" + meineZeile + "'");
        //}
        br.close();
    }
}
