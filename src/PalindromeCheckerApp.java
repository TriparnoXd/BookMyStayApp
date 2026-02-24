public class PalindromeCheckerApp {
    public static void main(String[] args){
        String input="madam";
        String reversed = ""; // String objects are immutable

        // Step 2: Reverse string using loop
        // Hint: Iterate from the last character to the first
        for (int i = input.length() - 1; i >= 0; i--) {
            // String Concatenation (+) to build the reversed string
            reversed = reversed + input.charAt(i);
        }

        // Step 3: Compare original and reversed using equals() method
        // We use .equals() to compare actual content instead of memory references
        if (input.equals(reversed)) {
            System.out.println("The string \"" + input + "\" is a palindrome.");
        } else {
            System.out.println("The string \"" + input + "\" is NOT a palindrome.");
        }


    }
}
