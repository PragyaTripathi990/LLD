public class ClassroomController {
    private final DeviceRegistry devices;

    public ClassroomController(DeviceRegistry devices) { this.devices = devices; }

    public void endClass() {
        System.out.println("Shutdown sequence:");
        devices.getFirst(Projector.class).powerOff();
        devices.getFirst(LightsPanel.class).powerOff();
        devices.getFirst(AirConditioner.class).powerOff();
    }

    public void startClass() {
        Projector projector = devices.getFirst(Projector.class);
        projector.powerOn();
        projector.connectInput("HDMI-1");

        BrightnessControllable lightPanel = devices.getFirst(BrightnessControllable.class);
        lightPanel.setBrightness(60);

        TemperatureControllable airCon = devices.getFirst(TemperatureControllable.class);
        airCon.setTemperatureC(24);

        AttendanceScannable scanner = devices.getFirst(AttendanceScannable.class);
        System.out.println("Attendance scanned: present=" + scanner.scanAttendance());
    }
}
