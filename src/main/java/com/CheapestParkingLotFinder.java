package com;

import java.util.List;

/**
 * Created by Prabhu on 2/11/15.
 */
public class CheapestParkingLotFinder implements ParkingLotFinder {


    @Override
    public ParkingLot findParkingLot(List<ParkingLot> parkingLots) {
        ParkingLot cheapestParkingLot = null;
        for (ParkingLot parkingLot : parkingLots) {
            if (cheapestParkingLot == null) {
                cheapestParkingLot = parkingLot;
            } else {
                if (cheapestParkingLot.getCost() > parkingLot.getCost()) {
                    cheapestParkingLot = parkingLot;
                }
            }
        }
        return cheapestParkingLot;
    }
}
