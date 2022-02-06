package kortforklart;

public class Book {
	private String name;
	private Book sequel;
	private Book prequel;
	
	private boolean isRented;
	
	private int numberOfPages;
	
	public Book(String name, int numberOfPages) {
		this.name = name;
		this.numberOfPages = numberOfPages;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Book getSequel() {
		return sequel;
	}
	public void setSequel(Book sequel) {
		this.sequel = sequel;
	}
	public Book getPrequel() {
		return prequel;
	}
	public void setPrequel(Book prequel) {
		this.prequel = prequel;
	}
	
	public boolean isRented() {
		return isRented;
	}
	public void setRented(boolean isRented) {
		this.isRented = isRented;
	}
	public int getNumberOfPages() {
		return this.numberOfPages;
	}
	
	
}
