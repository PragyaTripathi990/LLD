package com.example.payments;

import java.util.Objects;

public class FastPayAdapter implements PaymentGateway {

    private final FastPayClient fpClient;

    public FastPayAdapter(FastPayClient fpClient) {
        this.fpClient = Objects.requireNonNull(fpClient, "fpClient");
    }

    @Override
    public String charge(String customerId, int amountCents) {
        Objects.requireNonNull(customerId, "customerId");
        return fpClient.payNow(customerId, amountCents);
    }
}
