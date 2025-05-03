import java.util.Scanner;

public class PascalsTriangle{

    // Print one row of Pascal's Triangle using your logic
    public static void printPascalRow(int n) {
        int ans = 1;
        System.out.print(ans + " ");  // First value is always 1

        for (int i = 1; i <= n; i++) {
            ans = ans * (n - i + 1);
            ans = ans / i;
            System.out.print(ans + " ");
        }

        System.out.println();
    }

    // Print entire Pascal's Triangle up to Nth row (inclusive)
    public static void printPascalsTriangle(int rows) {
        for (int i = 0; i <= rows; i++) {
            // Print spaces for triangle shape
            for (int space = 0; space < rows - i; space++) {
                System.out.print(" ");
            }
            // Print row using your logic
            printPascalRow(i);
        }
    }

    public static void printNumberTriangle(int rows) {
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter N (number of rows): ");
        int N = scanner.nextInt();

        System.out.println("\nPascal's Triangle:");
        printPascalsTriangle(N);

        System.out.println("\nNumber Triangle:");
        printNumberTriangle(N);
        scanner.close();
    }
}
