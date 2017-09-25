package Client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

import Compute.Compute;

public class ComputePrimes {
    public static void main(String args[]) {
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
        try {
            String name = "Compute";
            Registry registry = LocateRegistry.getRegistry(args[0]);
            Compute comp = (Compute) registry.lookup(name);


            Prime task = new Prime(Integer.parseInt(args[1]),Integer.parseInt(args[2]));
            ArrayList<Integer> primeslist = comp.executeTask(task);
            System.out.println(primeslist);
        } catch (Exception e) {
            System.err.println("ComputePi exception:");
            e.printStackTrace();
        }
    }
}