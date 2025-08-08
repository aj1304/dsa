import java.util.*;

public class FirstNonRepeatingChar {

    /**
     * Finds the first non-repeating character in a given string.
     * Uses a LinkedHashMap to preserve the order of insertion.
     *
     * @param str The input string
     * @return The first non-repeating character, or '\0' if none found
     */
    static char firstNonRepeatingChar(String str) {
        Map<Character, Integer> frequency = new LinkedHashMap<>();

        // Count frequency of each character
        for (char ch : str.toCharArray()) {
            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
        }

        // Find first character with frequency 1
        for (Map.Entry<Character, Integer> entry : frequency.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        // If none found, return null character
        return '\0';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Ask for user input
        System.out.print("Enter a string: ");
        String input = sc.nextLine().trim();

        // Get result
        char result = firstNonRepeatingChar(input);

        // Output result
        if (result != '\0') {
            System.out.println("First non-repeating character: " + result);
        } else {
            System.out.println("No non-repeating character found.");
        }

        sc.close();
    }
}

/*
-------------------------
Example Input and Output:
-------------------------

Enter a string: swiss
First non-repeating character: w

Explanation:
s → appears 3 times
w → appears 1 time → first non-repeating
i → appears 1 time, but comes after w
*/
