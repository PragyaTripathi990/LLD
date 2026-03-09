import com.example.tickets.IncidentTicket;
import com.example.tickets.TicketService;

import java.util.List;

public class TryIt {

    public static void main(String[] args) {
        TicketService svc = new TicketService();

        IncidentTicket original = svc.createTicket("TCK-1001", "reporter@example.com", "Payment failing on checkout");
        System.out.println("Created: " + original);

        IncidentTicket withAgent = svc.assign(original, "agent@example.com");
        IncidentTicket critical = svc.escalateToCritical(withAgent);
        System.out.println("\nAfter service updates (new object): " + critical);
        System.out.println("Original unchanged: " + original);

        List<String> tagList = critical.getTags();
        try {
            tagList.add("HACKED_FROM_OUTSIDE");
        } catch (UnsupportedOperationException e) {
            System.out.println("\nExternal tag mutation blocked: " + e.getClass().getSimpleName());
        }
        System.out.println("Tags still safe: " + critical.getTags());
    }
}
