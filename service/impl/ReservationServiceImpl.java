package service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import model.Reservation;
import service.FlightService;
import service.ReservationService;

public class ReservationServiceImpl implements ReservationService {
    private final List<Reservation> reservations = new ArrayList<>();
    private final FlightService flightService = FlightServiceImpl.getFlightService();
    private final Scanner scanner = new Scanner(System.in);

    public void makeReservation() {
        flightService.listFlights();

        var flightNo = getFlightNoInput();
        var flight = flightService.getFlightByFlightNo(flightNo);
        if (flight == null) {
            System.out.println("Invalid flight number. Please Select a valid flight");
            return;
        }

        var passengerName = getPassengerNameInput();
        var noOfPassengers = getnoOfPassengersInput();
        if (noOfPassengers > flight.getAvailableSeats() || noOfPassengers <= 0) {
            System.out.println("Invalid number of passengers or not enough available seats");
            return;
        }

        var reservationId = UUID.randomUUID().toString();
        var reservation = new Reservation(reservationId, passengerName, noOfPassengers, flightNo);
        reservations.add(reservation);

        flight.setAvailableSeats(flight.getAvailableSeats() - noOfPassengers);
        System.out.println("Reservation created sucessfully");
    }

    public void listReservations() {
        for (var reservation : reservations) {
            String result = """
                    reservation ID : %s, passengername : %s, noOfPassengers : %d, FlightNo : %s
                    """;

            System.out.println(result.formatted(
                    reservation.getReservationId(),
                    reservation.getPasengerName(),
                    reservation.getNoOfPassengers(),
                    reservation.getFlightNo()));
        }
    }

    public void cancelReservation() {
        var reservationId = getReservationIdInput();
        var reservationToCancel = findReservationByReservationId(reservationId);

        if (reservationToCancel == null) {
            System.out.println("Unable to find reservation with id : " + reservationId);
        }
        reservations.remove(reservationToCancel);

        var flightNo = reservationToCancel.getFlightNo();
        var flight = flightService.getFlightByFlightNo(flightNo);
        flight.setAvailableSeats(flight.getAvailableSeats() + reservationToCancel.getNoOfPassengers());

        System.out.println("Reservation cancelled succesfully");
    }

    private String getFlightNoInput() {
        System.out.println("Enter flight no : ");
        var flightNo = scanner.nextLine();
        return flightNo;
    }

    private String getPassengerNameInput() {
        System.out.println("Enter Passenger name : ");
        var passengerName = scanner.nextLine();
        return passengerName;
    }

    private int getnoOfPassengersInput() {
        System.out.println("Enter no of passengers : ");
        var noOfPassengers = Integer.parseInt(scanner.nextLine());
        return noOfPassengers;
    }

    private String getReservationIdInput() {
        System.out.println("Enter reservation ID : ");
        var reservationId = scanner.nextLine();
        return reservationId;
    }

    private Reservation findReservationByReservationId(String reservationId) {
        for (var existingReservation : reservations) {
            if (existingReservation.getReservationId().equals(reservationId)) {
                return existingReservation;
            }
        }
        return null;
    }
}
