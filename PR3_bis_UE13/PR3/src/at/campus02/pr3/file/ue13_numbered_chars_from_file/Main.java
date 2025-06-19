package at.campus02.pr3.file.ue13_numbered_chars_from_file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("UE13: Read BINARY from file, number the chars");

        File file = new File("C:\\Users\\b50394\\IdeaProjects\\PR3_local\\test\\test.txt");
        FileInputStream fis = new FileInputStream(file);
        int byteRead;
        int i=0;
        System.out.println("i: DEZ CHAR");
        while ((byteRead = fis.read()) != -1){
            char[] ch = Character.toChars(byteRead);
            System.out.print(i + ": " + byteRead + " ");
            System.out.println(ch);
            i++;
        }
    }
}
