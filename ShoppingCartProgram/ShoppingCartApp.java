import java.util.*;

// Custom Exceptions
class InvalidCouponException extends Exception {
    public InvalidCouponException(String message) {
        super(message);
    }
}

class OutOfStockException extends Exception {
    public OutOfStockException(String message) {
        super(message);
    }
}

class NegativeQuantityException extends Exception {
    public NegativeQuantityException(String message) {
        super(message);
    }
}

// Item class
class Item {
    String name;
    double price;
    int stock;

    public Item(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
}

// CartItem class
class CartItem {
    Item item;
    int quantity;

    public CartItem(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public double getTotal() {
        return item.price * quantity;
    }
}

// ShoppingCart class
class ShoppingCart {
    private List<CartItem> cart = new ArrayList<>();
    private Map<String, Double> coupons = new HashMap<>();
    private double discountPercent = 0;

    public ShoppingCart() {
        coupons.put("SAVE10", 10.0);
        coupons.put("SAVE20", 20.0);
    }

    public void addItem(Item item, int quantity) throws NegativeQuantityException, OutOfStockException {
        if (quantity <= 0) throw new NegativeQuantityException("Quantity cannot be negative or zero.");
        if (item.stock < quantity) throw new OutOfStockException("Only " + item.stock + " left in stock for " + item.name);

        item.stock -= quantity;
        cart.add(new CartItem(item, quantity));
        System.out.println(" Added " + quantity + " x " + item.name + " to cart.");
    }

    public void applyCoupon(String code) throws InvalidCouponException {
        if (!coupons.containsKey(code)) {
            throw new InvalidCouponException("Invalid coupon code: " + code);
        }
        discountPercent = coupons.get(code);
        System.out.println("Coupon applied: " + code + " (" + discountPercent + "% off)");
    }

    public void checkout() {
        double total = 0;
        System.out.println("\n🛒 Cart Summary:");
        for (CartItem ci : cart) {
            System.out.printf("- %s x%d = ₹%.2f\n", ci.item.name, ci.quantity, ci.getTotal());
            total += ci.getTotal();
        }

        double discount = total * (discountPercent / 100.0);
        double finalTotal = total - discount;

        System.out.printf("\nTotal: ₹%.2f\nDiscount: ₹%.2f\nFinal Total: ₹%.2f\n", total, discount, finalTotal);
    }
}

// Main class with user interaction
public class ShoppingCartApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Inventory
        Map<Integer, Item> inventory = new HashMap<>();
        inventory.put(1, new Item("Laptop", 50000, 5));
        inventory.put(2, new Item("Headphones", 2000, 10));
        inventory.put(3, new Item("Mouse", 800, 0)); // Out of stock
        inventory.put(4, new Item("Keyboard", 1500, 7));

        ShoppingCart cart = new ShoppingCart();
        boolean exit = false;

        System.out.println("🛍️ Welcome to Java Shop!");

        while (!exit) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. View Items");
            System.out.println("2. Add Item to Cart");
            System.out.println("3. Apply Coupon");
            System.out.println("4. Checkout");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\nAvailable Items:");
                    for (Map.Entry<Integer, Item> entry : inventory.entrySet()) {
                        Item i = entry.getValue();
                        System.out.printf("%d. %s - ₹%.2f (Stock: %d)\n", entry.getKey(), i.name, i.price, i.stock);
                    }
                    break;

                case 2:
                    System.out.print("Enter item number: ");
                    int itemNum = sc.nextInt();
                    Item selected = inventory.get(itemNum);
                    if (selected == null) {
                        System.out.println("Invalid item number.");
                        break;
                    }
                    System.out.print("Enter quantity: ");
                    int qty = sc.nextInt();
                    try {
                        cart.addItem(selected, qty);
                    } catch (NegativeQuantityException | OutOfStockException e) {
                        System.out.println(" " + e.getMessage());
                    }
                    break;

                case 3:
                    System.out.print("Enter coupon code (SAVE10/SAVE20): ");
                    sc.nextLine(); // clear buffer
                    String code = sc.nextLine();
                    try {
                        cart.applyCoupon(code.toUpperCase());
                    } catch (InvalidCouponException e) {
                        System.out.println(" " + e.getMessage());
                    }
                    break;

                case 4:
                    cart.checkout();
                    break;

                case 5:
                    exit = true;
                    System.out.println(" Thank you for shopping!");
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }

        sc.close();
    }
}
