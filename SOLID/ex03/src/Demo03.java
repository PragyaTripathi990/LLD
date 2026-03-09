import java.util.*;

public class Demo03 {
    public static void main(String[] args) {
        System.out.println("=== Placement Eligibility ===");
        StudentProfile profile = new StudentProfile("23BCS1001", "Ayaan", 8.10, 72, 18, LegacyFlags.NONE);
        List<EligibilityRule> checks = List.of(
            new DisciplinaryFlagRule(),
            new CgrRule(),
            new AttendanceRule(),
            new CreditsRule()
        );
        EligibilityEngine evaluator = new EligibilityEngine(new FakeEligibilityStore(), checks);
        evaluator.runAndPrint(profile);
    }
}
