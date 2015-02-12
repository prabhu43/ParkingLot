package com;

import java.util.ArrayList;

public class CarCollection extends ArrayList<Car> {
    private int capacity;
    private boolean isStatusChanged;
    private Status status;
    private ArrayList<ParkingLotListener> parkingLotListeners;


    public CarCollection(int capacity) {
        this.capacity = capacity;
        this.parkingLotListeners = new ArrayList<ParkingLotListener>();
        updateStatus();
    }

    @Override
    public boolean add(Car newCar) {
        if (!isFull()) {
            super.add(newCar);
            updateStatus();
            return true;
        }
        return false;
    }

    public boolean remove(Car newCar) {
        if (super.contains(newCar)) {
            super.remove(newCar);
            updateStatus();
            return true;
        }
        return false;
    }

    public boolean isFull() {
        return this.size() == capacity;
    }

    private void updateStatus() {
        int filledPercent = (this.size() * 100) / capacity;
        Status previousStatus = getStatus();
        if (filledPercent == 100) {
            status = Status.FULL;
        } else if (filledPercent >= 80) {
            status = Status.LIMITED_AVAILABILITY;
        } else {
            status = Status.AVAILABLE;
        }

        if (previousStatus != getStatus()){
            isStatusChanged = true;
        }
        else {
            isStatusChanged = false;
        }
    }

    public Status getStatus() {
        return status;
    }

    public boolean isStatusChanged() {
        return isStatusChanged;
    }

    public int getAvailableSpaces() {
        return capacity - this.size();
    }

    enum Status {
        FULL, LIMITED_AVAILABILITY, AVAILABLE;
    }
}
