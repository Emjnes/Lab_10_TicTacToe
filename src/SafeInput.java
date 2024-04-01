import java.util.Scanner;

public class SafeInput {

    /**
     * Prompts the user to input a string that is not zero length.
     *
     * @param pipe    a Scanner opened to read from System.in
     * @param prompt  prompt for the user
     * @return a non-zero length string response
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retString = "";
        do {
            System.out.print("\n" + prompt + ": ");
            retString = pipe.nextLine();
        } while (retString.length() == 0);
        return retString;
    }

    /**
     * Prompts the user to input any integer and ensures valid input.
     *
     * @param pipe    a Scanner opened to read from System.in
     * @param prompt  prompt for the user
     * @return an integer inputted by the user
     */
    public static int getInt(Scanner pipe, String prompt) {
        int intValue = 0;
        boolean validInput = false;
        while (!validInput) {
            System.out.print(prompt + ": ");
            if (pipe.hasNextInt()) {
                intValue = pipe.nextInt();
                pipe.nextLine(); // Clear the newline character
                validInput = true;
            } else {
                String trash = pipe.nextLine(); // Read and discard the trash input
                System.out.println("Invalid input. Please enter an integer.");
            }
        }
        return intValue;
    }

    /**
     * Prompts the user to input any double value and ensures valid input.
     *
     * @param pipe    a Scanner opened to read from System.in
     * @param prompt  prompt for the user
     * @return a double value inputted by the user
     */
    public static double getDouble(Scanner pipe, String prompt) {
        double doubleValue = 0.0;
        boolean validInput = false;
        while (!validInput) {
            System.out.print(prompt + ": ");
            if (pipe.hasNextDouble()) {
                doubleValue = pipe.nextDouble();
                pipe.nextLine(); // Clear the newline character
                validInput = true;
            } else {
                String trash = pipe.nextLine(); // Read and discard the trash input
                System.out.println("Invalid input. Please enter a double.");
            }
        }
        return doubleValue;
    }

    /**
     * Prompts the user to input an integer within a specified inclusive range.
     *
     * @param pipe    a Scanner opened to read from System.in
     * @param prompt  prompt for the user
     * @param low     low value for the input range
     * @param high    high value for the input range
     * @return an integer within the specified range inputted by the user
     */
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int intValue;
        do {
            intValue = getInt(pipe, prompt + " [" + low + " - " + high + "]");
        } while (intValue < low || intValue > high);
        return intValue;
    }

    /**
     * Prompts the user to input a double value within a specified inclusive range.
     *
     * @param pipe    a Scanner opened to read from System.in
     * @param prompt  prompt for the user
     * @param low     low value for the input range
     * @param high    high value for the input range
     * @return a double value within the specified range inputted by the user
     */
    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        double doubleValue;
        do {
            doubleValue = getDouble(pipe, prompt + " [" + low + " - " + high + "]");
        } while (doubleValue < low || doubleValue > high);
        return doubleValue;
    }

    /**
     * Prompts the user to confirm with yes (Y) or no (N) and returns true for yes and false for no.
     *
     * @param pipe    a Scanner opened to read from System.in
     * @param prompt  prompt for the user
     * @return true if user confirms with yes, false if user confirms with no
     */
    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        String response;
        do {
            System.out.print(prompt + " [Y/N]: ");
            response = pipe.nextLine().toUpperCase();
        } while (!response.equals("Y") && !response.equals("N"));
        return response.equals("Y");
    }

    /**
     * Prompts the user to input a string that matches a given regex pattern.
     *
     * @param pipe    a Scanner opened to read from System.in
     * @param prompt  prompt for the user
     * @param regEx   the regex pattern to match
     * @return a string that matches the given regex pattern
     */
    public static String getRegExString(Scanner pipe, String prompt, String regEx) {
        String input;
        do {
            input = getNonZeroLenString(pipe, prompt);
        } while (!input.matches(regEx));
        return input;
    }

    /**
     * Creates a pretty header with the message centered.
     *
     * @param msg the message to be centered in the header
     */
    public static void prettyHeader(String msg) {
        int totalStars = 60;
        int msgLength = msg.length();
        int sideStars = (totalStars - msgLength - 6) / 2; // Subtracting 6 to account for the stars and spaces around the message

        // Print top row of stars
        for (int i = 0; i < totalStars; i++) {
            System.out.print("*");
        }
        System.out.println(); // Move to the next line

        // Print middle row with message centered
        System.out.print("***");
        for (int i = 0; i < sideStars; i++) {
            System.out.print(" ");
        }
        System.out.print(msg);
        for (int i = 0; i < sideStars; i++) {
            System.out.print(" ");
        }
        // Add an extra space if the total number of characters is odd
        if (msgLength % 2 != 0) {
            System.out.print(" ");
        }
        System.out.println("***");

        // Print bottom row of stars
        for (int i = 0; i < totalStars; i++) {
            System.out.print("*");
        }
        System.out.println(); // Move to the next line
    }
}


