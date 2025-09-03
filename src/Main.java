import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create a scanner to read from the command line.
        Scanner input = new Scanner(System.in);

        // Ask for the number of coffees/teas/pastries.
        System.out.println("Number of coffees: ");
        int numberOfCoffees = input.nextInt();

        System.out.println("Number of teas: ");
        int numberOfTeas = input.nextInt();

        System.out.println("Number of pastries: ");
        int numberOfPastries = input.nextInt();

        // Print out the amounts chosen by the user.
        System.out.println("Coffees: " + numberOfCoffees);
        System.out.println("Teas: " + numberOfTeas);
        System.out.println("Pastries: " + numberOfPastries);

        // Set prices for future calculations.
        double coffeePrice = 2.10d;
        double teaPrice = 1.60d;
        double pastryPrice = 2.75d;

        // VAT value and service fee values
        double vat = 0.21d;
        double serviceFee = 0.30d;

        // Compute the subtotal keeping in mind the VAT and service fee
        double subTotal = (coffeePrice * numberOfCoffees)
                + (teaPrice * numberOfTeas)
                + (pastryPrice * numberOfPastries);

        subTotal = subTotal + (subTotal * vat);
        subTotal = subTotal + (subTotal * serviceFee);
        System.out.printf("Subtotal: %.2f%n", subTotal);

        // Clear the newline left after using nextInt()
        input.nextLine();

        // Ask for discount code
        System.out.println("Enter discount code (if any): ");
        String discountCode = input.nextLine();

        // Apply discount if the code is valid
        if (discountCode.equalsIgnoreCase("STUDENT10")) {
            subTotal = subTotal * 0.90;
            System.out.printf("Discount applied: 10%%. New total: %.2f%n", subTotal);
        } else if (!discountCode.isEmpty()) {
            System.out.println("Invalid discount code.");
        }

        // Ask for payment method
        System.out.println("Will you pay by card or cash?");
        String paymentMethod = input.nextLine();

        // Handle payment based on the method chosen
        if (paymentMethod.equalsIgnoreCase("card")) {
            System.out.printf("Payment of %.2f accepted by card. Thank you!%n", subTotal);
        } else if (paymentMethod.equalsIgnoreCase("cash")) {
            System.out.println("Enter amount given: ");
            double amountGiven = input.nextDouble();

            // What to do if the amount given is less or more than the subtotal
            if (amountGiven < subTotal) {
                double stillDue = subTotal - amountGiven;
                System.out.printf("Insufficient cash. You still owe: %.2f%n", stillDue);
            } else {
                double change = amountGiven - subTotal;
                System.out.printf("Payment accepted. Change due: %.2f%n", change);
            }
        } else {
            System.out.println("Invalid payment method. Please choose 'card' or 'cash'.");
        }

        // Close scanner at the very end and then another thing
        input.close();
    }
}