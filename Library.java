package practice0;

import java.util.ArrayList;

public class Library {

	String Library_addresses;
	ArrayList<Book> Book = new ArrayList<Book>();
	static String openging_hour = "9Am";
	static String closing_hour = "5pm";

	public Library(String Library_addresses) {
		this.Library_addresses = Library_addresses;

	}

	public void addBook(Book book) {
		this.Book.add(book);
	}

	public static void printOpeningHours() {
		System.out.println("Libraries are open daily from " + openging_hour + " to " + closing_hour);
	}

	public void printAddress() {
		System.out.println(this.Library_addresses);
	}

	public void borrowBook(String book) {
		boolean isBook = false;
		for (int i = 0; i < Book.size(); i++) {
			if (Book.get(i).getTitle().equals(book) && !Book.get(i).borrowed) {
				Book.get(i).borrowed();
				System.out.println("You successfully borrowed " + book);
				isBook = Book.get(i).getTitle().equals(book);
				break;
			} else if (Book.get(i).getTitle().equals(book) && Book.get(i).borrowed) {
				System.out.println("Sorry, this book is already borrowed.");
				isBook = Book.get(i).getTitle().equals(book);
				break;
			}

		}
		if (!isBook) {
			System.out.println("Sorry, this book is not in our catalog.");
		}
	} // borrow a book from one library's book collections.

	public void printAvailableBooks() {
		boolean available = false;
		for (int i = 0; i < Book.size(); i++) {
			if (!Book.get(i).borrowed) {
				available = true;
				System.out.println(Book.get(i).getTitle());
			}
		}
		if (available == false) {
			System.out.println("No book in catalog");
		}

	}

	public void returnBook(String booktitle) {
		for (int i = 0; i < Book.size(); i++) {
			if (Book.get(i).getTitle().equals(booktitle)) {
				Book.get(i).returned();
			}
		}

	}

	// Add the missing implementation to this class

	public static void main(String[] args) {
		// Create two libraries
		Library firstLibrary = new Library("10 Main St.");
		Library secondLibrary = new Library("228 Liberty St.");
		// Add four books to the first library
		firstLibrary.addBook(new Book("The Da Vinci Code"));

		firstLibrary.addBook(new Book("Le Petit Prince"));

		firstLibrary.addBook(new Book("A Tale of Two Cities"));

		firstLibrary.addBook(new Book("The Lord of the Rings"));

		// Print opening hours and the addresses
		System.out.println("Library hours:");

		printOpeningHours();

		System.out.println();

		System.out.println("Library addresses:");

		firstLibrary.printAddress();

		secondLibrary.printAddress();

		System.out.println();

		// Try to borrow The Lords of the Rings from both libraries
		System.out.println("Borrowing The Lord of the Rings:");

		firstLibrary.borrowBook("The Lord of the Rings");

		firstLibrary.borrowBook("The Lord of the Rings");

		secondLibrary.borrowBook("The Lord of the Rings");

		System.out.println();

		// Print the titles of all available books from both libraries
		System.out.println("Books available in the first library:");

		firstLibrary.printAvailableBooks();

		System.out.println();

		System.out.println("Books available in the second library:");

		secondLibrary.printAvailableBooks();

		System.out.println();
		// Return The Lords of the Rings to the first library
		System.out.println("Returning The Lord of the Rings:");
		firstLibrary.returnBook("The Lord of the Rings");
		System.out.println();
		// Print the titles of available from the first library
		System.out.println("Books available in the first library:");
		firstLibrary.printAvailableBooks();
	}
}
