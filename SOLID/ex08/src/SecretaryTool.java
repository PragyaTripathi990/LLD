public class SecretaryTool implements MinutesTool {
    private final MinutesBook minutes;

    public SecretaryTool(MinutesBook minutes) { this.minutes = minutes; }

    public void addMinutes(String content) { minutes.add(content); }
}
