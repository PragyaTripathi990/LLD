import java.util.Optional;

public class AttendanceRule implements EligibilityRule {
    public Optional<String> check(StudentProfile prof) {
        if (prof.attendancePct < 75) return Optional.of("attendance below 75");
        return Optional.empty();
    }
}
