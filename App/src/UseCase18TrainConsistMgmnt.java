/**
 * =============================================================
 * MAIN CLASS - UseCase18TrainConsistMgmnt
 * =============================================================
 * * Use Case 18: Linear Search for Bogie ID
 * * Description:
 * This class demonstrates searching for a specific bogie ID
 * using a simple Linear Search algorithm.
 * * At this stage, the application:
 * - Creates an array of bogie IDs
 * - Accepts a search key
 * - Traverses array sequentially
 * - Stops when match is found
 * - Displays search result
 * * This maps basic searching logic using sequential traversal.
 * * @author Developer
 * @version 18.0
 */

public class UseCase18TrainConsistMgmnt {

    public static void main(String[] args) {

        // 1. Create array of bogie IDs
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        // 2. Bogie ID to search (Search Key)
        String searchId = "BG309";

        // 3. Display all bogies
        System.out.println("Available Bogie IDs:");
        for (String id : bogieIds) {
            System.out.print(id + " ");
        }
        System.out.println("\n\nSearching for: " + searchId);

        // ---- LINEAR SEARCH LOGIC ----
        // Traverse each element sequentially
        boolean found = false;

        for (String id : bogieIds) {
            // Compare current element with search key
            if (id.equals(searchId)) {
                found = true;
                break; // Stop the loop once the match is found
            }
        }

        // 4. Display result
        if (found) {
            System.out.println("Result: Bogie " + searchId + " was found in the system.");
        } else {
            System.out.println("Result: Bogie " + searchId + " was NOT found.");
        }
    }
}