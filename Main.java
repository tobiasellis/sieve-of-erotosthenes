// Author: Tobias Ellis
// Description: Simple java project designed to find all instances
//              of a prime number under a user defined constraint
//              using the "Sieve of Eratosthenes" algorithm.
//              consult README.md for more information.

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Get input from user
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter an integer value greater than 1 (N > 1): ");
        int inputVal = keyboard.nextInt();
        keyboard.close();

        //Get prime numbers and print to terminal
        sieve(inputVal);
    }

    public static void sieve(int limit){
        //Create boolean array, 0,1= false, rest of index up to n = true
        boolean[] range = new boolean[limit + 1];
        range[0] = false;
        range[1] = false;
        for(int a = 2; a < limit; a++){
            range[a] = true;
        }

        for(int i = 2; i*i<=limit; i++) { //for i = 2, 3, 4, ..., not exceeding √n:

            if(range[i]) { // if A[i] is true:
                for(int j = i*i; j <= limit; j+=i) { // for j = i2, i2+i, i2+2i, i2+3i, ..., not exceeding n:
                    range[j] = false;
                }
            }
        }
        //Print out all "unmarked" (range[x] = true, primes) to terminal
        System.out.print("Primes under " + limit + ": [ ");
        for(int k = 2; k <= limit; k++){
            if(range[k]){
                System.out.print(k + " ");
            }
        }
        System.out.print("]");
    }
}
