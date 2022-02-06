package of1.lf;

public class Book {

    private String title;
    private int numPages;

    public Book(int numPages, String title) {
        this.title = title;
        this.numPages = numPages;
    }

    public String getTitle() {
        return this.title;
    }

    public int getNumPages() {
        return this.numPages;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }

    @Override
    public String toString() {
        return "The book \"" + getTitle() + "\" has " + this.getNumPages() + " pages.";
    }

    public static void main(String[] args) {

        Book book = new Book(100, "Big Java");

        System.out.println(book);

        book.setNumPages(718);
        book.setTitle("Introduction to Algorithms");
        System.out.println(book);

    }

}
