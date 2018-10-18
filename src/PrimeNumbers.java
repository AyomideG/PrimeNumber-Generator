import java.util.Arrays;
import java.util.BitSet;

public class PrimeNumbers {

    public String sieveOfEratosthenes(int n) {
        BitSet prime = new BitSet(n + 1);
        String value = "";

        for (int i = 2; i < n; i++) {
            prime.set(i, true);
        }
        for (int p = 2; p * p <= n; p++) {
            if (prime.get(p)) {
                for (int i = p; p * i <= n; i++) {
                    prime.set(p * i, false);
                }
            }
        }
        int c = 0;
        for (int i = 2; i <= n; i++) {
            if (prime.get(i)) {

                if (c == 10) {
                    value += i + "\n";
                    c = 0;
                } else {
                    value += i + " ";
                    ++c;
                }
//                System.out.print(i + " ");
            }
        }
        return value;
    }

    public String sieveOfSundaram(int n) {
        int nNew = (n - 2) / 2;
        boolean prime[] = new boolean[nNew + 1];
        Arrays.fill(prime, false);
        String value = "";

        for (int i = 1; i < nNew; i++) {
            for (int j = 1; (i + j + 2 * i * j) <= nNew; j++) {
                prime[i + j + 2 * i * j] = true;
            }
        }
        if (n > 2) {
            value += 2 + " ";
        }
        int c = 0;
        for (int i = 1; i <= nNew; i++) {
            if (prime[i] == false) {

                if (c == 10) {
                    value += 2 * i + 1 + "\n";
                    c = 0;
                } else {
                    value += 2 * i + 1 + " ";
                    ++c;
                }
//                System.out.print(i + " ");
            }
        }
        return value;
    }
}
