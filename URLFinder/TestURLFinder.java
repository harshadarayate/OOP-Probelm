import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

class URLFinder {
    private String url;

    // Constructor
    public URLFinder(String url) {
        this.url = url;
    }

    // URL checker method
    public boolean urlChecker(String inputUrl) {
        // Regex for a basic valid URL
        String urlPattern = "^(https?://)?(www\\.)?[a-zA-Z0-9.-]+\\.[a-z]{2,}(/\\S*)?$";
        Pattern pattern = Pattern.compile(urlPattern);
        Matcher matcher = pattern.matcher(inputUrl);
        return matcher.matches();
    }
}

public class TestURLFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a URL to validate: ");
        String inputUrl = scanner.nextLine();

        URLFinder finder = new URLFinder(inputUrl);
        boolean isValid = finder.urlChecker(inputUrl);

        if (isValid) {
            System.out.println("The URL is Valid.");
        } else {
            System.out.println("The URL is Invalid.");
        }

        scanner.close();
    }
}

