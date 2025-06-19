
import java.io.Serializable;

public class Book implements Serializable {
    private String title;
    private String author;
    private String isbn;
    private double price;

    public Book(String title, String author, String isbn, double price) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.price = price;
    }

    public String toCSV() {
        return title + ";" + author + ";" + isbn + ";" + price;
    }

    public String toFormattedText() {
        return "Titel: " + title +
                " | Autor: " + author +
                " | ISBN: " + isbn +
                " | Preis: " + price + " €";
    }


    /**
     * Erstellt ein Book-Objekt aus einer CSV-Textzeile.
     * Erwartetes Format: Titel;Autor;ISBN;Preis
     *
     * @param line die CSV-Zeile als String
     * @return ein neues Book-Objekt mit den Werten aus der Zeile
     */
    public static Book fromCSV(String line) {
        // Zerlege die CSV-Zeile an jedem Semikolon
        String[] parts = line.split(";");

        // parts[0] = Titel, parts[1] = Autor, parts[2] = ISBN, parts[3] = Preis (als String)
        // Erstelle neues Book-Objekt mit diesen Werten, Preis wird in double konvertiert
        return new Book(parts[0], parts[1], parts[2], Double.parseDouble(parts[3]));
    }


    public double getPrice() {
        return price;
    }

    public String toString() {
        return title + " von " + author + " | ISBN: " + isbn + " | Preis: " + price + "€";
    }
}
