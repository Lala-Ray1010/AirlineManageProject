package service;

import java.util.Map;

import model.Flight;

public interface FlightService {
    void initializeFlights();

    void listFlights();

    Map<String, Flight> getFlights();

    Flight getFlightByFlightNo(String flightNo);
}
