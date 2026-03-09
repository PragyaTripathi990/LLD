public class Projector implements SmartClassroomDevice, Powerable, InputConnectable {
    private boolean powered;

    public void connectInput(String source) { if (powered) System.out.println("Projector ON (" + source + ")"); }
    public void powerOff() { powered = false; System.out.println("Projector OFF"); }
    public void powerOn() { powered = true; }
}
