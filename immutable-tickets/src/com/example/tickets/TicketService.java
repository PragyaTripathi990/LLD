package com.example.tickets;

import java.util.ArrayList;
import java.util.List;

public class TicketService {

    public IncidentTicket createTicket(String id, String reporterEmail, String title) {
        List<String> initialTags = List.of("NEW");

        return new IncidentTicket.Builder(id, reporterEmail, title)
                .tags(initialTags)
                .customerVisible(false)
                .priority("MEDIUM")
                .source("CLI")
                .build();
    }

    public IncidentTicket assign(IncidentTicket ticket, String assigneeEmail) {
        return ticket.toBuilder()
                .assigneeEmail(assigneeEmail)
                .build();
    }

    public IncidentTicket escalateToCritical(IncidentTicket ticket) {
        List<String> updatedTags = new ArrayList<>(ticket.getTags());
        updatedTags.add("ESCALATED");

        return ticket.toBuilder()
                .tags(updatedTags)
                .priority("CRITICAL")
                .build();
    }
}
