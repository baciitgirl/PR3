package at.campus02.pr3.file.ue10_from_console_to_file;

import java.io.*;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) throws IOException {
        double o = Math.sqrt(9);
        System.out.println("UE 10");
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String line = br.readLine();
        //öffne file (von UE09)
        File f = new File("test" + File.separator + "test.txt");
        FileWriter fw = new FileWriter(f); //appending to file
        PrintWriter pw = new PrintWriter(fw);
        pw.println("UE10 schreibt folgendes:");

        while (! line.equalsIgnoreCase("STOP")) {
            System.out.println("Zeile gelesen: " + line);
            pw.println("input: " + line);
            line = br.readLine(); //warte bis Benutzerin eine Zeile eingibt
        }

        for (int i = 0; i < 10000; i++) {
            pw.println(i);
        }
        pw.println("input: " + line);
        System.out.println("Es wurde 'STOP' eingegeben, beende das Program.");
        //schließe file
        pw.flush();
        pw.close();
    }
}
