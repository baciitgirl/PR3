package at.campus02.pr3.file.ue8_from_cronsole_to_console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("UE 8");
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String line = br.readLine();
        while (! line.equalsIgnoreCase("STOP")) {
            System.out.println("Zeile gelesen: " + line);
            line = br.readLine();
        }
        System.out.println("Es wurde 'STOP' eingegeben, beende das Program.");
    }
}
