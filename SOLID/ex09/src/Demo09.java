public class Demo09 {
    public static void main(String[] args) {
        System.out.println("=== Evaluation Pipeline ===");
        Submission submission = new Submission("23BCS1007", "public class A{}", "A.java");
        EvaluationPipeline evaluator = new EvaluationPipeline(
            new PlagiarismChecker(), new CodeGrader(), new ReportWriter(), new Rubric());
        evaluator.evaluate(submission);
    }
}
