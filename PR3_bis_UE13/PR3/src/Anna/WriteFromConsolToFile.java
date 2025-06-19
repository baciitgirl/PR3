package Anna;

import java.io.*;
import java.util.Scanner;

public class WriteFromConsolToFile {
    public static void main(String[] args) {
        // Zielpfad definieren
        String filePath = "C:/Testp3/FileIO/input.txt";

        // Text vom Benutzer lesen
        String userText = readInputFromConsole();

        // Datei-Objekt vorbereiten
        File file = new File(filePath);

        // Text in Datei schreiben
        writeTextToFile(file, userText);

        // Text aus Datei lesen und ausgeben
        readAndPrintFileContent(file);
    }

    // Methode 1: Text von der Konsole lesen
    private static String readInputFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Gib den Text ein, der in die Datei geschrieben werden soll:");
        String input = scanner.nextLine();
        scanner.close();

        // Null-Check oder leerer String
        if (input == null || input.trim().isEmpty()) {
            System.out.println("Keine gültige Eingabe erkannt – Abbruch.");
            System.exit(0); // Programm sicher beenden
        }

        return input;
    }

    // Methode 2: Text in eine Datei schreiben
    private static void writeTextToFile(File file, String text) {
        try {
            // Prüfen, ob Datei existiert – wenn nicht, wird sie erstellt
            if (!file.exists()) {
                System.out.println("Datei existiert noch nicht. Wird erstellt: " + file.getAbsolutePath());
                file.getParentFile().mkdirs(); // Verzeichnis ggf. anlegen
                file.createNewFile();
            }

            // In Datei schreiben (überschreibt den Inhalt)
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, false));
            writer.write(text);
            writer.newLine();
            writer.close();

            System.out.println("Text wurde erfolgreich in die Datei geschrieben.");
        } catch (IOException e) {
            System.out.println("Fehler beim Schreiben in die Datei: " + e.getMessage());
        }
    }

    // Methode 3: Dateiinhalt lesen und auf Konsole ausgeben
    private static void readAndPrintFileContent(File file) {
        if (!file.exists()) {
            System.out.println("Die Datei existiert nicht – nichts zum Anzeigen.");
            return;
        }

        System.out.println("\nInhalt der Datei \"" + file.getName() + "\":");

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();
        } catch (IOException e) {
            System.out.println("Fehler beim Lesen der Datei: " + e.getMessage());
        }
    }
}
