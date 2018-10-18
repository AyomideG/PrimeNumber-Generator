import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {
        String fileName1 = "SieveOfEratosthenes.txt";
        String fileName2 = "SieveOfSundaram.txt";

        PrimeNumbers p = new PrimeNumbers();

        try {
            PrintWriter writer1 = new PrintWriter(fileName1);
            writeToFile1(writer1, p);
            writer1.flush();
            writer1.close();
            JOptionPane.showMessageDialog(null, "Receipt has been printed");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(0);
        }

        try {
            PrintWriter writer2 = new PrintWriter(fileName2);
            writeToFile2(writer2, p);
            writer2.flush();
            writer2.close();
            JOptionPane.showMessageDialog(null, "Receipt has been printed");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    public static void writeToFile1(PrintWriter writer, PrimeNumbers p) {
        int n = 500000;

        writer.println("Sieve Of Eratosthenes");
        writer.println("List of Prime Numbers");
        writer.println("Numbers less than or equal to " + n);
        long startTime = System.nanoTime();
        String value = p.sieveOfEratosthenes(n);
        long endTime = System.nanoTime();

        long duration = (endTime - startTime);
        double toSeconds = (double)duration / 1000000000.0;
        System.out.println("Sieve Of Eratosthenes took " + toSeconds + " seconds");
        writer.println("Sieve Of Sundaram took " + toSeconds + " seconds");
        writer.write(value);
    }

    public static void writeToFile2(PrintWriter writer, PrimeNumbers p){
        int n = 500000;

        writer.println("Sieve Of Sundaram");
        writer.println("List of Prime Numbers");
        writer.println("Numbers less than or equal to " + n);
        long startTime = System.nanoTime();
        String value = p.sieveOfSundaram(n);
        long endTime = System.nanoTime();

        long duration = (endTime - startTime);
        double toSeconds = (double)duration / 1000000000.0;
        System.out.println("Sieve Of Sundaram took " + toSeconds + " seconds");
        writer.println("Sieve Of Sundaram took " + toSeconds + " seconds");
        writer.write(value);
    }
}
