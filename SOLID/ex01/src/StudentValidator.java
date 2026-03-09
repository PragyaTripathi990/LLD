import java.util.*;

public class StudentValidator {
    public List<String> validate(RawStudentData info) {
        List<String> issues = new ArrayList<>();
        boolean programValid = info.program.equals("CSE")
                || info.program.equals("AI")
                || info.program.equals("SWE");
        if (info.name.isBlank()) {
            issues.add("name is required");
        }
        if (info.email.isBlank() || !info.email.contains("@")) {
            issues.add("email is invalid");
        }
        if (info.phone.isBlank() || !info.phone.chars().allMatch(Character::isDigit)) {
            issues.add("phone is invalid");
        }
        if (!programValid) {
            issues.add("program is invalid");
        }
        return issues;
    }
}
