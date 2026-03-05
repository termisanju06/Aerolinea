package org.termi;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Airline {
    private String name;
    private Map<Integer, IndexFlights> indexFlights;
    private List<Clients> clients;

    public Set<Passengers> getPassengersByFlightNumber(int flightnumber){
        IndexFlights indexFlights1 = indexFlights.get(flightnumber);
        if (indexFlights1 != null){
            return indexFlights1.getPassengers();
        }
        return null;
    }
    public List<Clients> getClientsByFlightNumber(int flightnumber){
        IndexFlights indexFlights1 = indexFlights.get(flightnumber);
        if (indexFlights1 == null){
            return null;
        }
        return indexFlights1.getPassengers().stream()
                .flatMap(passengers -> clients.stream()
                        .filter(client -> client.getNif().equals(passengers.getNif()))).toList();
    }
    public List<Clients> findClientsBySurname(Airline airline, String surname){
        return airline.getClients().stream()
                .filter(c -> c.getSurname().equals(surname)).collect(Collectors.toList());
    }
    public Integer seatByFlightAndNif(Airline airline, int flightNumber, String nif){
        IndexFlights flights = airline.getIndexFlights().get(flightNumber);
        if (flights == null){
            return  null;
        }
        for (Passengers passengers : flights.getPassengers()){
            if (passengers.getNif().equalsIgnoreCase(nif)){
                return passengers.getSeatNumber();
            }
        }
        return null;
    }
    public void addLuggageToPassenger(Airline airline, int flightNumber, Luggages luggages, String nif){
        IndexFlights flights = airline.getIndexFlights().get(flightNumber);

        if (flights == null){
            System.out.println("No hay un numero de vuelo correspondiente a: " + flightNumber);
            return;
        }
        Passengers passengersFounded = null;
        for (Passengers passengers : flights.getPassengers()){
            if (passengers.getNif().equalsIgnoreCase(nif)){
                passengersFounded = passengers;
                break;
            }
        }
        if (passengersFounded == null){
            System.out.println("Error: No hay un pasajero con un nif de: " + nif + " En el vuelo: " + flightNumber);
            return;
        }
        passengersFounded.getLuggages().add(luggages);
    }
    public List<IndexFlights> flightsByNifWhereClientIsPassenger (Airline airline, String nif){
        List<IndexFlights> clients = new ArrayList<>();
        for (IndexFlights flights : airline.getIndexFlights().values()){
            for (Passengers passengers : flights.getPassengers()){
                if (passengers.getNif().equalsIgnoreCase(nif)){
                    clients.add(flights);
                }
            }
        }
        return clients;
    }
}
