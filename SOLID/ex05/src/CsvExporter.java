import java.nio.charset.StandardCharsets;

public class CsvExporter extends Exporter {
    @Override
    protected ExportResult doExport(ExportRequest req) {
        String sanitized = req.body == null ? "" : req.body.replace("\n", " ").replace(",", " ");
        String content = "title,body\n" + req.title + "," + sanitized + "\n";
        return new ExportResult("text/csv", content.getBytes(StandardCharsets.UTF_8));
    }
}
