public class TreasurerTool implements FinanceTool {
    private final BudgetLedger budget;

    public TreasurerTool(BudgetLedger budget) { this.budget = budget; }

    public void addIncome(double amount, String desc) { budget.add(amount, desc); }
    public void addExpense(double amount, String desc) { budget.add(-amount, desc); }
}
