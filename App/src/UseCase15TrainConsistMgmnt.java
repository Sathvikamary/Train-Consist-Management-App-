/**
 * =============================================================
 * MAIN CLASS - UseCase15TrainConsistMgmnt
 * =============================================================
 * * Use Case 15: Safe Cargo Assignment Using try-catch-finally
 * * Description:
 * This class safely assigns cargo to goods bogies
 * while handling unsafe combinations using structured
 * exception handling blocks.
 */

public class UseCase15TrainConsistMgmnt {

    // ---- CUSTOM RUNTIME EXCEPTION ----
    static class CargoSafetyException extends RuntimeException {
        public CargoSafetyException(String message) {
            super(message);
        }
    }

    // Goods Bogie model
    static class GoodsBogie {
        String shape;
        String cargo;

        GoodsBogie(String shape) {
            this.shape = shape;
        }

        // Assign cargo with safety validation
        void assignCargo(String cargo) {
            try {
                System.out.println("Attempting to assign " + cargo + " to " + shape + " bogie...");

                // Rule: Rectangular bogie cannot carry petroleum
                if (this.shape.equalsIgnoreCase("Rectangular") && cargo.equalsIgnoreCase("Petroleum")) {
                    throw new CargoSafetyException("CRITICAL SAFETY VIOLATION: Petroleum cannot be carried in a Rectangular bogie!");
                }

                this.cargo = cargo;
                System.out.println("Success: Cargo '" + cargo + "' assigned.");

            } catch (CargoSafetyException e) {
                // Catches and handles the custom exception
                System.err.println("Handling Error: " + e.getMessage());
                this.cargo = "NONE (Safety Lock)";

            } finally {
                // Executes finally block for logging
                System.out.println("Log: Cargo assignment attempt completed for bogie type: " + shape);
                System.out.println("--------------------------------------------------");
            }
        }
    }

    public static void main(String[] args) {
        // Test Case 1: Safe Assignment
        GoodsBogie bogie1 = new GoodsBogie("Cylindrical");
        bogie1.assignCargo("Petroleum");

        // Test Case 2: Unsafe Assignment (Triggers Exception)
        GoodsBogie bogie2 = new GoodsBogie("Rectangular");
        bogie2.assignCargo("Petroleum");

        // Test Case 3: Safe Assignment
        GoodsBogie bogie3 = new GoodsBogie("Rectangular");
        bogie3.assignCargo("Coal");
    }
}