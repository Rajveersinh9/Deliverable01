package card;

import java.util.Scanner;

public class InputHandler {
    private static final Scanner scanner = new Scanner(System.in);

    public static String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim().toUpperCase();
    }

    public static int getIntInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            System.out.print(prompt);
            scanner.next();
        }
        int input = scanner.nextInt();
        scanner.nextLine(); // consume the newline character
        return input;
    }
}
