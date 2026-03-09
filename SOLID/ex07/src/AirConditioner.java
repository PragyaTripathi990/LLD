public class AirConditioner implements SmartClassroomDevice, Powerable, TemperatureControllable {
    public void setTemperatureC(int degrees) { System.out.println("AC set to " + degrees + "C"); }
    public void powerOff() { System.out.println("AC OFF"); }
    public void powerOn() {}
}
