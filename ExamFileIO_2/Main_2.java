import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main_2 {
    private static final String DAT_PATH = "data/books.dat";
    private static final String TXT_PATH = "data/books.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BookManager manager = new BookManager(DAT_PATH, TXT_PATH);

        List<Book> books = manager.loadBooks();

        if (!books.isEmpty()) {
            System.out.println("📚 Vorhandene Bücher:");
            books.forEach(System.out::println);
        }

        System.out.println("\n📥 Neue Bücher eingeben (leerer Titel = Ende):");
        while (true) {
            System.out.print("Titel: ");
            String title = scanner.nextLine();
            if (title.trim().isEmpty()) break;

            System.out.print("Autor: ");
            String author = scanner.nextLine();

            System.out.print("ISBN: ");
            String isbn = scanner.nextLine();

            System.out.print("Preis: ");
            double price = Double.parseDouble(scanner.nextLine());

            books.add(new Book(title, author, isbn, price));
        }

        manager.saveBooks(books);
        System.out.println("✅ Speichern abgeschlossen.");
    }
}