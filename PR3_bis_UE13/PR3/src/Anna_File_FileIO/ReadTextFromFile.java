package Anna_File_FileIO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadTextFromFile {


    public static void main(String[] args) {
        System.out.println("Inhalt einer Datei in der Konsole ausgeben");
        readFileContent();


    }

    public static void readFileContent() {
        //Datei definieren
        File file = new File("C:\\Testp3\\LI\\LoremIpsum.txt");

        // try-with-resources:
        // Die runden Klammern (FileReader fr = ..., BufferedReader br = ...)
        // öffnen automatisch die Ressourcen und stellen sicher,
        // dass sie nach dem try-Block automatisch wieder geschlossen werden – egal, ob ein Fehler auftritt oder nicht.


        // FileReader: Liest Zeichen aus der Datei. Er liest die Datei zeichenweise – gut für Textdateien (nicht für Binärdaten!).
        // BufferedReader: Puffert die Zeichen und ermöglicht readLine() (erlaubt das zeilenweise Einlesen über readLine()). Vorteil: effizienteres Lesen, insbesondere bei größeren Dateien
        try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr)) {

            // Variante 1: Mit while-Schleife
            // Liest Zeile für Zeile, solange noch Daten vorhanden sind
            String zeile;
            int i = 0;
            while ((zeile = br.readLine()) != null) {
                System.out.println("Zeile " + i + ": '" + zeile + "'");
                i++;
            }

            // Variante 2: Mit for-Schleife (funktional identisch, nur kompakter)
            /*
            for (int o = 0; (zeile = br.readLine()) != null; o++) {
                System.out.println("Zeile " + o + ": '" + zeile + "'");
            }
            */

        } catch (IOException e) {
            System.err.println("Fehler beim Lesen der Datei: " + e.getMessage());
            e.printStackTrace();
        }
    }
}


