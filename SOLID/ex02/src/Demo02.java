import java.util.*;

public class Demo02 {
    public static void main(String[] args) {
        System.out.println("=== Cafeteria Billing ===");
        CafeteriaSystem billing = new CafeteriaSystem(
                new TaxRules(), new DiscountRules(), new InvoiceFormatter(), new FileStore());
        billing.addToMenu(new MenuItem("M1", "Veg Thali", 80.00));
        billing.addToMenu(new MenuItem("C1", "Coffee", 30.00));
        billing.addToMenu(new MenuItem("S1", "Sandwich", 60.00));
        List<OrderLine> items = List.of(
                new OrderLine("M1", 2),
                new OrderLine("C1", 1));
        billing.checkout("student", items);
    }
}
