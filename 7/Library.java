import java.util.HashMap;
import java.util.Map;

public class Library {
    private Map<String, Book> bookMap;

    public Library() {
        this.bookMap = new HashMap<>();
    }

    public void addBook(Book book) {
        bookMap.put(book.getTitle(), book);
    }

    public void removeBook(String title) {
        bookMap.remove(title);
    }

    public Book findBookByTitle(String title) {
        return bookMap.get(title);
    }

    public void printAllBooks() {
        for (Book book : bookMap.values()) {
            System.out.println(book);
        }
    }

    public static void main(String[] args) {
        Library library = new Library();

        library.addBook(new Book("1984", "George Orwell", 1949));
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee", 1960));
        library.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925));

        System.out.println("Все книги в библиотеке:");
        library.printAllBooks();

        System.out.println("\nПоиск книги по названию '1984':");
        System.out.println(library.findBookByTitle("1984"));

        library.removeBook("1984");
        System.out.println("\nВсе книги в библиотеке после удаления '1984':");
        library.printAllBooks();
    }
}
