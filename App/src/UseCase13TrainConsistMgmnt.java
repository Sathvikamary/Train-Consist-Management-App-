import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ==============================================================
 * MAIN CLASS - UseCase13TrainConsistMgmnt
 * ==============================================================
 * Use Case 13: Performance Comparison (Loops vs Streams)
 * * Description:
 * This class compares execution time of loop-based filtering
 * versus stream-based filtering using System.nanoTime().
 */
public class UseCase13TrainConsistMgmnt {

    // Bogie model
    static class Bogie {
        String type;
        int capacity;

        Bogie(String type, int capacity) {
            this.type = type;
            this.capacity = capacity;
        }
    }

    public static void main(String[] args) {
        System.out.println("================================================");
        System.out.println(" UC13 - Performance Comparison (Loops vs Streams) ");
        System.out.println("================================================\n");

        // ---- CREATE LARGE TEST DATASET ----
        List<Bogie> bogies = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            bogies.add(new Bogie("Sleeper", 72));
            bogies.add(new Bogie("AC Chair", 56));
        }
        System.out.println("Dataset initialized with " + bogies.size() + " bogies.");

        // ---- MEASURE LOOP EXECUTION TIME ----
        long loopStart = System.nanoTime();

        List<Bogie> loopFiltered = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.capacity > 60) {
                loopFiltered.add(b);
            }
        }

        long loopEnd = System.nanoTime();
        long loopDuration = loopEnd - loopStart;

        // ---- MEASURE STREAM EXECUTION TIME ----
        long streamStart = System.nanoTime();

        List<Bogie> streamFiltered = bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());

        long streamEnd = System.nanoTime();
        long streamDuration = streamEnd - streamStart;

        // ---- DISPLAY PERFORMANCE RESULTS ----
        System.out.println("\n--- Benchmark Results ---");
        System.out.println("Loop Execution Time   : " + loopDuration + " ns");
        System.out.println("Stream Execution Time : " + streamDuration + " ns");

        System.out.println("\n--- Analysis ---");
        if (loopDuration < streamDuration) {
            System.out.println("Result: For-loops were faster in this local test.");
        } else {
            System.out.println("Result: Streams were faster in this local test.");
        }

        System.out.println("Note: Streams often show higher overhead for small-to-medium datasets " +
                "but offer better readability and parallelization potential.");
    }
}