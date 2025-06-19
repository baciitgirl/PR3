package at.campus02.pr3.file.ue12_read_text;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        createBinaryFile();
        readBinaryFile();
    }

    public static void createBinaryFile() {
        // Pfad zur Ausgabedatei (inklusive Dateiname mit Endung!)
        String filePath = "C:\\Testp3\\Binary\\data.bin";

        // Beispiel-Daten in Byteform (65 = 'A', 66 = 'B', etc.)
        byte[] data = {65, 66, 67, 68, 0, 10};

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
    }


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

        // Versuche, die Datei Byte für Byte zu lesen
        try (FileInputStream fis = new FileInputStream(file)) {
            int byteRead;
            System.out.println("Dateiinhalt (dezimal):");
            while ((byteRead = fis.read()) != -1) {
                System.out.print(byteRead + " ");
            }
            System.out.println(); // Zeilenumbruch nach Ausgabe
        } catch (IOException e) {
            System.err.println("Fehler beim Lesen der Datei: " + e.getMessage());
        }
    }
}
