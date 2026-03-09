public class Demo01 {
    public static void main(String[] args) {
        System.out.println("=== Student Onboarding ===");
        FakeDb store = new FakeDb();
        OnboardingService service = new OnboardingService(
                store, new InputParser(), new StudentValidator(), new OnboardingPrinter());
        String input = "name=Riya;email=riya@sst.edu;phone=9876543210;program=CSE";
        service.registerFromRawInput(input);
        System.out.println();
        System.out.println("-- DB DUMP --");
        System.out.print(TextTable.render3(store));
    }
}
