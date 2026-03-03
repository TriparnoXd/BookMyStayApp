import java.util.Stack;
import java .util.LinkedList;
import java.util.Deque;
import java.util.ArrayDeque;
public class PalindromeCheckerApp {
    public static void main(String[] args){
        String input = "refer";

        // Create a Deque to store characters
        Deque<Character> deque = new ArrayDeque<>();

        // Add each character to the deque
        for (char c : input.toCharArray()) {
            deque.addLast(c);
        }

        // Flag to track palindrome result
        boolean isPalindrome = true;

        // Continue comparison while more than one element exists
        while (deque.size() > 1) {
            // Compare the first and last characters
            if (!deque.removeFirst().equals(deque.removeLast())) {
                isPalindrome = false;
                break;
            }
        }

        System.out.println("Input : " + input);
        System.out.println("Is Palindrome? : " + isPalindrome);

    }
}
