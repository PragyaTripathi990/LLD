public class WhatsAppSender extends NotificationSender {
    public WhatsAppSender(AuditLog log) { super(log); }

    @Override
    protected String doSend(Notification notification) {
        if (notification.phone == null || !notification.phone.startsWith("+")) {
            log.add("WA failed");
            return "ERROR: phone must start with + and country code";
        }
        System.out.println("WA -> to=" + notification.phone + " body=" + notification.body);
        log.add("wa sent");
        return null;
    }
}
