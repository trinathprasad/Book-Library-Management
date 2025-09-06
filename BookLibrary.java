import java.util.Scanner;

public class BookLibrary {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    Library lib = new Library();
    int choice;

    do {
      System.out.println();
      System.out.println("=================Book Managment System=============");
      System.out.println("\t1. Add Book");
      System.out.println("\t2. Display Books");
      System.out.println("\t3. Update Quantity");
      System.out.println("\t4. Delete Book");
      System.out.println("\t5. Exit");
      System.out.println("Enter the choice: ");
      choice = Integer.parseInt(sc.nextLine());
      switch (choice) {
        case 1: {
          System.out.println("Enter book title:  ");
          String title = sc.nextLine();

          System.out.println("Enter book author:  ");
          String author = sc.nextLine();

          System.out.println("Enter book ISBN:  ");
          long isbn = Long.parseLong(sc.nextLine());

          System.out.println("Enter book price:  ");
          double price = Double.parseDouble(sc.nextLine());

          System.out.println("Enter book qty:  ");
          int qty = Integer.parseInt(sc.nextLine());

          Book book = new Book(title, author, isbn, price, qty);
          lib.addBook(book);

        }
          break;

        case 2: {
          lib.displayAllBooks();
        }
          break;

        case 3: {
          System.out.println("Enter ISBN number: ");
          long isbn = Long.parseLong(sc.nextLine());
          lib.updateBookQuantityByISBN(isbn);

        }
          break;

        case 4: {
          System.out.println("Enter Book Title : ");
          String title = sc.nextLine();
          lib.deleteBookByTitle(title);

        }
          break;

        case 5:
          System.out.println("Thank you for visit.");
          break;

        default:
          System.out.println("Invalid choice!!!");
      }

    } while (choice != 5);

    sc.close();
  }

}
