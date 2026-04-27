/**
 * ==============================================================
 * MAIN CLASS - UseCase14TrainConsistMgmnt
 * ==============================================================
 * Use Case 14: Handle Invalid Bogie Capacity (Custom Exception)
 * * Description:
 * This class prevents creation of passenger bogies
 * with invalid seating capacity using a custom exception.
 */
public class UseCase14TrainConsistMgmnt {

    // ---- CUSTOM EXCEPTION ----
    // Extends Exception to create a checked exception for business logic
    static class InvalidCapacityException extends Exception {
        public InvalidCapacityException(String message) {
            super(message);
        }
    }

    // Passenger Bogie model with validation
    static class PassengerBogie {
        String type;
        int capacity;

        // Constructor throws exception if capacity is invalid (<= 0)
        PassengerBogie(String type, int capacity) throws InvalidCapacityException {
            if (capacity <= 0) {
                throw new InvalidCapacityException("Invalid Capacity: " + capacity +
                        ". Capacity must be greater than 0.");
            }
            this.type = type;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return "Bogie [Type=" + type + ", Capacity=" + capacity + "]";
        }
    }

    public static void main(String[] args) {
        System.out.println("================================================");
        System.out.println(" UC14 - Custom Exception Handling ");
        System.out.println("================================================\n");

        // Test Case 1: Valid Capacity
        try {
            System.out.println("Attempting to create valid bogie...");
            PassengerBogie bogie1 = new PassengerBogie("Sleeper", 72);
            System.out.println("Success: " + bogie1);
        } catch (InvalidCapacityException e) {
            System.err.println("Error: " + e.getMessage());
        }

        System.out.println();

        // Test Case 2: Invalid Capacity (Zero or Negative)
        try {
            System.out.println("Attempting to create invalid bogie (Capacity: -5)...");
            PassengerBogie bogie2 = new PassengerBogie("General", -5);
            System.out.println("Success: " + bogie2);
        } catch (InvalidCapacityException e) {
            // This block catches the custom exception and prevents application crash
            System.out.println("CAUGHT EXPECTED ERROR: " + e.getMessage());
            System.out.println("Status: Prevented creation of invalid bogie.");
        }

        System.out.println("\nExecution continues safely...");
    }
}