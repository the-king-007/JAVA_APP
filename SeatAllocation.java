public class SeatAllocation {
    public static void main(String[] args) {
        int seatNumber = 47;

        System.out.print("Seat Number " + seatNumber + " belongs to the ");
        if (seatNumber % 2 == 0) {
            System.out.println("EVEN-numbered counter.");
        } else {
            System.out.println("ODD-numbered counter.");
        }
    }
}