public class Demo06 {
    public static void main(String[] args) {
        System.out.println("=== Notification Demo ===");
        AuditLog auditLog = new AuditLog();

        Notification msg = new Notification("Welcome", "Hello and welcome to SST!", "riya@sst.edu", "9876543210");

        NotificationSender emailSender = new EmailSender(auditLog);
        NotificationSender smsSender = new SmsSender(auditLog);
        NotificationSender waSender = new WhatsAppSender(auditLog);

        emailSender.send(msg);
        smsSender.send(msg);
        String waOutcome = waSender.send(msg);
        if (waOutcome != null) System.out.println("WA " + waOutcome);

        System.out.println("AUDIT entries=" + auditLog.size());
    }
}
