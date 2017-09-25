package Client;

import Compute.Task;

import java.util.ArrayList;

public class Prime implements Task<ArrayList<Integer>> {

    private int min;
    private int max;

    public Prime(int min, int max) {
        this.max = max;
        this.min = min;
    }

    public ArrayList<Integer> execute() {
        // loop through the numbers one by one
        ArrayList<Integer> primes = new ArrayList<>();

        for (int i = min; i < max; i++) {
            boolean isPrimeNumber = true;

            // check to see if the number is prime
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrimeNumber = false;
                    break; // exit the inner for loop
                }

            }

            if(isPrimeNumber){
                primes.add(i);
            }
        }

        return primes;
    }
}
