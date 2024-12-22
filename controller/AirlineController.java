package controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import service.FlightService;
import service.ReservationService;
import service.impl.FlightServiceImpl;
import service.impl.ReservationServiceImpl;

public class AirlineController {
    private final FlightService flightService = FlightServiceImpl.getFlightService();
    private final ReservationService reservationService = new ReservationServiceImpl();

    public void home() {
        flightService.initializeFlights();

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            mainpageView();
            choice = scanner.nextInt();
            handleChoice(choice);
        } while (choice != 0);

        scanner.close();
    }

    private void mainpageView() {
        System.out.println("1> List Of Flights");
        System.out.println("2> Make a Reservation");
        System.out.println("3> List of Reservations");
        System.out.println("4> Cancel Reservation");
        System.out.println("0> Exit");
    }

    private void handleChoice(int choice) {
        switch (choice) {
            case 1:
                flightService.listFlights();
                break;
            case 2:
                reservationService.makeReservation();
                break;
            case 3:
                reservationService.listReservations();
                break;
            case 4:
                reservationService.cancelReservation();
                break;
            case 0:
                System.out.println("Good Bye!!!");
        }
    }
}
