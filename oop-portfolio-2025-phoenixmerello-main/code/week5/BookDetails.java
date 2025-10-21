package week5;



public class BookDetails {

    private String title;
    private String author;
    private String publisher;
    private int copyrightDate;

    public BookDetails(String title, String author, String publisher, int copyrightDate) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.copyrightDate = copyrightDate;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
       return publisher;
    }

    public int getCopyrightDate() {
        return copyrightDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setCopyrightDate(int copyrightDate) {
        this.copyrightDate = copyrightDate;
    }

    public String toString() {
        return "Book Title: " + title + ", Author: " + author + ", Publisher: " + publisher + ", Copyright Date: " + copyrightDate;
    }

}

class Bookshelf {
    public static void main(String[] args) {

        BookDetails book1 = new BookDetails("To Kill a Mockingbird", "Harper Lee", "J.B. Lippincott & Co.", 1960);
        BookDetails book2 = new BookDetails("1984", "George Orwell", "Secker & Warburg", 1949);
        BookDetails book3 = new BookDetails("Moby-Dick", "Herman Melville", "Harper & Brothers", 1851);


        System.out.println("Book 1 Details:");
        System.out.println("--------------");
        System.out.println(book1.toString());
        System.out.println();

        System.out.println("Book 2 Details:");
        System.out.println("--------------");
        System.out.println(book2.toString());
        System.out.println();

        System.out.println("Book 3 Details:");
        System.out.println("--------------");
        System.out.println(book3.toString());
        System.out.println();


        book1.setTitle("The Catcher in the Rye");
        book1.setAuthor("J.D. Salinger");
        book1.setPublisher("Little, Brown and Company");
        book1.setCopyrightDate(1951);

        System.out.println("Updated Book 1 Details:");
        System.out.println("----------------------");
        System.out.println(book1.toString());
        System.out.println();


        book2.setTitle("Pride and Prejudice");
        book2.setAuthor("Jane Austen");
        book2.setPublisher("T. Egerton, Whitehall");
        book2.setCopyrightDate(1813);

        System.out.println("Updated Book 2 Details:");
        System.out.println("----------------------");
        System.out.println(book2.toString());
        System.out.println();


        book3.setTitle("The Great Gatsby");
        book3.setAuthor("F. Scott Fitzgerald");
        book3.setPublisher("Charles Scribner's Sons");
        book3.setCopyrightDate(1925);

        System.out.println("Updated Book 3 Details:");
        System.out.println("----------------------");
        System.out.println(book1.toString());


    }

}
