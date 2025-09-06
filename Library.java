import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Library {

  private ArrayList<Book> books;

  public Library() {
    this.books = new ArrayList<>();
  }

  Scanner sc = new Scanner(System.in);

  public void addBook(Book book) {
    Book foundBook = searchBookByISBN(book.getIsbn());
    if (foundBook != null) {
      System.out.println("Book with the same ISBN " + book.getIsbn() + " already exists.");
      return;
    }
    books.add(book);
    System.out.println("Book added successfully.");

  }

  private Book searchBookByISBN(long isbn) {

    for (Book b : books) {
      if (b.getIsbn() == isbn) {
        return b;
      }

    }
    return null;
  }

  public void displayAllBooks() {
    if (books.isEmpty()) {
      System.out.println("No books in the library.");
      return;
    }
    for (Book b : books) {
      System.out.println(b.displayBook());
    }
  }

  public void updateBookQuantityByISBN(long isbn) {
    Book book = searchBookByISBN(isbn);
    if (book == null) {
      System.out.println("Book with ISBN " + isbn + " not found.");
      return;
    }
    System.out.println("Updating quantity... ");
    System.out.println("Enter new qty: ");
    int qty = Integer.parseInt(sc.nextLine());

    if (qty <= 0) {
      System.out.println("Invalid quantity!!!");
      return;
    } else {
      book.setQuantity(qty);
      System.out.println("Quantity updated successfully.new quantity = " + book.getQuantity());
    }
  }

  public void deleteBookByTitle(String title) {
    if (title == null || title.isBlank()) {
      System.out.println("Book Title cannot be blank.");
      return;
    }
    Iterator<Book> itr = books.iterator();

    while (itr.hasNext()) {
      Book b = itr.next();
      if (b.getTitle().equalsIgnoreCase(title)) {
        itr.remove();
        System.out.println(title + " book has removed successfully...");
        return;
      }
    }
    System.out.println("Book with title " + title + " not found.");

  }
}
