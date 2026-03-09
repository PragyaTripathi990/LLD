public class TextTable {
    public static String render3(FakeDb db) {
        StringBuilder buf = new StringBuilder();
        buf.append("| ID             | NAME | PROGRAM |\n");
        db.all().forEach(entry ->
                buf.append(String.format("| %-14s | %-4s | %-7s |\n", entry.id, entry.name, entry.program)));
        return buf.toString();
    }
}
