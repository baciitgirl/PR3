package Anna;

import java.io.File;

public class InfoAboutDirectory {

    public static void main(String[] args) {
        System.out.println("Information über ein Verzeichen ausgeben:");
        String path = "C:\\Testp3\\";
        long totalSize = listDirectory(path); //Es wird die gesamte Größe ausgegeben
        System.out.println("Gesamtgröße aller Files: " + totalSize + " Bytes");
    }

    public static long listDirectory(String path) {
        File folder = new File(path); //Pfad zu einem bestimmten Ordner
        File[] listOfFiles = folder.listFiles(); //in diesem Ordner werden die Dateien in ein Array gespeichert
        long totalSize = 0; //Variable für die gesamte Dateigröße

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    System.out.println("Gesamtsumme bis jetzt: " + totalSize);
                    System.out.println("*************************************");
                    System.out.println("File: " + file.getName() +
                            " Size: " + file.length()
                    );
                    totalSize += file.length(); // Datei-Größe in Bytes addieren
                } else {
                    System.out.println("Directory: " + file.getName());
                    // Rekursiver Aufruf für das Unterverzeichnis
                    totalSize += listDirectory(file.getAbsolutePath());
                }
            }
        } else {
            System.out.println("Pfad ungültig oder nicht lesbar: " + path);
        }

        return totalSize;
    }
}


