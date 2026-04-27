import java.util.ArrayList;
import java.util.List;

/**
 * MAIN CLASS - UseCase2TrainConsistMgmnt
 * Demonstrates dynamic management of passenger bogies using ArrayList.
 */
public class UseCase2TrainConsistMgmnt {

    public static void main(String[] args) {
        System.out.println("==============================================");
        System.out.println(" UC2 - Add Passenger Bogies to Train ");
        System.out.println("==============================================\n");

        // Create an ArrayList to hold passenger bogies
        List<String> passengerBogies = new ArrayList<>();

        // ---- CREATE (Add bogies) ----
        // add() attaches a new bogie to the train
        passengerBogies.add("General-1");
        passengerBogies.add("Sleeper-1");
        passengerBogies.add("Sleeper-2");
        passengerBogies.add("AC-3Tier-1");
        passengerBogies.add("AC-2Tier-1");
        System.out.println("Status: Initial bogies added.");

        // ---- READ (Check availability / Display) ----
        System.out.println("Current Consist: " + passengerBogies);
        System.out.println("Total Bogies: " + passengerBogies.size());

        // Check for specific bogie availability
        String searchBogie = "Sleeper-1";
        if (passengerBogies.contains(searchBogie)) {
            System.out.println("Check: " + searchBogie + " is present in the train.");
        }

        // ---- UPDATE (Replacing a bogie) ----
        // Example: Replacing Sleeper-2 with a Pantry Car
        if (passengerBogies.size() > 2) {
            passengerBogies.set(2, "Pantry-Car");
            System.out.println("Update: Bogie at index 2 replaced with Pantry-Car.");
        }

        // ---- DELETE (Remove bogies) ----
        // Removing a bogie by name
        passengerBogies.remove("General-1");
        System.out.println("Status: General-1 removed from the consist.");

        // ---- FINAL DISPLAY ----
        System.out.println("\n--- Final Train Consist ---");
        for (String bogie : passengerBogies) {
            System.out.println("| " + bogie + " |");
        }
        System.out.println("---------------------------");
    }
}