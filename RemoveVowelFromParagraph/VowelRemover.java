// Develop a Java program that takes a paragraph input from the user and:
//     • Remove all vowels (a, e, i, o, u) from the paragraph using StringBuilder.

//     • Efficiently update the paragraph after each deletion.

//     • Finally, display the transformed paragraph along with the count of characters removed.


import java.util.Scanner;

public class VowelRemover {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input paragraph
        System.out.println("Enter a paragraph:");
        String paragraph = scanner.nextLine();

        // StringBuilder for efficient character manipulation
        StringBuilder result = new StringBuilder();
        int vowelsRemoved = 0;

        // Traverse and remove vowels
        for (int i = 0; i < paragraph.length(); i++) {
            char ch = paragraph.charAt(i);
            if (isVowel(ch)) {
                vowelsRemoved++;
                // Do not append
            } else {
                result.append(ch);
            }
        }

        // Output results
        System.out.println("\nTransformed paragraph (vowels removed):");
        System.out.println(result.toString());
        System.out.println("\nTotal characters removed: " + vowelsRemoved);
    }

    // Helper method to check if a character is a vowel
    private static boolean isVowel(char ch) {
        return "aeiouAEIOU".indexOf(ch) != -1;
    }
}
