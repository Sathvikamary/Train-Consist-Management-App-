import java.util.ArrayList;
import java.util.List;

/**
 * ==============================================================
 * MAIN CLASS - UseCase10TrainConsistMgmnt
 * ==============================================================
 * Use Case 10: Count Total Seats in Train
 * * Description:
 * This class aggregates seating capacity of all bogies
 * into a single total using Stream reduce().
 */
public class UseCase10TrainConsistMgmnt {

    // Reusing Bogie model from previous use cases
    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    public static void main(String[] args) {
        System.out.println("================================================");
        System.out.println(" UC10 - Count Total Seats in Train (Reduce) ");
        System.out.println("================================================\n");

        // Create list of bogies
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Sleeper", 70));

        // Display bogies
        System.out.println("Bogies in Train:");
        for (Bogie b : bogies) {
            System.out.println("- " + b.name + " (" + b.capacity + " seats)");
        }

        // ---- AGGREGATE USING REDUCE ----
        // 1. mapToInt() extracts the capacity field from Bogie object
        // 2. sum() (a specialized reduction) or reduce() aggregates the values
        int totalSeats = bogies.stream()
                .mapToInt(b -> b.capacity)
                .reduce(0, (sum, capacity) -> sum + capacity);

        // Displays total seat count
        System.out.println("\n------------------------------------------------");
        System.out.println("TOTAL SEATING CAPACITY: " + totalSeats);
        System.out.println("------------------------------------------------");
    }
}