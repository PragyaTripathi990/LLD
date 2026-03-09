public class Demo05 {
    private static String tryExport(Exporter exporter, ExportRequest request) {
        ExportResult result = exporter.export(request);
        String text = new String(result.bytes);
        if (text.startsWith("ERROR: ")) return text;
        return "OK bytes=" + result.bytes.length;
    }

    public static void main(String[] args) {
        System.out.println("=== Export Demo ===");

        ExportRequest req = new ExportRequest("Weekly Report", SampleData.longBody());
        Exporter pdfExp = new PdfExporter();
        Exporter csvExp = new CsvExporter();
        Exporter jsonExp = new JsonExporter();

        System.out.println("PDF: " + tryExport(pdfExp, req));
        System.out.println("CSV: " + tryExport(csvExp, req));
        System.out.println("JSON: " + tryExport(jsonExp, req));
    }
}
