package at.campus02.pr3.fileio.binaryoutput;
import java.io.*;

public class SerialisationBinaryUe16AnnaVar {

    /*
     * Dieses Programm speichert ein String-Objekt ("Hello World") und ein Byte-Array
     * serialisiert in einer Datei ("object.dat"). Anschließend werden beide Objekte
     * wieder aus der Datei gelesen und in der Konsole ausgegeben.
     *
     * Verwendet werden:
     * - FileOutputStream & ObjectOutputStream zum Schreiben
     * - FileInputStream & ObjectInputStream zum Lesen
     */

    public static void main(String[] args) {
        String text = "Hello World";
        byte[] byteArray = {'e', 'x', 'a', 'm', 'p', 'l', 'e'};
        File file = new File("object.dat");

        // Objekt(e) in Datei schreiben
        writeObjectsToFile(file, text, byteArray);

        // Objekt(e) wieder aus Datei lesen und anzeigen
        readObjectsFromFile(file);
    }

    private static void writeObjectsToFile(File file, String text, byte[] byteArray) {
        try (
                FileOutputStream fos = new FileOutputStream(file);
                ObjectOutputStream oos = new ObjectOutputStream(fos)
        ) {
            oos.writeObject(text);
            oos.writeObject(byteArray);
            System.out.println("Objekte wurden erfolgreich serialisiert.");
        } catch (IOException e) {
            System.err.println("Fehler beim Schreiben in die Datei: " + e.getMessage());
        }
    }

    private static void readObjectsFromFile(File file) {
        try (
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis)
        ) {
            // Objekt 1: String lesen
            String readText = (String) ois.readObject();
            System.out.println("STRING: " + readText);

            // Objekt 2: Byte-Array lesen und als String interpretieren
            byte[] readBytes = (byte[]) ois.readObject();
            System.out.println("BYTE[]: " + new String(readBytes));
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Fehler beim Lesen der Datei: " + e.getMessage());
        }
    }
}
