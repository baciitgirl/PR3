package at.campus02.pr3.fileio.binaryoutput;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ue_15 {
    /*

    Java FileOutputStream is an output stream used for writing data to a file.

    If you have to write primitive values into a file,
    use FileOutputStream class. You can write byte-oriented as
    well as character-oriented data through FileOutputStream class.
    But, for character-oriented data, it is preferred to use FileWriter
    than FileOutputStream.

     */

    public static void main(String[] args) throws IOException {
        File file = new File("test-output.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file);

        char c;
        while ((c = (char) System.in.read()) != 'x') {
            fileOutputStream.write(c);
            System.out.println(c);
        }
        fileOutputStream.flush();
        fileOutputStream.close();
        System.out.println("Closed");
    }

}