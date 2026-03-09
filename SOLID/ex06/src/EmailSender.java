public class EmailSender extends NotificationSender {
    public EmailSender(AuditLog log) { super(log); }

    @Override
    protected String doSend(Notification notification) {
        String truncated = notification.body;
        if (truncated.length() > 40) truncated = truncated.substring(0, 40);
        System.out.println("EMAIL -> to=" + notification.email + " subject=" + notification.subject + " body=" + truncated);
        log.add("email sent");
        return null;
    }
}
