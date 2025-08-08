import java.util.Scanner;

public class FibonacciRecursion {

    /**
     * Recursive function to calculate the nth Fibonacci number.
     * Base cases:
     *   - If n = 0 → return 0
     *   - If n = 1 → return 1
     * Recursive case:
     *   F(n) = F(n-1) + F(n-2)
     */
    public static int fibonacci(int n) {
        if (n <= 1) return n; // Base case
        return fibonacci(n - 1) + fibonacci(n - 2); // Recursive case
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Ask for the number of terms
        System.out.print("Enter the number of terms in Fibonacci series: ");
        int n = sc.nextInt();

        // Validate input
        if (n <= 0) {
            System.out.println("Number of terms must be greater than 0.");
            sc.close();
            return;
        }

        // Print Fibonacci series
        System.out.println("Fibonacci Series:");
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacci(i) + " ");
        }

        sc.close();
    }
}

/*
-------------------------
Example Input and Output:
-------------------------

Enter the number of terms in Fibonacci series: 7
Fibonacci Series:
0 1 1 2 3 5 8

Explanation:
The sequence starts with 0, 1
Next terms are calculated by adding previous two:
0+1=1, 1+1=2, 1+2=3, 2+3=5, 3+5=8
*/
