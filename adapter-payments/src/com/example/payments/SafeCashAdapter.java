package com.example.payments;

import java.util.Objects;

public class SafeCashAdapter implements PaymentGateway {

    private final SafeCashClient scClient;

    public SafeCashAdapter(SafeCashClient scClient) {
        this.scClient = Objects.requireNonNull(scClient, "scClient");
    }

    @Override
    public String charge(String customerId, int amountCents) {
        Objects.requireNonNull(customerId, "customerId");
        SafeCashPayment result = scClient.createPayment(amountCents, customerId);
        return result.confirm();
    }
}
