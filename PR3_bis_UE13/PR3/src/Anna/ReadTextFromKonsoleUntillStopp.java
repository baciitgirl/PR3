package Anna;

import java.io.*;

public class ReadTextFromKonsoleUntillStopp {


    public static void main(String[] args) {
        String directoryPath = "C:/Testp3/FileIO";
        String fileName = "output.txt";

        greetUser();

        if (!ensureDirectoryExists(directoryPath)) {
            System.out.println("Fehler: Zielverzeichnis konnte nicht erstellt werden.");
            return;
        }

        File file = new File(directoryPath + "/" + fileName);

        try {
            readInputAndWriteToFile(file);
            printFileContent(file);
        } catch (IOException e) {
            System.out.println("Fehler beim Dateizugriff: " + e.getMessage());
        }
    }

    // Methode: Begrüßung und Benutzerhinweise
    public static void greetUser() {
        System.out.println("===== Texteingabe-Programm mit Dateiausgabe =====");
        System.out.println("Gib beliebige Zeilen ein. Mit 'STOP' beendest du das Programm.");
        System.out.println("Die Eingaben werden in eine Datei geschrieben und am Ende angezeigt.\n");
    }

    // Methode: Prüft, ob das Zielverzeichnis existiert – wenn nicht, wird es erstellt
    public static boolean ensureDirectoryExists(String path) {
        File dir = new File(path);
        if (!dir.exists()) {
            return dir.mkdirs(); // true wenn erfolgreich
        }
        return true; // existiert bereits
    }

    // Methode: Liest Benutzereingaben und schreibt sie in die Datei
    public static void readInputAndWriteToFile(File file) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new FileWriter(file, true)); // anhängen

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

    // Methode: Liest den Inhalt der Datei und gibt ihn auf der Konsole aus
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


