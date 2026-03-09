import java.util.*;

public class HostelFeeCalculator {
    private final FakeBookingRepo bookingRepo;
    private final RoomPricing roomRate;
    private final AddOnPricing addOnRate;

    public HostelFeeCalculator(FakeBookingRepo bookingRepo, RoomPricing roomRate, AddOnPricing addOnRate) {
        this.bookingRepo = bookingRepo;
        this.roomRate = roomRate;
        this.addOnRate = addOnRate;
    }

    private Money calculateMonthly(BookingRequest req) {
        Money sum = roomRate.monthlyBase();
        for (AddOn addon : req.addOns) {
            sum = sum.plus(addOnRate.priceFor(addon));
        }
        return sum;
    }

    public void process(BookingRequest req) {
        Money monthlyFee = calculateMonthly(req);
        Money securityDeposit = new Money(5000.00);
        ReceiptPrinter.print(req, monthlyFee, securityDeposit);
        String refId = "H-" + (7000 + new Random(1).nextInt(1000));
        bookingRepo.save(refId, req, monthlyFee, securityDeposit);
    }
}
