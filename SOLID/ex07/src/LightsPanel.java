public class LightsPanel implements SmartClassroomDevice, Powerable, BrightnessControllable {
    public void setBrightness(int level) { System.out.println("Lights set to " + level + "%"); }
    public void powerOff() { System.out.println("Lights OFF"); }
    public void powerOn() {}
}
