package Anna_File_FileIO;

import java.io.File;

public class InfoAboutFile {
    public static void main(String[] args) {
        System.out.println("Information über meine Datei:");
        String myPfad = "C:\\Testp3\\LI\\LoremIpsum.txt";
        readFileInformation(myPfad);

    }


    public static void readFileInformation(File f1) {

        //Existiert die Datei?
        System.out.println("Does The file exist? \t" + f1.exists());
        System.out.println("File.getName()? \t\t" + f1.getName());
        System.out.println("File.getParent() \t\t" + f1.getParent());   //Verzeichnis, wo die Datei gespeichert ist
        System.out.println("File.isAbsolute() \t\"" + f1.isAbsolute() + '"');
        System.out.println("File.getAbsolutePath() \t\t" + f1.getAbsolutePath()); //Zeigt den Pfad
        System.out.println("File.length() \t\t" + f1.length() + " Byte"); //Dateigröße
    }

    public static void readFileInformation(String pfad) {
        File myFile = new File(pfad);
        readFileInformation(myFile);
    }
}
