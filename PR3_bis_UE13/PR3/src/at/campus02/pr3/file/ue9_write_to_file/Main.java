package at.campus02.pr3.file.ue9_write_to_file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("UE9 : write to file");
        File f = new File("test" + File.separator + "test.txt");
        FileWriter fw = new FileWriter(f, true); //appending to file
        PrintWriter pw = new PrintWriter(fw);
        pw.println("Erste Zeile");
        pw.println("Zweite Zeile");
        for (int i = 0; i < 3; i++) {
            pw.println(i);
        }
        pw.flush();
        pw.close();
    }
}
