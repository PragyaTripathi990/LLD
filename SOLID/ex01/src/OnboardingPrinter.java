import java.util.*;

public class OnboardingPrinter {
    public void printSuccess(String studentId, int totalCount, StudentRecord record) {
        System.out.println("OK: created student " + studentId);
        System.out.println("Saved. Total students: " + totalCount);
        System.out.println("CONFIRMATION:");
        System.out.println(record);
    }

    public void printInput(String inputLine) {
        System.out.println("INPUT: " + inputLine);
    }

    public void printErrors(List<String> validationErrors) {
        System.out.println("ERROR: cannot register");
        validationErrors.forEach(msg -> System.out.println("- " + msg));
    }
}
