package com.example.payments;

import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        Map<String, PaymentGateway> map = new HashMap<>();

        map.put("fastpay", new FastPayAdapter(new FastPayClient()));
        map.put("safecash", new SafeCashAdapter(new SafeCashClient()));

        OrderService svc = new OrderService(map);

        String out1 = svc.charge("fastpay", "cust-1", 1299);
        String out2 = svc.charge("safecash", "cust-2", 1299);

        System.out.println(out1);
        System.out.println(out2);
    }
}
