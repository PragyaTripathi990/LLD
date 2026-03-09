import java.util.*;

public class FakeDb implements StudentStore {
    private final List<StudentRecord> records = new ArrayList<>();

    public List<StudentRecord> all() {
        return Collections.unmodifiableList(records);
    }

    public void save(StudentRecord entry) {
        records.add(entry);
    }

    public int count() {
        return records.size();
    }
}
