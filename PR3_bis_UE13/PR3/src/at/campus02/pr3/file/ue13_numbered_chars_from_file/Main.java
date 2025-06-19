package at.campus02.pr3.file.ue13_numbered_chars_from_file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("UE13: Read BINARY from file, number the chars");

        File file = new File("C:\\Testp3\\FileIO\\input.txt");

        if (!file.exists()) {
            System.err.println("Datei nicht gefunden: " + file.getAbsolutePath());
            return;
        }

        FileInputStream fis = new FileInputStream(file);
        int byteRead;
        int i = 0;

        System.out.println("i: DEZ  |  CHAR");
        System.out.println("-------------------");

        while ((byteRead = fis.read()) != -1) {
            // Byte als Zeichen interpretieren
            char c = (char) byteRead;

            // Formatierte Ausgabe: z. B. 0:  72  |  H
            System.out.printf("%2d: %3d  |  %s%n", i, byteRead, (Character.isISOControl(c) ? "?" : c));
            i++;
        }

        fis.close();
        System.out.println("--- Ende ---");
    }
}
