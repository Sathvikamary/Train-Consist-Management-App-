import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ==============================================================
 * MAIN CLASS - UseCase8TrainConsistMgmnt
 * ==============================================================
 * Use Case 8: Filter Passenger Bogies Using Streams
 * * Description:
 * This class filters passenger bogies based on seating
 * capacity using Java Stream API.
 */
public class UseCase8TrainConsistMgmnt {

    // Reusing Bogie model from UC7
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
        System.out.println(" UC8 - Filter Passenger Bogies Using Streams ");
        System.out.println("================================================\n");

        // Create list of passenger bogies (same style as UC7)
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper-S1", 72));
        bogies.add(new Bogie("AC-3Tier-B1", 64));
        bogies.add(new Bogie("General-G1", 90));
        bogies.add(new Bogie("AC-2Tier-A1", 48));
        bogies.add(new Bogie("Sleeper-S2", 72));
        bogies.add(new Bogie("ChairCar-C1", 75));

        // Display all bogies before filtering
        System.out.println("All Bogies in System:");
        bogies.forEach(System.out::println);

        // Define a capacity threshold for filtering
        int capacityThreshold = 70;
        System.out.println("\n--- Filtering Bogies with Capacity > " + capacityThreshold + " ---");

        // Java Stream API Logic:
        // 1. Converts list into stream
        // 2. Applies filter condition
        // 3. Collects filtered result
        List<Bogie> highCapacityBogies = bogies.stream()
                .filter(b -> b.capacity > capacityThreshold)
                .collect(Collectors.toList());

        // Displays qualifying bogies
        if (highCapacityBogies.isEmpty()) {
            System.out.println("No bogies match the criteria.");
        } else {
            highCapacityBogies.forEach(System.out::println);
        }

        System.out.println("\nTotal qualifying bogies: " + highCapacityBogies.size());
    }
}