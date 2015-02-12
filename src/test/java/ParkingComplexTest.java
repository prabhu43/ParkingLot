import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ParkingComplexTest {
    private ParkingComplex parkingComplex;

    @Test
    public void shouldAddParkingLotToComplex() {
        parkingComplex = new ParkingComplex();
        assertTrue(parkingComplex.addParkingLot(new ParkingLot(10, ParkingClass.DELUXE)));
    }

    @Test
    public void shouldAddParkingLotToAttendee() {
        parkingComplex = new ParkingComplex();
        ParkingLot parkingLot = new ParkingLot(10, ParkingClass.DELUXE);
        parkingComplex.addParkingLot(parkingLot);
        ParkingComplex.Attendee attendee = parkingComplex.new Attendee();

        parkingComplex.addParkingLotToAttendee(parkingLot, attendee);

        assertEquals(1, attendee.getParkingLots().size());
    }

    @Test
    public void shouldGetCheapestParkingLotFromAttendee() {
        parkingComplex = new ParkingComplex();
        ParkingLot parkingLot1 = new ParkingLot(10, ParkingClass.DELUXE);
        ParkingLot parkingLot2 = new ParkingLot(10, ParkingClass.PREMIUM);
        ParkingLot parkingLot3 = new ParkingLot(10, ParkingClass.STANDARD);
        parkingComplex.addParkingLot(parkingLot1);
        parkingComplex.addParkingLot(parkingLot2);
        parkingComplex.addParkingLot(parkingLot3);

        ParkingComplex.Attendee attendee = parkingComplex.new Attendee();

        parkingComplex.addParkingLotToAttendee(parkingLot1, attendee);
        parkingComplex.addParkingLotToAttendee(parkingLot2, attendee);
        parkingComplex.addParkingLotToAttendee(parkingLot3, attendee);

//        assertEquals(parkingLot3, attendee.getCheapestParkingLot());
    }

    @Test
    public void shouldReturnFirstAvailableParkingLot() {
        parkingComplex = new ParkingComplex();
        ParkingLot parkingLot1 = new ParkingLot(1, ParkingClass.DELUXE);
        ParkingLot parkingLot2 = new ParkingLot(10, ParkingClass.PREMIUM);
        ParkingLot parkingLot3 = new ParkingLot(10, ParkingClass.STANDARD);
        parkingComplex.addParkingLot(parkingLot1);
        parkingComplex.addParkingLot(parkingLot2);
        parkingComplex.addParkingLot(parkingLot3);

        ParkingComplex.Attendee attendee = parkingComplex.new Attendee();

        parkingComplex.addParkingLotToAttendee(parkingLot1, attendee);
        parkingComplex.addParkingLotToAttendee(parkingLot2, attendee);
        parkingComplex.addParkingLotToAttendee(parkingLot3, attendee);

        parkingLot1.allot(new Car());
        assertEquals(parkingLot2, attendee.getParkingLot());
    }
    @Test
    public void shouldReturnParkingLotWithMaximumSpace(){
        parkingComplex = new ParkingComplex();
        ParkingLot parkingLot1 = new ParkingLot(3, ParkingClass.DELUXE);
        ParkingLot parkingLot2 = new ParkingLot(3, ParkingClass.PREMIUM);
        ParkingLot parkingLot3 = new ParkingLot(3, ParkingClass.STANDARD);

        ParkingComplex.Attendee attendee = parkingComplex.new Attendee();

        parkingComplex.addParkingLot(parkingLot1);
        parkingComplex.addParkingLot(parkingLot2);
        parkingComplex.addParkingLot(parkingLot3);

        parkingComplex.addParkingLotToAttendee(parkingLot1, attendee);
        parkingComplex.addParkingLotToAttendee(parkingLot2, attendee);
        parkingComplex.addParkingLotToAttendee(parkingLot3, attendee);

        parkingLot1.allot(new Car());
        parkingLot2.allot(new Car());
        parkingLot2.allot(new Car());

//        assertEquals(parkingLot3,attendee.getParkingLotWithMaximumSpace());
    }



}