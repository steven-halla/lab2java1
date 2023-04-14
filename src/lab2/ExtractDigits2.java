package lab2;

import javax.swing.JOptionPane;
/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* Class ExtractDigits
* File ExtractDigits.java
* Description Extract and display the four digits of a
* four-digit number. This program also demonstrates
* the use of args String array (although trivially)
* @author <i>Niko Culevski</i>
* Environment PC, Windows 10, jdk1.8.0_241, NetBeans 11.3
* Date 3/28/2020
* @version 1.8
* @see javax.swing.JOptionPane
* History Log Updated from 10/2/2001, 4/13/2005, 6/29/2007, 7/4/2012
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

public class ExtractDigits2 {
    /**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* Method main()
* Description Displays individual digits from a user provided 4
digits integer and accesses command-line arguments
* @param args are the command line strings
* @author <i>Niko Culevski</i>
* 
* * Date 3/28/2020
*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    public static void main(String[] args) {
        // Check for valid number of arguments at command prompt: 2
        if (args.length < 2) {
            System.out.println("usage: java ExtractDigits <month> <year>");
            System.exit(1);
        }
        // Convert entries stored in args into integers
        int month = Integer.valueOf(args[0]).intValue();
        int year = Integer.valueOf(args[1]).intValue();
        if (month < 1 || month > 12) { // Illegal month
            System.out.println("Month must be between 1 and 12");
            System.exit(1); // Not an elegant way to exit--use while instead
        }
        if (year < 1970) { // Illegal year—1970 is UNIX’s birth year
            System.out.println("Year must be greater than 1969");
            System.exit(1); // Not an elegant way to exit--use while instead
        }
        // Display inputs for month and year
        System.out.print("The month you entered is ");
        System.out.println(month);
        System.out.print("The year you entered is ");
        System.out.println(year);

        // Read a 4-digit number via a JOptionPane
        String input = JOptionPane.showInputDialog("Please enter a 4-digit number");
        String output = "";
        int number = Integer.parseInt(input);
        output += "The digits of " + number + " are ";

        output += number / 1000 + ", "; // Display thousand's digit
        number %= 1000;

        output += number / 100 + ", "; // Display hundred’s digit
        number %= 100;

        output += number / 10 + ", "; // Display ten's digit
        number %= 10;

        output += number + "."; // Display the unit's digit

        // Display output in a MessageDialog
        JOptionPane.showMessageDialog(null, output);
        System.exit(0);
    }
}
