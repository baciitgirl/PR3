package Anna_File_FileIO;

import java.io.File;

public class Directory_create {
    public static void main(String[] args) {
        System.out.println("Erstelle beim Ausführen ein neues Verzeichnis mit Zähler");

        makeDirectory();
    }

    public static void makeDirectory() {
        String basePath = "C:\\Testp3\\";
        int counter = 1;
        String dirName = "";
        File dir;

        // Suche nach dem ersten Verzeichnisnamen, der noch nicht existiert
        while (true) {
            dirName = "Verzeichnis" + counter;
            dir = new File(basePath + dirName);

            if (!dir.exists()) {
                boolean created = dir.mkdirs();
                System.out.println("Neues Verzeichnis erstellt: " + dir.getPath() + " → " + created);
                // Testdatei erstellen
                try {
                    File testFile = new File(dir, "test.txt");
                    if (testFile.createNewFile()) {
                        System.out.println("Testdatei erstellt: " + testFile.getName());
                    }
                } catch (Exception e) {
                    System.out.println("Fehler beim Erstellen der Testdatei: " + e.getMessage());
                }


                break; // Schleife beenden nach erfolgreichem Erstellen
            }
            counter++;
        }

        //Der Inhalt des Verzeichnis ausgeben:
        File[] files = dir.listFiles();
        if (files != null) {
            for (File f : files) {
                System.out.println(" - " + f.getName());
            }
        } else {
            System.out.println("Verzeichnis ist leer oder nicht lesbar.");
        }
    }

}
