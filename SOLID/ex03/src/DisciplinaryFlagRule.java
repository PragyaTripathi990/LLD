import java.util.Optional;

public class DisciplinaryFlagRule implements EligibilityRule {
    public Optional<String> check(StudentProfile profile) {
        return (profile.disciplinaryFlag != LegacyFlags.NONE)
            ? Optional.of("disciplinary flag present")
            : Optional.empty();
    }
}
