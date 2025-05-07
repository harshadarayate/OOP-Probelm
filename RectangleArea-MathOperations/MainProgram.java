import java.util.Scanner;

class Rectangle {
    private int length;
    private int breadth;

    // Constructor using 'this'
    public Rectangle(int length, int breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    // Method to calculate area
    public int getArea() {
        return length * breadth;
    }

    // Compare area with another rectangle
    public void compareArea(Rectangle r) {
        int firstRect = this.getArea();
        int secondRect = r.getArea();

        System.out.println("First Rectangle Area: " + firstRect);
        System.out.println("Second Rectangle Area: " + secondRect);

        if (firstRect > secondRect) {
            System.out.println("First rectangle is larger.");
        } else if (firstRect < secondRect) {
            System.out.println("Second rectangle is larger.");
        } else {
            System.out.println("Both rectangles have the same area.");
        }
    }
}

class MathOperations {
    // Static method
    public static int square(int n) {
        return n * n;
    }

    // Instance method
    public int cube(int n) {
        return n * n * n;
    }
}

public class MainProgram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input for first rectangle
        System.out.println("Enter length and breadth of Rectangle 1:");
        int l1 = sc.nextInt();
        int b1 = sc.nextInt();
        Rectangle r1 = new Rectangle(l1, b1);

        // Input for second rectangle
        System.out.println("Enter length and breadth of Rectangle 2:");
        int l2 = sc.nextInt();
        int b2 = sc.nextInt();
        Rectangle r2 = new Rectangle(l2, b2);

        // Compare areas
        r1.compareArea(r2);

        // Math operations
        System.out.println("\n--- Math Operations ---");
        System.out.print("Enter a number to calculate square and cube: ");
        int number = sc.nextInt();

        int square = MathOperations.square(number); // static method
        MathOperations math = new MathOperations(); // instance for cube
        int cube = math.cube(number); // instance method

        System.out.println("Square of " + number + " is: " + square);
        System.out.println("Cube of " + number + " is: " + cube);

        sc.close();
    }
}
