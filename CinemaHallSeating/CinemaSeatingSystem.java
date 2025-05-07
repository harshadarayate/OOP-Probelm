// 19) Create a Java program for a seating system in a cinema hall represented by a 2D array (rows × columns).
// • Mark all seats as available (e.g., 0) initially.

// • Allow the user to book seats by marking them as booked (e.g., 1).

// • 
// • Display the current seat map (matrix form).

// • Add functionality to check if a given seat is available before booking.


import java.util.Scanner;

public class CinemaSeatingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Define size of the cinema hall
        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();

        int[][] seats = new int[rows][cols]; // 0 = available, 1 = booked

        int choice;
        do {
            System.out.println("\n--- Cinema Hall Seating System ---");
            System.out.println("1. View Seat Map");
            System.out.println("2. Book a Seat");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    displaySeatMap(seats);
                    break;

                case 2:
                    System.out.print("Enter row number (0 to " + (rows - 1) + "): ");
                    int r = sc.nextInt();
                    System.out.print("Enter column number (0 to " + (cols - 1) + "): ");
                    int c = sc.nextInt();

                    if (isValidSeat(r, c, rows, cols)) {
                        if (seats[r][c] == 0) {
                            seats[r][c] = 1;
                            System.out.println("Seat booked successfully!");
                        } else {
                            System.out.println("Seat already booked.");
                        }
                    } else {
                        System.out.println("Invalid seat position.");
                    }
                    break;

                case 3:
                    System.out.println("Thank you for using the system. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);

        sc.close();
    }

    // Display seat map
    public static void displaySeatMap(int[][] seats) {
        System.out.println("\nSeat Map (0 = Available, 1 = Booked):");
        for (int[] row : seats) {
            for (int seat : row) {
                System.out.print(seat + " ");
            }
            System.out.println();
        }
    }

    // Check if given seat indices are valid
    public static boolean isValidSeat(int row, int col, int maxRows, int maxCols) {
        return row >= 0 && row < maxRows && col >= 0 && col < maxCols;
    }
}
