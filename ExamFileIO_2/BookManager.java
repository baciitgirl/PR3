import java.io.*;
import java.util.List;

public class BookManager {
    private final File datFile;
    private final File txtFile;

    /**
     * Konstruktor für den BookManager.
     * Er erstellt zwei File-Objekte für die .dat- und .txt-Dateien
     * und stellt sicher, dass die übergeordneten Verzeichnisse existieren.
     *
     * @param datPath Pfad zur binären Datei (.dat)
     * @param txtPath Pfad zur Textdatei (.txt)
     */
    public BookManager(String datPath, String txtPath) {
        // Erzeuge Dateiobjekte für binäre und Textspeicherung
        this.datFile = new File(datPath);
        this.txtFile = new File(txtPath);

        // Erstelle ggf. übergeordnete Verzeichnisse für die Dateien
        // Beispiel: aus "data/books.dat" wird "data/" → mkdirs() legt es an, falls nicht vorhanden
        datFile.getParentFile().mkdirs();
        txtFile.getParentFile().mkdirs();
    }


    public void saveBooks(List<Book> books) {
        // 1. Binär speichern (.dat)
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(datFile))) {
            oos.writeObject(books);
            System.out.println("✅ Bücher wurden als .dat gespeichert.");
        } catch (IOException e) {
            System.err.println("Fehler beim Schreiben in .dat: " + e.getMessage());
        }

        // 2. Lesbar als Text speichern (.txt)
        try (PrintWriter writer = new PrintWriter(new FileWriter(txtFile))) {
            for (Book b : books) {
                writer.println(b.toFormattedText());
            }
            System.out.println("✅ Bücher wurden als lesbares .txt gespeichert.");
        } catch (IOException e) {
            System.err.println("Fehler beim Schreiben in .txt: " + e.getMessage());
        }
    }

    /**
     * Lädt eine Liste von Büchern aus der .dat-Datei (binäre Serialisierung).
     * Gibt eine leere Liste zurück, wenn die Datei nicht existiert oder ein Fehler auftritt.
     *
     * @return Liste der geladenen Bücher (evtl. leer)
     */
    public List<Book> loadBooks() {
        // Wenn die Datei nicht existiert, gib eine leere Liste zurück
        if (!datFile.exists()) return new java.util.ArrayList<>();

        try (
                // Öffne Datei mit ObjectInputStream (für Deserialisierung)
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(datFile))
        ) {
            // Lies und cast das gelesene Objekt zu einer Liste von Book
            return (List<Book>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            // Falls Fehler beim Lesen oder Casten auftreten, gib leere Liste zurück
            System.err.println("Fehler beim Lesen aus .dat: " + e.getMessage());
            return new java.util.ArrayList<>();
        }
    }

}
