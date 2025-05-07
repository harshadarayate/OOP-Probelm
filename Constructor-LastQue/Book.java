
// 42) A) Write a Java program to create a class called "Book" with instance variables title, author, and price. Implement a default constructor and two parameterized constructors:
// One constructor takes the title and author as parameters.
// The other constructor takes title, author, and price as parameters.
// Print the values of the variables for each constructor.

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

// B) Write a Java program to create a class called "TrafficLight" with attributes for color and duration, 
// and methods to change the color and check for red or green.

// class TrafficLight {
//     private String color;
//     private int duration; // in seconds

//     public TrafficLight(String color, int duration) {
//         this.color = color;
//         this.duration = duration;
//     }

//     public void changeColor(String newColor) {
//         this.color = newColor;
//         System.out.println("Traffic light changed to: " + color);
//     }

//     public boolean isRed() {
//         return color.equalsIgnoreCase("red");
//     }

//     public boolean isGreen() {
//         return color.equalsIgnoreCase("green");
//     }

//     public void displayStatus() {
//         System.out.println("Current Color : " + color);
//         System.out.println("Duration      : " + duration + " seconds");
//     }

//     public static void main(String[] args) {
//         TrafficLight light = new TrafficLight("Red", 60);
//         light.displayStatus();

//         System.out.println("Is Red? " + light.isRed());
//         System.out.println("Is Green? " + light.isGreen());

//         light.changeColor("Green");
//         light.displayStatus();
//         System.out.println("Is Red? " + light.isRed());
//         System.out.println("Is Green? " + light.isGreen());
//     }
// }
