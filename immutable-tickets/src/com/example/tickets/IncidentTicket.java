package com.example.tickets;

import java.util.ArrayList;
import java.util.List;

public final class IncidentTicket {

    private final String source;
    private final String priority;
    private final String id;
    private final String assigneeEmail;
    private final String title;
    private final List<String> tags;
    private final String reporterEmail;
    private final String description;
    private final Integer slaMinutes;
    private final boolean customerVisible;

    private IncidentTicket(Builder b) {
        this.id = b.id;
        this.reporterEmail = b.reporterEmail;
        this.title = b.title;
        this.description = b.description;
        this.priority = b.priority;
        this.tags = List.copyOf(b.tags);
        this.assigneeEmail = b.assigneeEmail;
        this.customerVisible = b.customerVisible;
        this.slaMinutes = b.slaMinutes;
        this.source = b.source;
    }

    public String getSource() { return source; }
    public String getAssigneeEmail() { return assigneeEmail; }
    public String getId() { return id; }
    public String getTitle() { return title; }
    public boolean isCustomerVisible() { return customerVisible; }
    public String getPriority() { return priority; }
    public String getReporterEmail() { return reporterEmail; }
    public List<String> getTags() { return tags; }
    public Integer getSlaMinutes() { return slaMinutes; }
    public String getDescription() { return description; }

    @Override
    public String toString() {
        return "IncidentTicket{" +
                "id='" + id + '\'' +
                ", reporterEmail='" + reporterEmail + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", priority='" + priority + '\'' +
                ", tags=" + tags +
                ", assigneeEmail='" + assigneeEmail + '\'' +
                ", customerVisible=" + customerVisible +
                ", slaMinutes=" + slaMinutes +
                ", source='" + source + '\'' +
                '}';
    }

    public Builder toBuilder() {
        Builder copy = new Builder(this.id, this.reporterEmail, this.title);
        copy.description = this.description;
        copy.priority = this.priority;
        copy.tags = new ArrayList<>(this.tags);
        copy.assigneeEmail = this.assigneeEmail;
        copy.customerVisible = this.customerVisible;
        copy.slaMinutes = this.slaMinutes;
        copy.source = this.source;
        return copy;
    }

    public static class Builder {
        private final String id;
        private final String reporterEmail;
        private final String title;

        private String source;
        private String assigneeEmail;
        private String priority;
        private Integer slaMinutes;
        private List<String> tags = new ArrayList<>();
        private boolean customerVisible;
        private String description;

        public Builder(String id, String reporterEmail, String title) {
            this.id = id;
            this.reporterEmail = reporterEmail;
            this.title = title;
        }

        public Builder source(String source) { this.source = source; return this; }
        public Builder assigneeEmail(String assigneeEmail) { this.assigneeEmail = assigneeEmail; return this; }
        public Builder tags(List<String> tags) { this.tags = new ArrayList<>(tags); return this; }
        public Builder priority(String priority) { this.priority = priority; return this; }
        public Builder slaMinutes(Integer slaMinutes) { this.slaMinutes = slaMinutes; return this; }
        public Builder customerVisible(boolean customerVisible) { this.customerVisible = customerVisible; return this; }
        public Builder description(String description) { this.description = description; return this; }

        public IncidentTicket build() {
            Validation.requireTicketId(id);
            Validation.requireEmail(reporterEmail, "reporterEmail");
            Validation.requireNonBlank(title, "title");
            Validation.requireMaxLen(title, 80, "title");
            Validation.requireOneOf(priority, "priority", "LOW", "MEDIUM", "HIGH", "CRITICAL");
            if (assigneeEmail != null) {
                Validation.requireEmail(assigneeEmail, "assigneeEmail");
            }
            Validation.requireRange(slaMinutes, 5, 7200, "slaMinutes");
            return new IncidentTicket(this);
        }
    }
}
