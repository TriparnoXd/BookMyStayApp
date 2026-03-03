import java.util.Stack;
public class PalindromeCheckerApp {
    public static void main(String[] args){

        String input = "naan";
        Stack<Character> stack = new Stack<>();

        // 1. Push all characters of the string into the stack
        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        boolean isPalindrome = true;

        // 2. Pop from stack and compare with the original string characters
        for (int i = 0; i < input.length(); i++) {
            // stack.pop() gives the characters in reverse order
            if (input.charAt(i) != stack.pop()) {
                isPalindrome = false;
                break;
            }
        }

        System.out.println("Input: " + input);
        System.out.println("Is Palindrome? " + isPalindrome);



    }
}
