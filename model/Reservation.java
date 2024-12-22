package model;

public class Reservation {
    private String reservationId;
    private String pasengerName;
    private int noOfPassengers;
    private String flightNo;

    public Reservation() {
    }

    public Reservation(String reservationId, String pasengerName, int noOfPassengers, String flightNo) {
        this.reservationId = reservationId;
        this.pasengerName = pasengerName;
        this.noOfPassengers = noOfPassengers;
        this.flightNo = flightNo;
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public String getPasengerName() {
        return pasengerName;
    }

    public void setPasengerName(String pasengerName) {
        this.pasengerName = pasengerName;
    }

    public int getNoOfPassengers() {
        return noOfPassengers;
    }

    public void setNoOfPassengers(int noOfPassengers) {
        this.noOfPassengers = noOfPassengers;
    }

    public String getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(String flightNo) {
        this.flightNo = flightNo;
    }

}
