import java.nio.charset.StandardCharsets;

public class JsonExporter extends Exporter {
    private String sanitize(String s) {
        if (s == null) return "";
        return s.replace("\"", "\\\"");
    }

    @Override
    protected ExportResult doExport(ExportRequest req) {
        String payload = "{\"title\":\"" + sanitize(req.title) + "\",\"body\":\"" + sanitize(req.body) + "\"}";
        return new ExportResult("application/json", payload.getBytes(StandardCharsets.UTF_8));
    }
}
