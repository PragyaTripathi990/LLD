import java.util.*;

public class Demo04 {
    public static void main(String[] args) {
        System.out.println("=== Hostel Fee Calculator ===");
        BookingRequest booking = new BookingRequest(LegacyRoomTypes.DOUBLE, List.of(AddOn.LAUNDRY, AddOn.MESS));
        HostelFeeCalculator feeCalc = new HostelFeeCalculator(new FakeBookingRepo(), new DoubleRoomPricing(), new StandardAddOnPricing());
        feeCalc.process(booking);
    }
}
