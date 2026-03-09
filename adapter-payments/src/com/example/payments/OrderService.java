package com.example.payments;

import java.util.Map;
import java.util.Objects;

public class OrderService {
    private final Map<String, PaymentGateway> gatewayMap;

    public OrderService(Map<String, PaymentGateway> gatewayMap) {
        this.gatewayMap = Objects.requireNonNull(gatewayMap, "gatewayMap");
    }

    public String charge(String provider, String customerId, int amountCents) {
        Objects.requireNonNull(provider, "provider");
        PaymentGateway selected = gatewayMap.get(provider);
        if (selected == null) throw new IllegalArgumentException("unknown provider: " + provider);
        return selected.charge(customerId, amountCents);
    }
}
