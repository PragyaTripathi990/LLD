import java.util.Optional;

public class CgrRule implements EligibilityRule {
    public Optional<String> check(StudentProfile student) {
        if (student.cgr < 8.0) return Optional.of("CGR below 8.0");
        return Optional.empty();
    }
}
