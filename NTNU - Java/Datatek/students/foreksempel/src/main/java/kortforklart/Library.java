package kortforklart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Library {
	
	private List<Book> books = new ArrayList<>();
	
	public void addBook(Book book) {
		this.books.add(book);
	}
	
	public void rentBook(Book book) {
		book.setRented(true);
	}
	
	public void returnBook(Book book) {
		book.setRented(false);
	}
	
	public void functionalInterfaces() {
		Comparator<Book> comparator = new BookComparator();
		Collections.sort(this.books, comparator);
		
		Collections.sort(this.books, new Comparator<Book>() {
			@Override
			public int compare(Book b1, Book b2) {
				return b1.getName().compareTo(b2.getName());
			}
		});
		
		Collections.sort(this.books, (b1, b2) -> b1.getName().compareTo(b2.getName()));
		
		Predicate<Book> predicate = new Predicate<Book>() {
			public boolean test(Book b) {
				return b.getNumberOfPages() > 10;
			}
		};
		
		this.books.stream().filter(b -> b.getNumberOfPages() > 10).collect(Collectors.toList());
	}
	
	public void playWithStream() {
		List<Book> nonRentedBooks = this.books.stream().filter(book -> book.isRented() == false).collect(Collectors.toList());
		List<Book> booksWithoutPrequelOrSequel = this.books.stream().filter(
									book -> book.getPrequel() == null && book.getPrequel() == null)
									.collect(Collectors.toList());
		
		int totalNumberOfPages = this.books.stream().mapToInt(Book::getNumberOfPages).sum();
		int totalNumberOfPagesInNonRentedBooks = this.books.stream().filter(book -> book.isRented() == false).mapToInt(Book::getNumberOfPages).sum();
		
		boolean isAnyBookWithoutPrequelOrSequel = this.books.stream().anyMatch(book -> book.getPrequel() == null && book.getPrequel() == null);
		
		int totalNumberOfPagesWithReduce = this.books.stream().mapToInt(Book::getNumberOfPages).reduce((b1, b2) -> b1 + b2).getAsInt();

	}
	
	public static void main(String[] args) {
		Book lotr1 = new Book("The fellowship of the ring", 350);
		Book lotr2 = new Book("The two towers", 377);
		Book lotr3 = new Book("Return of the king", 420);
		lotr1.setSequel(lotr2);
		lotr2.setPrequel(lotr1);
		lotr2.setSequel(lotr3);
		lotr3.setPrequel(lotr2);
		Book java = new Book("Big Java", 510);
		
		Library library = new Library();
		library.addBook(lotr1);
		library.addBook(lotr2);
		library.addBook(lotr3);
		library.addBook(java);
	}

}
