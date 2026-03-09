import java.nio.charset.StandardCharsets;

public class PdfExporter extends Exporter {
    @Override
    protected ExportResult doExport(ExportRequest req) {
        if (req.body != null && req.body.length() > 20) {
            return failedResult("PDF cannot handle content > 20 chars");
        }
        String pdfContent = "PDF(" + req.title + "):" + req.body;
        return new ExportResult("application/pdf", pdfContent.getBytes(StandardCharsets.UTF_8));
    }
}
