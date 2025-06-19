package at.campus02.pr3.fileio.binaryoutput;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class binary_output_BufferedOutputStream {

    public static void main(String[] args) throws IOException {
        File file = new File("test.neu");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

        bufferedOutputStream.write("Hello World".getBytes(StandardCharsets.UTF_8));
        bufferedOutputStream.write(System.lineSeparator().getBytes(StandardCharsets.UTF_8));
        bufferedOutputStream.write("New - line".getBytes(StandardCharsets.UTF_8));
        bufferedOutputStream.flush();
        bufferedOutputStream.close();

    }
}
