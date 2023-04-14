package lab2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.NumberFormat;
import java.util.Scanner;

/**
 * Class Amortize
 * Calculates monthly payment given loan amount, interest, and years of loan
 *
 * @author Niko Culevski
 * @version 6.0.1
 * @see java.io.BufferedReader
 * @see java.io.InputStreamReader
 * @see javax.text.NumberFormat
 */
class Amortize {
    /**
     * Method main()
     * Calculates monthly payment. Relies on two member methods: inputDouble and payment
     *
     * @param args are the command line strings
     */
    public static void main(String args[]) {
        double loanAmount = 0, interest = 0, years = 0;

        // Create decimal format for currency
        NumberFormat moneyFormat = NumberFormat.getCurrencyInstance();

        // BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        // loanAmount = inputDouble ("Enter the loan amount in dollars > ", in);
        // interest = inputDouble ("Enter the interest rate in percent > ", in);
        // years = inputDouble ("Enter the number of years > ", in);

        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the loan amount in dollars > ");
        loanAmount = keyboard.nextDouble();
        System.out.print("Enter the interest rate in percent > ");
        interest = keyboard.nextDouble();
        System.out.print("Enter the number of years > ");
        years = keyboard.nextDouble();

        System.out.print("The payment is: ");
        System.out.println(moneyFormat.format(payment(loanAmount, interest, years)));
    }

    /**
     * Method inputDouble()
     * Prints a prompt and reads a double BufferedReader
     *
     * @param prompt String
     * @param in     BufferedReader
     * @return value double
     * @see java.io.BufferedReader
     */
    static double inputDouble(String prompt, BufferedReader in) {
        boolean error;
        String input = "";
        double value = 0;

        do {
            error = false;
            System.out.print(prompt);
            System.out.flush();

            try {
                input = in.readLine();
            } catch (IOException e) {
                System.out.println("An input error was caught");
                System.exit(1);
            }

            try {
                value = Double.valueOf(input).doubleValue();
            } catch (NumberFormatException e) {
                System.out.println("Please try again");
                error = true;
            }
        } while (error);

        return value;
    }

    /**
     * Method payment()
     * Does the magic calculation
     *
     * @param amount   double
     * @param interest double
     * @param years    double
     * @return double
     */
    static double payment(double amount, double interest, double years) {
        /*
         * call the exponentiation and natural log function (commented out)as static methods from the Math class
         */
        double top = amount * interest / 1200;
        // double bot = 1 - Math.exp (years*(-12) * Math.log (1 + interest/1200));
        double bot = 1 - Math.pow((1 + interest / 1200), years * (-12));
        return (top / bot);
    }
}
