package at.campus02.pr3.file.ue1;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world! This is UE 1");
        readFileInformation("C:\\Users\\b50394\\OneDrive - FH CAMPUS 02\\"+
                "Documents\\Lehre\\Programmieren3_SS2025\\yolo1111.txt");
        //readFileInformation("https://upload.wikimedia.org/wikipedia/commons/thumb/2/25/Simon_Stocker_%282023%29.jpg/250px-Simon_Stocker_%282023%29.jpg");
    }
    public static void readFileInformation(File f1){

        //Existiert das File?
        System.out.println("+++Does The file exist? \t" + f1.exists());
        System.out.println("+++file.getName()? \t\t" + f1.getName());
        System.out.println("+++file.getParent() \t\t" + f1.getParent());
        System.out.println("+++file.isAbsolute() \t\"" + f1.isAbsolute() + '"');
        System.out.println("+++file.getAbsolutePath() \t\t" + f1.getAbsolutePath());
        System.out.println("+++file.length() \t\t" + f1.length() + " Byte");
    }
    public static void readFileInformation(String fileString){
        File f1 = new File(fileString);
        readFileInformation(f1);
    }
}