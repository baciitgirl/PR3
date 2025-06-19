package at.campus02.pr3.file.ue3;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        System.out.println("UE3 Files und Dir ausgeben, mit Sizes und Total Size");
        long gesamtGroesze = listDirectory("K:\\Users\\b50394\\OneDrive - FH CAMPUS 02"+
                "\\Documents\\Lehre\\Programmieren3_SS2025\\Tag 1 - 01a FileIO\\a");
        //listDirectory("C:\\Users\\b50394");
        System.out.println("Gesamtgröße aller Files: " + gesamtGroesze);
    }
    public static long listDirectory(String path) {
        long sum = 0;
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        for (File file : listOfFiles) {
            if (file.isFile()) {
                System.out.println("-File: " + file.getName() +
                        " Size: " + file.length() +
                        " Gesamtsumme bis jetzt: " + sum);
                sum = sum + file.length();
            } else { // file ist ein Directory
                System.out.println("-Dir: " + file.getName());
                // Rekursion: in Unterverzeichnisse gehen?
                // sum = sum + listDirectory(file.getAbsolutePath());
            }
        }
        return sum;
    }
}
