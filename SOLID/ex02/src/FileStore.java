import java.util.*;

public class FileStore implements InvoiceStore {
    private final Map<String, String> storage = new HashMap<>();

    public void save(String name, String content) {
        storage.put(name, content);
    }

    public int countLines(String name) {
        String data = storage.getOrDefault(name, "");
        return data.isEmpty() ? 0 : data.split("\n").length;
    }
}
