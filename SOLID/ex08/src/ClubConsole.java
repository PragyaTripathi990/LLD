public class ClubConsole {
    private final BudgetLedger budgetLedger;
    private final MinutesBook minutesBook;
    private final EventPlanner eventPlanner;

    public ClubConsole(BudgetLedger budgetLedger, MinutesBook minutesBook, EventPlanner eventPlanner) {
        this.budgetLedger = budgetLedger; this.minutesBook = minutesBook; this.eventPlanner = eventPlanner;
    }

    public void run() {
        FinanceTool finance = new TreasurerTool(budgetLedger);
        MinutesTool recorder = new SecretaryTool(minutesBook);
        EventTool eventLead = new EventLeadTool(eventPlanner);

        finance.addIncome(5000, "sponsor");
        recorder.addMinutes("Meeting at 5pm");
        eventLead.createEvent("HackNight", 2000);

        System.out.println("Summary: ledgerBalance=" + budgetLedger.balanceInt() + ", minutes=" + minutesBook.count() + ", events=" + eventLead.getEventsCount());
    }
}
