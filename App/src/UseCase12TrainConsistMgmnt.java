import java.util.ArrayList;
import java.util.List;

/**
 * ==============================================================
 * MAIN CLASS - UseCase12TrainConsistMgmnt
 * ==============================================================
 * Use Case 12: Safety Compliance Check for Goods Bogies
 * * Description:
 * This class enforces domain safety rules on goods bogies.
 */
public class UseCase12TrainConsistMgmnt {

    // Goods Bogie model
    static class GoodsBogie {
        String type;
        String cargo;

        GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }

        @Override
        public String toString() {
            return String.format("[Type: %-10s | Cargo: %-10s]", type, cargo);
        }
    }

    public static void main(String[] args) {
        System.out.println("================================================");
        System.out.println(" UC12 - Safety Compliance Check for Goods Bogies ");
        System.out.println("================================================\n");

        // Create goods bogie list
        List<GoodsBogie> goodsBogies = new ArrayList<>();
        goodsBogies.add(new GoodsBogie("Tanker", "Petroleum"));
        goodsBogies.add(new GoodsBogie("Flatcar", "Steel"));
        goodsBogies.add(new GoodsBogie("Hopper", "Coal"));
        goodsBogies.add(new GoodsBogie("Tanker", "Petroleum"));

        // Display current goods bogies
        System.out.println("Goods Bogies to Audit:");
        goodsBogies.forEach(System.out::println);

        // ---- APPLY SAFETY VALIDATION RULE ----
        // Rule: All 'Tanker' type bogies MUST carry 'Petroleum' for this specific route.
        // We use allMatch() to check if EVERY bogie in the stream meets the condition.

        boolean isSafe = goodsBogies.stream()
                .allMatch(b -> {
                    if (b.type.equals("Tanker")) {
                        return b.cargo.equals("Petroleum");
                    }
                    return true; // Non-tankers are compliant by default in this rule
                });

        // Displays safety status
        System.out.println("\n--- Safety Compliance Audit Result ---");
        if (isSafe) {
            System.out.println("STATUS: COMPLIANT");
            System.out.println("Result: All goods bogies meet the safety standards.");
        } else {
            System.out.println("STATUS: NON-COMPLIANT");
            System.out.println("Result: Safety violation detected! Check cargo assignments.");
        }
    }
}