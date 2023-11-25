import java.util.ArrayList;
import java.util.List;

class Book {
    private String title;
    private String author;
    private int year;
    private boolean available;

    public Book(String title, String author, int year, boolean available) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.available = available;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Назва: " + title + "\n" +
               "Автор: " + author + "\n" +
               "Рiк: " + year + "\n" +
               "Доступна: " + (available ? "Так" : "Нi") +
               "\n--------";
    }
}

class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void rentBook(String title, String user) {
        for (Book book : books) {
            if (book.getTitle().equals(title) && book.isAvailable()) {
                book.setAvailable(false);
                System.out.println("Книга успiшно взята в читання користувачем " + user);
                return;
            }
        }
        System.out.println("Книгу '" + title + "' не вдалося взяти в читання");
    }

    public void returnBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                book.setAvailable(true);
                System.out.println("Книга успiшно повернута.");
                return;
            }
        }
        System.out.println("Книгу '" + title + "' не вдалося повернути (не знайдено)");
    }

    public void displayAllBooks() {
        System.out.println("Всi книги:");
        for (Book book : books) {
            System.out.println(book);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        Book harryPotter1 = new Book("Гаррi Поттер i фiлософський камiнь", "Джоан Роулiнг", 1997, true);
        Book witcher = new Book("Вiдьмак. Меч призначення", "Анджей Сапковський", 1992, true);
        Book harryPotter2 = new Book("Гаррi Поттер i таємна кiмната", "Джоан Роулiнг", 1998, true);

        library.addBook(harryPotter1);
        library.addBook(witcher);
        library.addBook(harryPotter2);

        library.displayAllBooks();

        library.rentBook("Гаррi Поттер i фiлософський камiнь", "iванов");
        library.rentBook("Гаррi Поттер i таємна кiмната", "Петров");

        library.displayAllBooks();

        library.returnBook("Гаррi Поттер i фiлософський камiнь");
        library.displayAllBooks();
    }
}
