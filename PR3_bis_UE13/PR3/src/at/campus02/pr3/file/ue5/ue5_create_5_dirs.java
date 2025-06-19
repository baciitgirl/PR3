package at.campus02.pr3.file.ue5;

import java.io.File;

public class ue5_create_5_dirs {
    public static void main(String[] args) {
        System.out.println("Create 3 directories");

        String path = "C:\\Testp3\\";
        File theDir = new File(path + "\\UNTERVERZ");
        if (!theDir.exists()) {
            theDir.mkdirs();
        }
        System.out.println("Wurde das Verz erstellt: ");

        // new File("src").delete();
        // new File("eins_b").delete();
        // new File("eins_c").delete();
    }
}
