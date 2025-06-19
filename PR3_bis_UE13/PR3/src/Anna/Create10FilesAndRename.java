package Anna;

import java.io.File;
import java.io.IOException;

public class Create10FilesAndRename {
    public static void main(String[] args) throws IOException {
        System.out.println("Erstellen Dateien und Umbenennen");
//        String path = "C:" + File.separator +
//                "Users" + File.separator + "b50394" + File.separator +
//                "IdeaProjects" + File.separator + "PR3_local" + File.separator + "test";

        String path = "C:" + File.separator + "Testp3";

        //1) erstelle 10 files FERTIG
        createFiles(path);

        //2) benenne diese 10 Files um
        //2a) alle 10 files auflisten
        renameFiles(path);
    }

    public static void createFiles(String path) throws IOException {
        for (int i = 1; i < 11; i++) { // 10x ausführen
            File file1 = new File(path + File.separator + "file" + i + ".txt");
            boolean success = file1.createNewFile();
            //Überprüfen, ob Datei erstellt ist:
            if (success) {
                System.out.println("Datei erstellt: " + file1.getName());
            } else {
                System.out.println("Datei existiert bereits: " + file1.getName());
            }
        }
    }

    public static void renameFiles(String path) {
        File folder = new File(path); // path ist der selbe wie oben
        File[] listOfFiles = folder.listFiles();
        if (listOfFiles == null) return; // Sicherstellen, dass der Ordner existiert

        //Variante 1
//        for (File oldFile : listOfFiles) {
//            if (oldFile.isFile()) {
//                String newFileName = "1_" + oldFile.getName();
//                System.out.print("File: " + oldFile.getName() +
//                        " -> " + newFileName + ": ");
//                File newFile = new File(oldFile.getParent()
//                        + File.separator + newFileName);
//                if (oldFile.renameTo(newFile)) {
//                    System.out.println("SUCCESS");
//                } else {
//                    System.out.println("ERROR");
//                }
//            }
//        }

        //Variante 2
        // Über alle Dateien im Verzeichnis iterieren
        for (File oldFile : listOfFiles) {
            // Nur reguläre Dateien verarbeiten (keine Unterordner)
            if (oldFile.isFile()) {
                String name = oldFile.getName(); // z. B. "file5.txt"

                // Letzten Punkt im Dateinamen finden (Trennzeichen zwischen Name und Endung)
                int dotIndex = name.lastIndexOf('.');

                // Wenn kein Punkt im Dateinamen vorhanden ist (dotIndex == -1),
                // dann bleibt der baseName der vollständige Name und die extension ist leer.
                // Andernfalls: baseName = alles vor dem letzten Punkt, extension = alles ab dem Punkt (inkl. Punkt)
                String baseName = (dotIndex == -1) ? name : name.substring(0, dotIndex);
                String extension = (dotIndex == -1) ? "" : name.substring(dotIndex);


                // Neuen Dateinamen zusammensetzen: Basisname + "_1" + Dateiendung
                String newFileName = baseName + "_1" + extension;

                // Ausgabe der Umbenennung vorbereiten
                System.out.print("File: " + name + " -> " + newFileName + ": ");

                // Neues File-Objekt mit dem neuen Namen im selben Verzeichnis erstellen
                File newFile = new File(oldFile.getParent() + File.separator + newFileName);

                // Datei umbenennen und Erfolg prüfen
                if (oldFile.renameTo(newFile)) {
                    System.out.println("SUCCESS");
                } else {
                    System.out.println("ERROR");
                }
            }
        }
    }
}
