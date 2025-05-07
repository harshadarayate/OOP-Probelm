class Book {
    String title;
    String author;
    double price;

    // Default constructor
    public Book() {
        title = "Unknown";
        author = "Unknown";
        price = 0.0;
    }

    // Constructor with title and author
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.price = 0.0;
    }

    // Constructor with title, author, and price
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void displayDetails() {
        System.out.println("Title : " + title);
        System.out.println("Author: " + author);
        System.out.println("Price : " + price);
        System.out.println("------------------------");
    }

    public static void main(String[] args) {
        Book b1 = new Book(); // default
        Book b2 = new Book("Atomic Habits", "James Clear"); // 2-parameter
        Book b3 = new Book("Clean Code", "Robert Martin", 450.0); // 3-parameter

        System.out.println("Book 1 Details:");
        b1.displayDetails();

        System.out.println("Book 2 Details:");
        b2.displayDetails();

        System.out.println("Book 3 Details:");
        b3.displayDetails();
    }
}
