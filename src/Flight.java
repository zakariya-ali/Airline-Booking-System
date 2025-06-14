import com.sun.source.tree.BreakTree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Flight {
    int flightNumber;
    Aircraft craft;
    String startLocation;
    String endLocation;
    double distance;
    int firstClassPassenger;
    int economyPassenger;
    int remainingSeats = 0;
    int totalSeats = 0;

    ArrayList<Seat> seats = new ArrayList();
    ArrayList<CrewMember> crew = new ArrayList();


    public Flight(int flightNumber, Aircraft craft, String startLocation, String endLocation, double distance){
        this.flightNumber = flightNumber;
        this.craft = craft;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.distance = distance;

        try{
            Scanner scanner = new Scanner(craft.getLayoutFile());
            int rowNumber = 0;
            while(scanner.hasNextLine()){
                rowNumber++;
                String[] seatsRow = scanner.nextLine().split(",");
                for (int i = 0; i < seatsRow.length; i++){
                    totalSeats++;
                    if(seatsRow[i] == "F"){
                        seats.add(new Seat(rowNumber, i + 1, "first"));
                    }else{
                        seats.add(new Seat(rowNumber, i + 1, "economy"));
                    }
                }
            }
        }catch (FileNotFoundException n){
            System.out.println("File not available");
        }
    }

    public double calculateTakeOffWeight(){
        double totalFlightWeight = craft.getCraftWeight();
        for (Seat seat : seats){
            totalFlightWeight += seat.getAllocatedTo().calculatePersonWeight();
        }
        for(CrewMember crewmember : crew){
            totalFlightWeight += crewmember.calculatePersonWeight();
        }
        return totalFlightWeight;

    }

    public int bookSeat(Passenger passenger){
        if(passenger.getFlightClass().equals("first")){
            firstClassPassenger++;
        }else{
            economyPassenger++;
        }
        int result = -1;
        for(int i = 0; i < seats.size(); i++){
            if (Objects.equals(seats.get(i).getFlyingClass(),passenger.getFlightClass()) && seats.get(i).getAllocatedTo() == null) {
                seats.get(i).setAllocatedTo(passenger);
                result = 1;
                break;
            }
        }
        for(int i = 0; i < seats.size(); i++)
            if (Objects.equals(passenger.getFlightClass(), "economy") && seats.get(i).getAllocatedTo() == null) {
                seats.get(i).setAllocatedTo(passenger);
                result = 2;
                break;
            }
        for(int i = 0; i < seats.size(); i++)
            if (Objects.equals(passenger.getFlightClass(), "first") && seats.get(i).getAllocatedTo() == null) {
                seats.get(i).setAllocatedTo(passenger);
                result = 3;
                break;
            }
        return result;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber){
        this.flightNumber = flightNumber;
    }

    public Aircraft getCraft() {
        return craft;
    }

    public void setCraft(Aircraft craft) {
        this.craft = craft;
    }

    public String getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(String startLocation) {
        this.startLocation = startLocation;
    }

    public String getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(String endLocation) {
        this.endLocation = endLocation;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public int getFirstClassPassenger() {
        return firstClassPassenger;
    }

    public void setFirstClassPassenger(int firstClassPassenger) {
        this.firstClassPassenger = firstClassPassenger;
    }

    public int getEconomyPassenger() {
        return economyPassenger;
    }

    public void setEconomyPassenger(int economyPassenger) {
        this.economyPassenger = economyPassenger;
    }

    public int getRemainingSeats() {
        return remainingSeats;
    }

    public void setRemainingSeats(int remainingSeats) {
        this.remainingSeats = remainingSeats;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public ArrayList<Seat> getSeats() {
        return seats;
    }

    public void setSeats(ArrayList<Seat> seats) {
        this.seats = seats;
    }

    public ArrayList<CrewMember> getCrew() {
        return crew;
    }

    public void setCrew(ArrayList<CrewMember> crew) {
        this.crew = crew;
    }

    @Override
    public String toString(){
        return "Flight Number: " + getFlightNumber() + "\n" +
                "Flight from: " + getStartLocation() + "\n" +
                "Flight to: " + getEndLocation() + "\n" +
                "Flight Distance: " + getDistance() + "\n" +
                "First Class Count: " + getFirstClassPassenger() + "\n" +
                "Economy Class Count: " + getEconomyPassenger() + "\n" +
                "Seats remaining: " + getRemainingSeats() + "\n" +
                "Flight Crew: " + getCrew() + "\n" +
                "Flight Aircraft Information: " + getCraft().toString();
    }
}


