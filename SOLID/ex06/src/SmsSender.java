public class SmsSender extends NotificationSender {
    public SmsSender(AuditLog log) { super(log); }

    @Override
    protected String doSend(Notification notification) {
        System.out.println("SMS -> to=" + notification.phone + " body=" + notification.body);
        log.add("sms sent");
        return null;
    }
}
