package com.example.tickets;

import java.util.regex.Pattern;

public final class Validation {

    private static final Pattern EMAIL = Pattern.compile("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$");
    private static final Pattern TICKET_ID = Pattern.compile("^[A-Z0-9-]+$");

    private Validation() {}

    public static void requireNonBlank(String val, String field) {
        if (val == null || val.trim().isEmpty()) {
            throw new IllegalArgumentException(field + " must not be blank");
        }
    }

    public static void requireMaxLen(String val, int maxLen, String field) {
        if (val != null && val.length() > maxLen) {
            throw new IllegalArgumentException(field + " must be <= " + maxLen + " chars");
        }
    }

    public static void requireEmail(String addr, String field) {
        requireNonBlank(addr, field);
        if (!EMAIL.matcher(addr).matches()) {
            throw new IllegalArgumentException(field + " must be a valid email");
        }
    }

    public static void requireTicketId(String id) {
        requireNonBlank(id, "id");
        requireMaxLen(id, 20, "id");
        if (!TICKET_ID.matcher(id).matches()) {
            throw new IllegalArgumentException("id must match " + TICKET_ID.pattern());
        }
    }

    public static void requireRange(Integer val, int min, int max, String field) {
        if (val == null) return;
        if (val < min || val > max) {
            throw new IllegalArgumentException(field + " must be between " + min + " and " + max);
        }
    }

    public static void requireOneOf(String val, String field, String... allowed) {
        if (val == null) return;
        for (String a : allowed) {
            if (a.equals(val)) return;
        }
        throw new IllegalArgumentException(field + " must be one of: " + String.join(", ", allowed));
    }
}
