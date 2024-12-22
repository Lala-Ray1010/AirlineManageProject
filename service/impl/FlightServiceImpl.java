package service.impl;

import java.util.HashMap;
import java.util.Map;

import model.Flight;
import service.FlightService;

public class FlightServiceImpl implements FlightService {
    private static FlightServiceImpl FLIGHT_SERVICE = null;
    private final Map<String, Flight> flights = new HashMap<>();

    private FlightServiceImpl() {
    }

    public static FlightServiceImpl getFlightService() {
        if (FLIGHT_SERVICE == null) {
            FLIGHT_SERVICE = new FlightServiceImpl();
        }

        return FLIGHT_SERVICE;
    }

    public void initializeFlights() {
        var flight1 = new Flight("FL001", "Bhubaneswar", "New Delhi", 60, 4000.99);
        var flight2 = new Flight("FL002", "New Delhi", "Banglore", 90, 4500.78);

        flights.put("FL001", flight1);
        flights.put("FL002", flight2);
    }

    public void listFlights() {
        var flightsList = flights.values();
        for (var flight : flightsList) {
            System.out.println(flight);
        }
    }

    public Map<String, Flight> getFlights() {
        return flights;
    }

    public Flight getFlightByFlightNo(String flightNo) {
        return flights.get(flightNo);
    }
}
