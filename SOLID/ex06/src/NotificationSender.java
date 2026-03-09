public abstract class NotificationSender {
    protected final AuditLog log;
    protected NotificationSender(AuditLog log) { this.log = log; }

    protected abstract String doSend(Notification notification);

    public final String send(Notification notification) {
        if (notification == null) return "ERROR: notification must not be null";
        return doSend(notification);
    }
}
