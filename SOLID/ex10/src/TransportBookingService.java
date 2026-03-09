public class TransportBookingService {
    private final DistanceMeasurable distCalc;
    private final DriverAllocatable driverAlloc;
    private final PaymentChargeable payment;

    public TransportBookingService(DistanceMeasurable distCalc, DriverAllocatable driverAlloc, PaymentChargeable payment) {
        this.distCalc = distCalc;
        this.driverAlloc = driverAlloc;
        this.payment = payment;
    }

    public void book(TripRequest trip) {
        double distance = distCalc.km(trip.from, trip.to);
        System.out.println("DistanceKm=" + distance);
        String driverId = driverAlloc.allocate(trip.studentId);
        System.out.println("Driver=" + driverId);
        double tripFare = 50.0 + distance * 6.6666666667;
        tripFare = Math.round(tripFare * 100.0) / 100.0;
        String transactionId = payment.charge(trip.studentId, tripFare);
        System.out.println("Payment=PAID txn=" + transactionId);
        BookingReceipt receipt = new BookingReceipt("R-501", tripFare);
        System.out.println("RECEIPT: " + receipt.id + " | fare=" + String.format("%.2f", receipt.fare));
    }
}
