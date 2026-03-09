import java.util.*;

public class InputParser {
    public RawStudentData parse(String input) {
        Map<String, String> map = new LinkedHashMap<>();
        String[] tokens = input.split(";");
        for (int idx = 0; idx < tokens.length; idx++) {
            String[] pair = tokens[idx].split("=", 2);
            if (pair.length == 2) {
                map.put(pair[0].trim(), pair[1].trim());
            }
        }
        String studentName = map.getOrDefault("name", "");
        String studentEmail = map.getOrDefault("email", "");
        String studentPhone = map.getOrDefault("phone", "");
        String studentProgram = map.getOrDefault("program", "");
        return new RawStudentData(studentName, studentEmail, studentPhone, studentProgram);
    }
}
