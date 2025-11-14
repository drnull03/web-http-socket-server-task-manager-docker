package task;

/**
 * TaskPalindrome checks whether the input string is a palindrome.
 * It ignores spaces, punctuation, and capitalization.
 */
public class TaskPalindrome extends TaskImpl {

    @Override
    public void execute() {
        if (input == null || input.trim().isEmpty()) {
            result = "No input provided.";
            return;
        }

        String cleaned = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String reversed = new StringBuilder(cleaned).reverse().toString();

        if (cleaned.equals(reversed)) {
            result = "\"" + input + "\" is a palindrome!";
        } else {
            result = "\"" + input + "\" is NOT a palindrome.";
        }
    }
}
