import java.util.Scanner;

class CaesarCipher {
    private String alphabet;
    private String shiftedAlphabet;
    private int mainKey;

    // Constructor
    public CaesarCipher(int key) {
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
        mainKey = key;
    }

    // Encrypt method
    public String encrypt(String input) {
        StringBuilder encrypted = new StringBuilder(input);
        for (int i = 0; i < input.length(); i++) {
            char currChar = input.charAt(i);
            boolean isLower = Character.isLowerCase(currChar);
            char upperChar = Character.toUpperCase(currChar);
            int idx = alphabet.indexOf(upperChar);
            if (idx != -1) {
                char newChar = shiftedAlphabet.charAt(idx);
                if (isLower) {
                    newChar = Character.toLowerCase(newChar);
                }
                encrypted.setCharAt(i, newChar);
            }
        }
        return encrypted.toString();
    }

    // Decrypt method
    public String decrypt(String input) {
        CaesarCipher cc = new CaesarCipher(26 - mainKey);
        return cc.encrypt(input);
    }
}

public class TestCaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string to encrypt: ");
        String input = scanner.nextLine();

        CaesarCipher cipher = new CaesarCipher(18);
        String encrypted = cipher.encrypt(input);
        System.out.println("Encrypted: " + encrypted);

        String decrypted = cipher.decrypt(encrypted);
        System.out.println("Decrypted: " + decrypted);

        scanner.close();
    }
}

