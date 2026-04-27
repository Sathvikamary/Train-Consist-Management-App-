/**
 * =============================================================
 * MAIN CLASS - UseCase20TrainConsistMgmnt
 * =============================================================
 * * Use Case 20: Exception Handling During Search Operations
 * * Description:
 * This class prevents searching when no bogies exist
 * by applying fail-fast validation using exceptions.
 * * At this stage, the application:
 * - Creates bogie collection
 * - Validates system state
 * - Throws exception if empty
 * - Stops invalid search operation
 * - Displays meaningful message
 * * This maps defensive programming using runtime exceptions.
 * * @author Developer
 * @version 20.0
 */

public class UseCase20TrainConsistMgmnt {

    public static void main(String[] args) {

        // 1. Create bogie array (empty train scenario to test validation)
        String[] bogieIds = {};

        // 2. Search key
        String searchId = "BG101";

        try {
            System.out.println("Initiating search for Bogie ID: " + searchId);

            // ---- FAIL-FAST VALIDATION ----
            // Check if train has bogies before performing search
            if (bogieIds.length == 0) {
                throw new IllegalStateException("SYSTEM ERROR: Cannot perform search on an empty train consist.");
            }

            // ---- SEARCH LOGIC (executes only if data exists) ----
            boolean found = false;
            for (String id : bogieIds) {
                if (id.equals(searchId)) {
                    found = true;
                    break;
                }
            }

            // 3. Display result
            if (found) {
                System.out.println("Result: Bogie " + searchId + " found.");
            } else {
                System.out.println("Result: Bogie " + searchId + " not found.");
            }

        } catch (IllegalStateException e) {
            // Handle the fail-fast exception
            System.err.println("Validation Failed: " + e.getMessage());
            System.out.println("Notice: Please populate the train consist before searching.");
        }

        System.out.println("\nUC20 execution completed...");
    }
}