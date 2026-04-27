import java.util.Arrays;

/**
 * =============================================================
 * MAIN CLASS - UseCase19TrainConsistMgmnt
 * =============================================================
 * * Use Case 19: Binary Search for Bogie ID
 * * Description:
 * This class demonstrates searching for a specific bogie ID
 * using the Binary Search algorithm on sorted data.
 * * At this stage, the application:
 * - Creates sorted bogie ID array
 * - Defines search key
 * - Applies binary search logic
 * - Narrows search range each iteration
 * - Displays result
 * * This maps optimized searching logic using divide-and-conquer.
 * * @author Developer
 * @version 19.0
 */

public class UseCase19TrainConsistMgmnt {

    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println(" UC19 - Binary Search for Bogie ID ");
        System.out.println("=============================================================\n");

        // 1. Create array of bogie IDs
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        // 2. Ensure data is sorted (Precondition for Binary Search)
        Arrays.sort(bogieIds);

        // 3. Search key
        String key = "BG309";

        // 4. Display available bogies
        System.out.println("Sorted Bogie IDs:");
        for (String id : bogieIds) {
            System.out.print(id + " ");
        }
        System.out.println("\n\nSearching for: " + key);

        // ---- BINARY SEARCH LOGIC ----
        int low = 0;
        int high = bogieIds.length - 1;
        int resultIndex = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Compare the middle element with the key
            int comparison = key.compareTo(bogieIds[mid]);

            if (comparison == 0) {
                resultIndex = mid; // Key found!
                break;
            } else if (comparison > 0) {
                low = mid + 1;    // Search in the right half
            } else {
                high = mid - 1;   // Search in the left half
            }
        }

        // 5. Display result
        if (resultIndex != -1) {
            System.out.println("Result: Bogie '" + key + "' found at index " + resultIndex + ".");
        } else {
            System.out.println("Result: Bogie '" + key + "' not found.");
        }
    }
}