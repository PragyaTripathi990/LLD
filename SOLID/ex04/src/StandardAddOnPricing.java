import java.util.*;

public class StandardAddOnPricing implements AddOnPricing {
    private static final Map<AddOn, Double> RATE_CARD = Map.of(
        AddOn.MESS, 500.0,
        AddOn.LAUNDRY, 500.0,
        AddOn.GYM, 300.0
    );

    public Money priceFor(AddOn item) {
        return new Money(RATE_CARD.getOrDefault(item, 0.0));
    }
}
