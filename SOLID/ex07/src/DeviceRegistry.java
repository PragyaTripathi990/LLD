import java.util.*;

public class DeviceRegistry {
    private final List<SmartClassroomDevice> registry = new ArrayList<>();

    public void add(SmartClassroomDevice device) { registry.add(device); }

    @SuppressWarnings("unchecked")
    public <T> T getFirst(Class<T> type) {
        for (SmartClassroomDevice item : registry) {
            if (type.isInstance(item)) return (T) item;
        }
        throw new IllegalStateException("Missing: " + type.getSimpleName());
    }
}
