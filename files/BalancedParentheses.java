import java.util.Scanner;
import java.util.Stack;

public class BalancedParentheses {

    /**
     * Function to check if the given string has balanced parentheses.
     * Balanced means every '(' has a matching ')'
     * and they are in the correct order.
     */
    static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // Push opening parenthesis to stack
            if (ch == '(') {
                stack.push(ch);
            }
            // For closing parenthesis
            else if (ch == ')') {
                if (stack.isEmpty()) {
                    return false; // Closing without matching opening
                }
                stack.pop(); // Match found, remove from stack
            }
            // You can extend here for other types: {}, []
        }

        // If stack is empty, all parentheses matched
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking input from user
        System.out.print("Enter a string with parentheses: ");
        String input = sc.nextLine();

        // Checking balance and printing result
        if (isBalanced(input)) {
            System.out.println("Balanced");
        } else {
            System.out.println("Not Balanced");
        }

        sc.close();
    }
}

/*
-------------------------
Example Input and Output:
-------------------------

Enter a string with parentheses: ((()))
Balanced

Explanation:
All '(' have matching ')' → Balanced.

Enter a string with parentheses: (()(
Not Balanced
Because there is an extra '(' without matching ')'.
*/
