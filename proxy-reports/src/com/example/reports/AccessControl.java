package com.example.reports;

public class AccessControl {

    public boolean canAccess(User user, String cls) {
        String r = user.getRole();

        if ("PUBLIC".equals(cls)) return true;
        if ("FACULTY".equals(cls)) {
            return "FACULTY".equals(r) || "ADMIN".equals(r);
        }
        if ("ADMIN".equals(cls)) {
            return "ADMIN".equals(r);
        }
        return false;
    }
}
