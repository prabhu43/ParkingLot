package com;

import java.util.List;

/**
 * Created by Prabhu on 2/11/15.
 */
public class LargestParkingLotFinder implements ParkingLotFinder {
    @Override
    public ParkingLot findParkingLot(List<ParkingLot> parkingLots) {
        ParkingLot largestParkingLot = null;
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.isFull())
                continue;

            if (largestParkingLot == null) {
                largestParkingLot = parkingLot;
            } else {
                if (largestParkingLot.getAvailableSpaces() < parkingLot.getAvailableSpaces()) {
                    largestParkingLot = parkingLot;

                }
            }

        }
        return largestParkingLot;
    }
}
