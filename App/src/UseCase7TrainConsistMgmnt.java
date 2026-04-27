import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * ==============================================================
 * MAIN CLASS - UseCase7TrainConsistMgmnt
 * ==============================================================
 * Use Case 7: Sort Bogies by Capacity (Comparator)
 * * Description:
 * This class sorts passenger bogies based on seating
 * capacity using a custom Comparator.
 */
public class UseCase7TrainConsistMgmnt {

    // Inner Bogie class to model passenger bogies
    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return String.format("[Bogie: %-12s | Capacity: %d]", name, capacity);
        }
    }

    public static void main(String[] args) {
        System.out.println("================================================");
        System.out.println(" UC7 - Sort Bogies by Capacity (Comparator) ");
        System.out.println("================================================\n");

        // Create list of passenger bogies
        List<Bogie> bogies = new ArrayList<>();

        // Adding bogie objects
        bogies.add(new Bogie("Sleeper-S1", 72));
        bogies.add(new Bogie("AC-3Tier-B1", 64));
        bogies.add(new Bogie("General-G1", 90));
        bogies.add(new Bogie("AC-2Tier-A1", 48));
        bogies.add(new Bogie("Sleeper-S2", 72));

        // Display unsorted data
        System.out.println("--- Unsorted Bogie List ---");
        for (Bogie b : bogies) {
            System.out.println(b);
        }

        // Sort using Comparator logic (Ascending order of capacity)
        Collections.sort(bogies, new Comparator<Bogie>() {
            @Override
            public int compare(Bogie b1, Bogie b2) {
                return Integer.compare(b1.capacity, b2.capacity);
            }
        });

        // Displays sorted result
        System.out.println("\n--- Sorted Bogie List (By Capacity) ---");
        for (Bogie b : bogies) {
            System.out.println(b);
        }
    }
}