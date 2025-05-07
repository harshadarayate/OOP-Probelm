import java.util.*;

// Vehicle Interface
interface Vehicle {
    void startRide();
    void endRide();
    double calculateFare(int distance);
}

// PricingStrategy Interface
interface PricingStrategy {
    double adjustFare(double baseFare);
}

// Concrete Pricing Strategies
class NormalPricing implements PricingStrategy {
    public double adjustFare(double baseFare) {
        return baseFare;
    }
}

class PeakHourPricing implements PricingStrategy {
    public double adjustFare(double baseFare) {
        return baseFare * 1.5;
    }
}

class HolidayPricing implements PricingStrategy {
    public double adjustFare(double baseFare) {
        return baseFare * 2.0;
    }
}

// Bike Class
class Bike implements Vehicle {
    private PricingStrategy strategy;

    public Bike(PricingStrategy strategy) {
        this.strategy = strategy;
    }

    public void startRide() {
        System.out.println("Bike ride started.");
    }

    public void endRide() {
        System.out.println("Bike ride ended.");
    }

    public double calculateFare(int distance) {
        double baseFare = distance * 5;
        return strategy.adjustFare(baseFare);
    }
}

// Auto Class
class Auto implements Vehicle {
    private PricingStrategy strategy;

    public Auto(PricingStrategy strategy) {
        this.strategy = strategy;
    }

    public void startRide() {
        System.out.println("Auto ride started.");
    }

    public void endRide() {
        System.out.println("Auto ride ended.");
    }

    public double calculateFare(int distance) {
        double baseFare = distance * 8;
        return strategy.adjustFare(baseFare);
    }
}

// Cab Class
class Cab implements Vehicle {
    private PricingStrategy strategy;

    public Cab(PricingStrategy strategy) {
        this.strategy = strategy;
    }

    public void startRide() {
        System.out.println("Cab ride started.");
    }

    public void endRide() {
        System.out.println("Cab ride ended.");
    }

    public double calculateFare(int distance) {
        double baseFare = 50 + distance * 10;
        return strategy.adjustFare(baseFare);
    }
}

// Main Class
public class VehicleFareSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Vehicle Fare System ===");
            System.out.println("1. Bike");
            System.out.println("2. Auto");
            System.out.println("3. Cab");
            System.out.println("4. Exit");
            System.out.print("Choose Vehicle Type: ");
            int vehicleChoice = scanner.nextInt();

            if (vehicleChoice == 4) {
                System.out.println("Exiting the program.");
                break;
            }

            if (vehicleChoice < 1 || vehicleChoice > 4) {
                System.out.println("Invalid choice. Try again.");
                continue;
            }

            System.out.print("Enter Distance in KM: ");
            int distance = scanner.nextInt();

            System.out.println("Choose Pricing Strategy:");
            System.out.println("1. Normal");
            System.out.println("2. Peak Hour");
            System.out.println("3. Holiday");
            System.out.print("Enter choice: ");
            int strategyChoice = scanner.nextInt();

            PricingStrategy strategy;
            switch (strategyChoice) {
                case 2:
                    strategy = new PeakHourPricing();
                    break;
                case 3:
                    strategy = new HolidayPricing();
                    break;
                default:
                    strategy = new NormalPricing();
            }

            Vehicle vehicle;
            switch (vehicleChoice) {
                case 1:
                    vehicle = new Bike(strategy);
                    break;
                case 2:
                    vehicle = new Auto(strategy);
                    break;
                case 3:
                    vehicle = new Cab(strategy);
                    break;
                default:
                    System.out.println("Invalid vehicle choice!");
                    continue;
            }

            vehicle.startRide();
            double fare = vehicle.calculateFare(distance);
            System.out.printf("Total Fare: ₹%.2f\n", fare);
            vehicle.endRide();
        }

        scanner.close();
    }
}
