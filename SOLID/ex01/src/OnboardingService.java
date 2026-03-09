import java.util.*;

public class OnboardingService {
    private final InputParser inputParser;
    private final StudentValidator checker;
    private final OnboardingPrinter output;
    private final StudentStore store;

    public OnboardingService(StudentStore store, InputParser inputParser, StudentValidator checker, OnboardingPrinter output) {
        this.store = store;
        this.inputParser = inputParser;
        this.checker = checker;
        this.output = output;
    }

    public void registerFromRawInput(String raw) {
        output.printInput(raw);
        RawStudentData parsed = inputParser.parse(raw);
        List<String> validationErrors = checker.validate(parsed);
        if (!validationErrors.isEmpty()) {
            output.printErrors(validationErrors);
            return;
        }
        String studentId = IdUtil.nextStudentId(store.count());
        StudentRecord record = new StudentRecord(
                studentId, parsed.name, parsed.email, parsed.phone, parsed.program);
        store.save(record);
        output.printSuccess(studentId, store.count(), record);
    }
}
