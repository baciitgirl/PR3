package Anna;

import java.io.*;

public class ReadBinaryFromFile {


    public static void main(String[] args) throws IOException {
        createBinaryFile();
        readBinaryFile();
    }


    //CREATE BINARY
    public static void createBinaryFile() {
        // Pfad zur Ausgabedatei (inklusive Dateiname mit Endung!)
        String filePath = "C:\\Testp3\\Binary\\data.bin";

        // Beispiel-Daten in Byteform (65 = 'A', 66 = 'B', etc.)
        byte[] data = {65, 66, 67, 68, 0, 10};
        // Alternative Daten, falls Datei bereits existiert
        byte[] data1 = {70, 71, 72, 73, 13, 10}; // "FGHI" + CRLF

        // Sicherheitscheck: Daten dürfen nicht null sein
        if (data == null || data.length == 0) {
            System.err.println("Keine Daten zum Schreiben vorhanden.");
            return;
        }

        // Verzeichnis sicherstellen
        File file = new File(filePath);
        File parentDir = file.getParentFile();

        if (parentDir != null && !parentDir.exists()) {
            boolean dirCreated = parentDir.mkdirs();
            if (!dirCreated) {
                System.err.println("Verzeichnis konnte nicht erstellt werden: " + parentDir.getAbsolutePath());
                return;
            }
        }

        // Schreibe die Bytes in die Datei
        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(data);
            System.out.println("Binärdatei erfolgreich geschrieben: " + filePath);
        } catch (IOException e) {
            System.err.println("Fehler beim Schreiben der Datei: " + e.getMessage());
        }


        //Variante 2
        // Prüfe, ob Datei bereits existiert
        if (file.exists()) {
            System.out.println("Datei existiert bereits. Überschreibe mit anderen Daten (data1).");
            try (FileOutputStream fos = new FileOutputStream(file)) {
                fos.write(data1);
                System.out.println("Alternative Binärdaten erfolgreich geschrieben: " + filePath);
            } catch (IOException e) {
                System.err.println("Fehler beim Schreiben der Datei: " + e.getMessage());
            }
        } else {
            // Datei existiert noch nicht – schreibe Originaldaten
            try (FileOutputStream fos = new FileOutputStream(file)) {
                fos.write(data);
                System.out.println("Binärdatei erfolgreich geschrieben: " + filePath);
            } catch (IOException e) {
                System.err.println("Fehler beim Schreiben der Datei: " + e.getMessage());
            }
        }
    }


    //READ BYNARY

    public static void readBinaryFile() {
        // Pfad zur Datei – anpassen falls nötig
        String filePath = "C:\\Testp3\\Binary\\data.bin";
        File file = new File(filePath);

        // Prüfe, ob Datei existiert und gültig ist
        if (file == null || !file.exists()) {
            System.err.println("Datei existiert nicht: " + filePath);
            return;
        }

        if (!file.isFile()) {
            System.err.println("Pfad ist keine Datei: " + filePath);
            return;
        }

        if (file.length() == 0) {
            System.err.println("Datei ist leer: " + filePath);
            return;
        }


        // Datei einlesen und Werte ausgeben
        try (FileInputStream fis = new FileInputStream(file)) {
            int byteRead;
            System.out.println("Dateiinhalt:");
            System.out.printf("%-10s %-12s %-8s%n", "Dezimal", "Hexadezimal", "ASCII");
            System.out.println("-------------------------------------");
            while ((byteRead = fis.read()) != -1) {
                // ASCII-Zeichen nur für druckbare Zeichen anzeigen
                String asciiChar = (byteRead >= 32 && byteRead <= 126) ? Character.toString((char) byteRead) : "nicht druckbar";

                System.out.printf("%-10d 0x%02X        %s%n", byteRead, byteRead, asciiChar);
            }
        } catch (IOException e) {
            System.err.println("Fehler beim Lesen der Datei: " + e.getMessage());
        }
    }


}


