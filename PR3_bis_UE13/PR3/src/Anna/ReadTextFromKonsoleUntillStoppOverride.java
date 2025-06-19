package Anna;

import java.io.*;

public class ReadTextFromKonsoleUntillStoppOverride {


    public static void main(String[] args) {
        String directoryPath = "C:/Testp3/FileIO";
        String fileName = "outputOverride.txt";

        greetUser();

        if (!ensureDirectoryExists(directoryPath)) {
            System.out.println("Fehler: Zielverzeichnis konnte nicht erstellt werden.");
            return;
        }

        File file = new File(directoryPath + "/" + fileName);

        try {
            readInputAndOverwriteFile(file);  // Datei wird jedes Mal neu geschrieben
            printFileContent(file);
        } catch (IOException e) {
            System.out.println("Fehler beim Dateizugriff: " + e.getMessage());
        }
    }

    // Methode: Begrüßung und Benutzerhinweise
    public static void greetUser() {
        System.out.println("===== Texteingabe-Programm (mit Dateiüberschreiben) =====");
        System.out.println("Gib beliebige Zeilen ein. Mit 'STOP' beendest du das Programm.");
        System.out.println("Die Eingaben werden in eine Datei geschrieben und am Ende angezeigt.\n");
    }

    // Methode: Verzeichnis erstellen (falls nicht vorhanden)
    public static boolean ensureDirectoryExists(String path) {
        File dir = new File(path);
        if (!dir.exists()) {
            return dir.mkdirs();
        }
        return true;
    }

    // Methode: Liest Eingaben und schreibt sie in die Datei (überschreibt alte Datei)
    public static void readInputAndOverwriteFile(File file) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new FileWriter(file, false)); // false = überschreiben

        String line = br.readLine();
        while (!line.equalsIgnoreCase("STOP")) {
            System.out.println("Eingabe erkannt: \"" + line + "\"");
            writer.write(line);
            writer.newLine();
            line = br.readLine();
        }

        writer.close();
        br.close();
    }

    // Methode: Inhalt der Datei anzeigen
    public static void printFileContent(File file) throws IOException {
        System.out.println("\nProgramm wird beendet.");
        System.out.println("Gesamter Inhalt der Datei '" + file.getName() + "':\n");

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String fileLine;
        while ((fileLine = reader.readLine()) != null) {
            System.out.println(fileLine);
        }
        reader.close();

        System.out.println("\nDateiausgabe abgeschlossen.");
    }
}


