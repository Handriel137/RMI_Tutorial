package Client;

import Compute.Compute;

import java.math.BigDecimal;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {


    public static void main(String args[]) {
        int option;
        boolean running = true;

        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }

        Scanner scanner = new Scanner(System.in);

        try {
            String name = "Compute";
            Registry registry = LocateRegistry.getRegistry(args[0]);
            Compute comp = (Compute) registry.lookup(name);

            //Menu Structure
            while (running) {
                System.out.println("Please make a selection from the following items\n" +
                        "1.) Compute Pi\n" +
                        "2.) Compute Prime Numbers\n" +
                        "3.) Exit program\n");
                option = scanner.nextInt();


                switch (option) {
                    case 1:
                        System.out.print("Please enter the decimal places to compute Pi to\n");
                        int decimals = scanner.nextInt();
                        Pi piTask = new Pi(decimals);
                        BigDecimal pi = comp.executeTask(piTask);
                        System.out.println(pi);
                        break;

                    case 2:
                        System.out.println("Computing all prime numbers between maximum and minimum values\n" +
                                "Please select the minimum value:\n");
                        int min = scanner.nextInt();
                        System.out.println("Please select the maximum value for the range:\n");
                        int max = scanner.nextInt();

                        Prime primeTask = new Prime(min, max);

                        ArrayList<Integer> primesList = comp.executeTask(primeTask);
                        System.out.println(primesList);
                        break;

                    case 3:
                        running = false;
                        break;

                    default:
                        System.out.println("Invalid selection.");
                        break;
                }
            }
        } catch (Exception e) {
            System.err.println("Client exception:");
            e.printStackTrace();
        }

    }

}
