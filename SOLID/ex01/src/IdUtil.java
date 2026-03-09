public class IdUtil {
    public static String nextStudentId(int currentCount) {
        int sequence = currentCount + 1;
        String formatted = String.format("%04d", sequence);
        return "SST-2026-" + formatted;
    }
}
