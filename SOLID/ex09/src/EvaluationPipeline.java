public class EvaluationPipeline {
    private final PlagiarismCheckable plagChecker;
    private final Gradable codeGrader;
    private final ReportWritable reportGen;
    private final Rubric gradingRubric;

    public EvaluationPipeline(PlagiarismCheckable plagChecker, Gradable codeGrader, ReportWritable reportGen, Rubric gradingRubric) {
        this.plagChecker = plagChecker;
        this.codeGrader = codeGrader;
        this.reportGen = reportGen;
        this.gradingRubric = gradingRubric;
    }

    public void evaluate(Submission submission) {
        int plagScore = plagChecker.check(submission);
        System.out.println("PlagiarismScore=" + plagScore);
        int codeScore = codeGrader.grade(submission, gradingRubric);
        System.out.println("CodeScore=" + codeScore);
        String fileName = reportGen.write(submission, plagScore, codeScore);
        System.out.println("Report written: " + fileName);
        int combined = plagScore + codeScore;
        String verdict = (combined >= 90) ? "PASS" : "FAIL";
        System.out.println("FINAL: " + verdict + " (total=" + combined + ")");
    }
}
