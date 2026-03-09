public class EventLeadTool implements EventTool {
    private final EventPlanner eventMgr;

    public EventLeadTool(EventPlanner eventMgr) { this.eventMgr = eventMgr; }

    public int getEventsCount() { return eventMgr.count(); }
    public void createEvent(String name, double budget) { eventMgr.create(name, budget); }
}
