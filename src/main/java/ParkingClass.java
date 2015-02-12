/**
 * Created by Prabhu on 2/10/15.
 */
public enum ParkingClass {
    PREMIUM(100), DELUXE(50), STANDARD(20);
    private int cost;
    ParkingClass(int cost){
        this.cost = cost;
    }
    public int getCost() {
        return this.cost;
    }
}
