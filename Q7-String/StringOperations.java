import java.util.Scanner;

public class StringOperations {

    // 1. Check if a string is a palindrome
    public static boolean isPalindrome(String str) {
        String cleanStr = str.replaceAll("\\s+", "").toLowerCase();  // remove spaces, case-insensitive
        int left = 0, right = cleanStr.length() - 1;

        while (left < right) {
            if (cleanStr.charAt(left) != cleanStr.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    // 2. Count occurrences of a specific character
    public static int countCharacterOccurrences(String str, char ch) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (c == ch) {
                count++;
            }
        }
        return count;
    }

    // 3. Remove all whitespace from a string
    public static String removeWhitespace(String str) {
        return str.replaceAll("\\s+", "");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Palindrome check
        System.out.print("Enter a string to check for palindrome: ");
        String input = sc.nextLine();
        System.out.println(isPalindrome(input) ? "Palindrome" : "Not a palindrome");

        // Count character occurrences
        System.out.print("\nEnter a string: ");
        String str = sc.nextLine();
        System.out.print("Enter character to count: ");
        char ch = sc.next().charAt(0);
        int count = countCharacterOccurrences(str, ch);
        System.out.println("Occurrences of '" + ch + "': " + count);

        // Remove whitespace
        System.out.print("\nEnter a string with whitespaces: ");
        sc.nextLine(); // consume leftover newline
        String whiteSpaceStr = sc.nextLine();
        System.out.println("String without whitespace: \"" + removeWhitespace(whiteSpaceStr) + "\"");

        sc.close();
    }
}

