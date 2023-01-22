import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean shouldCont = true;
        ArrayList<Double> results = new ArrayList<Double>();

        // #1
        do {
            System.out.println("Welcome to the currency converter");

            int option;
            do {
                System.out.println("Please choose an option (1/2):");
                System.out.println("1. Dollars to Shekels");
                System.out.println("2. Shekels to Dollars");
                option = scanner.nextInt();
                if (option != 1 && option != 2) {
                    System.out.println("Invalid input.");
                }
            } while (option != 1 && option != 2);


            // #2
            System.out.println("“Please enter an amount to convert");
            double amountToConvert = scanner.nextDouble();

            if (option == 1) {
                Coin ilsInstance = CoinFactory.getCoinInstance(Coins.ILS);
                double result = ilsInstance.calculate(amountToConvert);
                results.add(result);
            } else if (option == 2) {
                Coin usdInstance = CoinFactory.getCoinInstance(Coins.USD);
                double result = usdInstance.calculate(amountToConvert);
                results.add(result);
            }

            String wishToCont;
            do {
                System.out.println("Do you want to continue? Y / N.");
                wishToCont = scanner.next();
                if (wishToCont.equalsIgnoreCase("y")) {
                    shouldCont = true;
                } else if (wishToCont.equalsIgnoreCase("n")) {
                    // don't want to continue
                    shouldCont = false;
                    System.out.println("Thanks for using our currency converter");
                    System.out.println(results);

                    // Open file for writing
                    try (PrintStream file = new PrintStream("filename.txt")) {
                        // Write "results" object to the file
                        file.println(results);
                    } catch (FileNotFoundException e) {
                        System.err.println("Could not create or open the file: " + e.getMessage());
                    }
                }

                if (!wishToCont.equalsIgnoreCase("y") && !wishToCont.equalsIgnoreCase("n")) {
                    System.out.println("Invalid input.");
                }
            } while (!wishToCont.equalsIgnoreCase("y") && !wishToCont.equalsIgnoreCase("n"));

        } while (shouldCont);
    }
}
