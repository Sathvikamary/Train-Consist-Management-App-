import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * ==============================================================
 * MAIN CLASS - UseCase11TrainConsistMgmnt
 * ==============================================================
 * Use Case 11: Validate Train ID and Cargo Code
 * * Description:
 * This class validates input formats using Regular Expressions.
 */
public class UseCase11TrainConsistMgmnt {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("================================================");
        System.out.println(" UC11 - Validate Train ID and Cargo Code ");
        System.out.println("================================================\n");

        // Accept input
        System.out.print("Enter Train ID (Format: TRN-1234): ");
        String trainId = scanner.nextLine();

        System.out.print("Enter Cargo Code (Format: PET-AB): ");
        String cargoCode = scanner.nextLine();

        // ---- DEFINE REGEX RULES ----

        /* * Train ID Regex: ^TRN-\\d{4}$
         * ^        : Start of string
         * TRN-     : Literal prefix
         * \\d{4}   : Exactly 4 digits
         * $        : End of string
         */
        String trainIdRegex = "^TRN-\\d{4}$";

        /* * Cargo Code Regex: ^[A-Z]{3}-[A-Z]{2}$
         * [A-Z]{3} : Exactly 3 uppercase letters
         * -        : Literal hyphen
         * [A-Z]{2} : Exactly 2 uppercase letters
         */
        String cargoCodeRegex = "^[A-Z]{3}-[A-Z]{2}$";

        // ---- APPLY REGEX VALIDATION ----
        boolean isTrainIdValid = Pattern.matches(trainIdRegex, trainId);
        boolean isCargoCodeValid = Pattern.matches(cargoCodeRegex, cargoCode);

        // Displays validation result
        System.out.println("\n--- Validation Results ---");

        if (isTrainIdValid) {
            System.out.println("Train ID [" + trainId + "]: VALID");
        } else {
            System.out.println("Train ID [" + trainId + "]: INVALID (Expected format: TRN-XXXX)");
        }

        if (isCargoCodeValid) {
            System.out.println("Cargo Code [" + cargoCode + "]: VALID");
        } else {
            System.out.println("Cargo Code [" + cargoCode + "]: INVALID (Expected format: AAA-BB)");
        }

        scanner.close();
    }
}