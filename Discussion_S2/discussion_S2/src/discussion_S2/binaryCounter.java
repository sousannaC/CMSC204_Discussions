/*
 * Student name: Sousanna Chugunova
 * Class: CMSC204 (CRN 40439)
 * Instructor: Dr. Thai
 * Platform/compiler: Eclipse
 * 
 * I acknowledge that this is my own work, and does not include 
 * source code from the internet or from any other student.
 */

package discussion_S2;
import java.util.Scanner;
import java.util.Stack;

public class binaryCounter {

    // Method to analyze a binary string
    public static void analyzeBinaryString(String binaryString) {
        // Create a stack to store characters
        Stack<Character> stack = new Stack<>();

        // Push each character of the binary string onto the stack
        for (char ch : binaryString.toCharArray()) {
            stack.push(ch);
        }

        // Initialize counters for 0s and 1s
        int count0 = 0;
        int count1 = 0;

        // Pop characters from the stack and count 0s and 1s
        while (!stack.isEmpty()) {
            char ch = stack.pop();
            if (ch == '0') {
                count0++;
            } else if (ch == '1') {
                count1++;
            }
        }

        // Output the counts of 0s and 1s
        System.out.println("Total number of 0s: " + count0);
        System.out.println("Total number of 1s: " + count1);

        // Determine which value occurs more frequently and by how much
        if (count0 > count1) {
            System.out.println("0 occurs more frequently by " + (count0 - count1) + " times.");
        } else if (count1 > count0) {
            System.out.println("1 occurs more frequently by " + (count1 - count0) + " times.");
        } else {
            System.out.println("0 and 1 occur with equal frequency.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean tryAgain = true;

        while (tryAgain) {
            System.out.println("Enter a binary string (0s and 1s only):");
            String binaryString = scanner.nextLine();

            // Analyze the binary string
            analyzeBinaryString(binaryString);

            // Ask user if they want to try again
            System.out.println("Do you want to try again? (yes/no):");
            String choice = scanner.nextLine().trim().toLowerCase();
            if (!choice.equals("yes")) {
                tryAgain = false;
            }
        }

        // Say goodbye
        System.out.println("Goodbye!");
        scanner.close();
    }
}
