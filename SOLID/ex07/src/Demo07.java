public class Demo07 {
    public static void main(String[] args) {
        System.out.println("=== Smart Classroom ===");
        DeviceRegistry registry = new DeviceRegistry();
        registry.add(new Projector());
        registry.add(new LightsPanel());
        registry.add(new AirConditioner());
        registry.add(new AttendanceScanner());

        ClassroomController controller = new ClassroomController(registry);
        controller.startClass();
        controller.endClass();
    }
}
