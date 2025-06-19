package at.campus02.pr3.fileio.binaryoutput;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class binary_output_fileOutputStream {

    public static void main(String[] args) throws IOException {

        File file = new File("test-output.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file);


        String outputText = "Hello File - first output";
        for (char c : outputText.toCharArray()) {
            fileOutputStream.write(c);
        }

        fileOutputStream.flush();
        fileOutputStream.close();

    }
}
