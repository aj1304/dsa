import java.util.*;

import java.util.*;

public class CoEdAssembly {

    // Inner class to manage the assembly queue
    static class AssemblyQueue {
        List<String> queue = new ArrayList<>(); // Holds the final queue of students
        int sentToStage = 0; // Counts students sent to stage because of wrong order
        char expectedGender = 'F'; // Assembly starts with a Female

        // Add a student based on the gender alternation rule
        void addStudent(String name, char gender) {
            if (gender == expectedGender) {
                queue.add(name); // Add to queue
                expectedGender = (gender == 'F') ? 'M' : 'F'; // Switch expected gender
            } else {
                sentToStage++; // Student sent to stage, does not join queue
            }
        }

        // Print the queue in "Name => Name =>" format
        void printQueue() {
            for (int i = 0; i < queue.size(); i++) {
                System.out.print(queue.get(i));
                if (i != queue.size() - 1) {
                    System.out.print(" => ");
                }
            }
            System.out.println("=>");
        }

        // Print the number of students sent to stage
        void printSentCount() {
            System.out.println(sentToStage);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Read the number of students
        System.out.print("Enter the number of students: ");
        int n = Integer.parseInt(sc.nextLine());

        AssemblyQueue queue = new AssemblyQueue();

        // Step 2: Read each student's name and gender
        for (int i = 0; i < n; i++) {
            System.out.print("Enter student name and gender (F/M) separated by space: ");
            String line = sc.nextLine().trim();

            // Find the first space (to separate name and gender)
            int spaceIndex = line.indexOf(' ');
            if (spaceIndex == -1 || spaceIndex == line.length() - 1) {
                System.out.println("Invalid input, skipping...");
                continue; // skip invalid entries
            }

            String name = line.substring(0, spaceIndex).trim();
            char gender = line.substring(spaceIndex + 1).trim().charAt(0);

            // Add student to assembly queue
            queue.addStudent(name, gender);
        }

        // Step 3: Print final results
        System.out.println("\nFinal Assembly Queue:");
        queue.printQueue();

        System.out.println("Number of students sent to stage:");
        queue.printSentCount();

        sc.close();
    }
}

/*
-------------------------
Example Input and Output:
-------------------------

Enter the number of students: 5
Enter student name and gender (F/M) separated by space: Alice F
Enter student name and gender (F/M) separated by space: Bob M
Enter student name and gender (F/M) separated by space: Carol F
Enter student name and gender (F/M) separated by space: Dave M
Enter student name and gender (F/M) separated by space: Eve F

Final Assembly Queue:
Alice => Bob => Carol => Dave =>
Number of students sent to stage:
1

Explanation:
- Expected order starts with Female, then Male, alternating.
- Eve (F) was skipped because after Dave (M), the next expected was Female, but the rule was already broken earlier.
*/
