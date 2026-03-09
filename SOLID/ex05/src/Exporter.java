public abstract class Exporter {
    protected ExportResult failedResult(String msg) {
        return new ExportResult("text/plain", ("ERROR: " + msg).getBytes());
    }

    protected abstract ExportResult doExport(ExportRequest req);

    public final ExportResult export(ExportRequest req) {
        if (req == null) return failedResult("request must not be null");
        return doExport(req);
    }
}
