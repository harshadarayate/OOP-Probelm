import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class PrimeNumberArrayList {

    // Method to check if a number is prime
    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create an ArrayList with numbers 1 to 25
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 25; i++) {
            list.add(i);
        }

        System.out.println("Original ArrayList:");
        System.out.println(list);

        // Part A: Remove prime numbers using iterator
        Iterator<Integer> itr = list.iterator();
        while (itr.hasNext()) {
            int num = itr.next();
            if (isPrime(num)) {
                itr.remove();
            }
        }

        System.out.println("After removing prime numbers:");
        System.out.println(list);

        // Part B-a: Traversing using for-loop
        System.out.println("\nTraversing using for-loop:");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }

        // Traversing using iterator
        System.out.println("\n\nTraversing using Iterator:");
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }

        // Traversing using enhanced for-loop
        System.out.println("\n\nTraversing using enhanced for-loop:");
        for (int num : list) {
            System.out.print(num + " ");
        }

        // Part B-b: Check if an element exists (user input)
        System.out.print("\n\nEnter a number to check if it exists in the ArrayList: ");
        int check = sc.nextInt();
        if (list.contains(check)) {
            System.out.println(check + " exists in the ArrayList.");
        } else {
            System.out.println(check + " does not exist in the ArrayList.");
        }

        // Part C: Add element at a particular index
        System.out.print("\nEnter the element to insert: ");
        int element = sc.nextInt();
        System.out.print("Enter the index to insert at (0 to " + list.size() + "): ");
        int index = sc.nextInt();

        if (index >= 0 && index <= list.size()) {
            list.add(index, element);
            System.out.println("ArrayList after insertion:");
            System.out.println(list);
        } else {
            System.out.println("Invalid index.");
        }

        sc.close();
    }
}
