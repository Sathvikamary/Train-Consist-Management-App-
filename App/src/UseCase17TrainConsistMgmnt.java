import java.util.Arrays;

/**
 * =============================================================
 * MAIN CLASS - UseCase17TrainConsistMgmnt
 * =============================================================
 * * Use Case 17: Sort Bogie Names Using Arrays.sort()
 * * Description:
 * This class demonstrates sorting of bogie type names
 * alphabetically using Java's built-in Arrays.sort() method.
 * * At this stage, the application:
 * - Creates an array of bogie names
 * - Uses Arrays.sort() for sorting
 * - Displays sorted results
 * * This maps optimized sorting using Java library utilities.
 * * @author Developer
 * @version 17.0
 */

public class UseCase17TrainConsistMgmnt {

    public static void main(String[] args) {
        // 1. Creates an array of bogie names
        String[] bogieNames = {
                "Tanker",
                "Flatbed",
                "Boxcar",
                "Gondola",
                "Refrigerator",
                "Hopper"
        };

        System.out.println("Original Bogie Names: " + Arrays.toString(bogieNames));

        // 2. Uses Arrays.sort() for sorting
        // This sorts the array in-place in natural alphabetical order (A-Z)
        Arrays.sort(bogieNames);

        // 3. Displays sorted results
        System.out.println("Sorted Bogie Names (Alphabetical): " + Arrays.toString(bogieNames));

        // Optional: Iterating through the sorted list for cleaner output
        System.out.println("\n--- Sorted Inventory List ---");
        for (String name : bogieNames) {
            System.out.println("- " + name);
        }
    }
}