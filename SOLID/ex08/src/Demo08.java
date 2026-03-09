public class Demo08 {
    public static void main(String[] args) {
        System.out.println("=== Club Admin ===");
        BudgetLedger budget = new BudgetLedger();
        MinutesBook records = new MinutesBook();
        EventPlanner planner = new EventPlanner();

        ClubConsole app = new ClubConsole(budget, records, planner);
        app.run();
    }
}
