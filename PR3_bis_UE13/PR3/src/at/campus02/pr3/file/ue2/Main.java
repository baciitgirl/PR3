package at.campus02.pr3.file.ue2;
import java.io.File;
public class Main {
    public static void main(String[] args) {
        System.out.println("UE2 Files und Dir ausgeben");
        listDirectory("C:\\Users\\b50394\\OneDrive - FH CAMPUS 02\\" + "Documents\\Lehre\\Programmieren3_SS2025\\");
        System.out.println("Gesamtgröße aller Files: ");
    }
    public static void listDirectory(String path){
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        for (File file : listOfFiles) {
            if (file.isFile()) {
                System.out.println("-File: " + file.getName());
            } else { // file ist ein Directory
                System.out.println("-Dir: " + file.getName() );
            }
        }
    }
}
