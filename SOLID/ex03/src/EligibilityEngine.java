import java.util.*;

public class EligibilityEngine {
    private final FakeEligibilityStore repo;
    private final List<EligibilityRule> ruleSet;

    public EligibilityEngine(FakeEligibilityStore repo, List<EligibilityRule> ruleSet) {
        this.repo = repo;
        this.ruleSet = ruleSet;
    }

    public EligibilityEngineResult evaluate(StudentProfile s) {
        List<String> failReasons = new ArrayList<>();
        for (EligibilityRule rule : ruleSet) {
            Optional<String> check = rule.check(s);
            if (check.isPresent()) {
                failReasons.add(check.get());
                break;
            }
        }
        String status = failReasons.isEmpty() ? "ELIGIBLE" : "NOT_ELIGIBLE";
        return new EligibilityEngineResult(status, failReasons);
    }

    public void runAndPrint(StudentProfile s) {
        ReportPrinter printer = new ReportPrinter();
        EligibilityEngineResult outcome = evaluate(s);
        printer.print(s, outcome);
        repo.save(s.rollNo, outcome.status);
    }
}

class EligibilityEngineResult {
    public final String status;
    public final List<String> reasons;
    public EligibilityEngineResult(String status, List<String> reasons) {
        this.status = status;
        this.reasons = reasons;
    }
}
