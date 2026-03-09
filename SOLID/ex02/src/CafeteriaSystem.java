import java.util.*;

public class CafeteriaSystem {
    private int invoiceSeq = 1000;
    private final Map<String, MenuItem> menu = new LinkedHashMap<>();
    private final TaxPolicy taxCalc;
    private final DiscountPolicy discCalc;
    private final InvoiceFormatter invoiceFmt;
    private final InvoiceStore persistence;

    public CafeteriaSystem(TaxPolicy taxCalc, DiscountPolicy discCalc, InvoiceFormatter invoiceFmt, InvoiceStore persistence) {
        this.taxCalc = taxCalc;
        this.discCalc = discCalc;
        this.invoiceFmt = invoiceFmt;
        this.persistence = persistence;
    }

    public void addToMenu(MenuItem item) {
        menu.put(item.id, item);
    }

    public void checkout(String customerType, List<OrderLine> lines) {
        String invoiceId = "INV-" + (++invoiceSeq);
        double subtotal = 0.0;
        for (int idx = 0; idx < lines.size(); idx++) {
            OrderLine current = lines.get(idx);
            subtotal += menu.get(current.itemId).price * current.qty;
        }
        double taxRate = taxCalc.taxPercent(customerType);
        double taxAmount = subtotal * (taxRate / 100.0);
        double discAmount = discCalc.discountAmount(customerType, subtotal, lines.size());
        double grandTotal = subtotal + taxAmount - discAmount;
        String receipt = invoiceFmt.format(invoiceId, lines, menu, subtotal, taxRate, taxAmount, discAmount, grandTotal);
        System.out.print(receipt);
        persistence.save(invoiceId, receipt);
        System.out.println("Saved invoice: " + invoiceId + " (lines=" + persistence.countLines(invoiceId) + ")");
    }
}
