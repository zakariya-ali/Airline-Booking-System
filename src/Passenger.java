public class Passenger extends Person {
    private int holdBags;
    private String flightClass;

    public Passenger(String name, int passengerNumber, String flightClass, int holdBags){
        super(name, passengerNumber);
        this.holdBags = holdBags;
        this.flightClass = flightClass;
    }

    public int getHoldBags() {
        return holdBags;
    }

    public void setHoldBags(int holdBags) {
        this.holdBags = holdBags;
    }

    public String getFlightClass() {
        return flightClass;
    }

    public void setFlightClass(String flightClass) {
        this.flightClass = flightClass;
    }

    @Override
    public double calculatePersonWeight(){
        if(flightClass == "first"){
            return 87.5 + (25 * holdBags);
        }else{
            return 80.0 + (25 * holdBags);
        }
    }
}
