import java.util.Arrays;
import java.util.Scanner;

public class AnagramCheck {

    /**
     * Function to check if two strings are anagrams.
     * Two strings are anagrams if they have the same characters in any order.
     */
    static boolean areAnagrams(String s1, String s2) {
        // If lengths differ, they can't be anagrams
        if (s1.length() != s2.length()) {
            return false;
        }

        // Convert both strings to char arrays
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();

        // Sort both arrays
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        // Compare sorted arrays
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false; // If any character differs, not an anagram
            }
        }

        return true; // All characters match
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking first string
        System.out.print("Enter the first string: ");
        String str1 = sc.nextLine().trim();

        // Taking second string
        System.out.print("Enter the second string: ");
        String str2 = sc.nextLine().trim();

        // Check and display result
        if (areAnagrams(str1, str2)) {
            System.out.println("Yes, they are anagrams.");
        } else {
            System.out.println("No, they are not anagrams.");
        }

        sc.close();
    }
}

/*
-------------------------
Example Input and Output:
-------------------------

Enter the first string: listen
Enter the second string: silent
Yes, they are anagrams.

Explanation:
"listen" and "silent" have the exact same letters, just rearranged.
Sorted form of both: "eilnst" → matches → anagrams.

Another Example:
Enter the first string: hello
Enter the second string: world
No, they are not anagrams.
*/
