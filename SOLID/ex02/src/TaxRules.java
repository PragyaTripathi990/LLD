public class TaxRules implements TaxPolicy {
    public double taxPercent(String type) {
        if ("student".equalsIgnoreCase(type)) {
            return 5.0;
        } else if ("staff".equalsIgnoreCase(type)) {
            return 2.0;
        }
        return 8.0;
    }
}
