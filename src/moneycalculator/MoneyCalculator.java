
package moneycalculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;


public class MoneyCalculator {
        public static void main(String[] args) throws IOException {
        System.out.println("Introduce una cantidad de dolares: ");
        Scanner scanner = new Scanner(System.in);
        double amount = scanner.nextDouble();
        double exchangerate = getExchangeRate("USD","EUR");
        System.out.println(amount + " USD equivale a " + amount*exchangerate + " EUR");
    }

    private static double getExchangeRate(String from, String to) throws IOException {
        URL url = new URL("http://free.currencyconverterapi.com/api/v5/convert?q=" + from + "_" + to + "&compact=y");
        URLConnection connection = url.openConnection();
        
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line = reader.readLine();
            String line1 = line.substring(line.indexOf(":")+8, line.indexOf("}"));
            return Double.parseDouble(line1);
        }
    }
    
    
}

