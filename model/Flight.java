package model;

public class Flight {
    private String flightNumber;
    private String origin;
    private String destination;
    private int availableSeats;
    private double ticketPrice;

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public Flight(String flightNumber, String origin, String destination, int availableSeats, double ticketPrice) {
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.availableSeats = availableSeats;
        this.ticketPrice = ticketPrice;
    }

    @Override
    public String toString() {
        return "Flight [flightNumber=" + flightNumber + ", origin=" + origin + ", destination=" + destination
                + ", availableSeats=" + availableSeats + ", ticketPrice=" + ticketPrice + "]";
    }

}