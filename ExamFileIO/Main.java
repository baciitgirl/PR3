
import java.io.*;
import java.util.Scanner;

public class Main {
    private static final String FILE_PATH = "data" + File.separator + "persons.dat";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        File file = new File(FILE_PATH);

        // Datei existiert bereits → auslesen
        if (file.exists()) {
            readFromFile(file);
        } else {
            // Datei & Verzeichnis anlegen
            file.getParentFile().mkdirs();
            writeNewPerson(file, scanner);
        }
    }

    private static void writeNewPerson(File file, Scanner scanner) {
        try (
                FileOutputStream fos = new FileOutputStream(file);
                ObjectOutputStream oos = new ObjectOutputStream(fos)
        ) {
            System.out.print("Gib deinen Namen ein: ");
            String name = scanner.nextLine();

            System.out.print("Gib dein Alter ein: ");
            int age = Integer.parseInt(scanner.nextLine());

            Person p = new Person(name, age);
            oos.writeObject(p);

            System.out.println("Person gespeichert: " + p);
        } catch (IOException | NumberFormatException e) {
            System.err.println("Fehler beim Schreiben: " + e.getMessage());
        }
    }

    private static void readFromFile(File file) {
        try (
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis)
        ) {
            Person p = (Person) ois.readObject();
            System.out.println("Gelesene Person aus Datei:");
            System.out.println(p);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Fehler beim Lesen: " + e.getMessage());
        }
    }
}