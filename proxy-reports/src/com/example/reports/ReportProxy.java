package com.example.reports;

public class ReportProxy implements Report {

    private final String reportId;
    private final String title;
    private final String classification;
    private final AccessControl access = new AccessControl();

    private RealReport realReport = null;

    public ReportProxy(String reportId, String title, String classification) {
        this.reportId = reportId;
        this.title = title;
        this.classification = classification;
    }

    @Override
    public void display(User user) {
        if (!access.canAccess(user, classification)) {
            System.out.println("ACCESS DENIED: " + user.getName()
                    + " (" + user.getRole() + ") cannot access "
                    + classification + " report [" + reportId + "]");
            return;
        }

        if (realReport == null) {
            System.out.println("[proxy] first access - loading real report...");
            realReport = new RealReport(reportId, title, classification);
        } else {
            System.out.println("[proxy] using cached report");
        }

        realReport.display(user);
    }
}
