package org.termi;

import lombok.*;

import java.util.*;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Airline {
    private String name;
    private Map<Integer, Flights> indexFlights;
    private List<Clients> clients;

    public void rellenoDeAtributos(){
        List<Clients> clientsList = new ArrayList<>();
        clientsList.add(new Clients("123", "paco", "piña"));
        List<Clients> clientsList2 = new ArrayList<>();
        clientsList2.add(new Clients("456", "pico", "colada"));
        new Clients("456", "pico", "colada");
        List<Clients> clientsList3 = new ArrayList<>();
        clientsList3.add(new Clients("789", "paca", "maria"));


        List<Luggages> luggages = new ArrayList<>();
        luggages.add(new Luggages("ER1", "PUEDE"));
        List<Luggages> luggages2 = new ArrayList<>();
        luggages2.add(new Luggages("ER2", "NOPUEDE"));
        List<Luggages> luggages3 = new ArrayList<>();
        luggages3.add(new Luggages("ER3", "PUEDEPUEDE"));

        Set<Passengers> passengers = new HashSet<>();
        passengers.add(new Passengers("123A", 32, luggages));
        Set<Passengers> passengers2 = new HashSet<>();
        passengers2.add(new Passengers("123A", 32, luggages2));
        Set<Passengers> passengers3 = new HashSet<>();
        passengers3.add(new Passengers("123A", 32, luggages3));

        Map<Integer, Flights> indexFlightsMap = new HashMap<>();
        indexFlightsMap.put(1, new Flights(1,"Pamplona", "Pedrolandia", "Nose", passengers));
        Map<Integer, Flights> indexFlightsMap2 = new HashMap<>();
        indexFlightsMap2.put(2,new Flights(2,"CoreaDelNorte", "Pascua", "10/02/2075", passengers2));
        Map<Integer, Flights> indexFlightsMap3 = new HashMap<>();
        indexFlightsMap3.put(3,new Flights(3,"Pekin", "Partida", "01/01/0923", passengers3));

        new Airline("PlusUltra", indexFlightsMap,clientsList);
        new Airline("Camerun", indexFlightsMap2,clientsList2);
        new Airline("Perdiz", indexFlightsMap3, clientsList3);
    }

    public Set<Passengers> getPassengersByFlightNumber(int flightnumber){
        Flights flights1 = indexFlights.get(flightnumber);
        if (flights1 != null){
            return flights1.getPassengers();
        }
        return null;
    }
    public List<Clients> getClientsByFlightNumber(int flightnumber){
        Flights flights1 = indexFlights.get(flightnumber);
        if (flights1 == null){
            return null;
        }
        return flights1.getPassengers().stream()
                .flatMap(passengers -> clients.stream()
                        .filter(client -> client.getNif().equals(passengers.getNif()))).toList();
    }
    public List<Clients> findClientsBySurname(Airline airline, String surname){
        return airline.getClients().stream()
                .filter(c -> c.getSurname().equals(surname)).collect(Collectors.toList());
    }
    public Integer seatByFlightAndNif(Airline airline, int flightNumber, String nif){
        Flights flights = airline.getIndexFlights().get(flightNumber);
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
        Flights flights = airline.getIndexFlights().get(flightNumber);

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
    public List<Flights> flightsByNifWhereClientIsPassenger (Airline airline, String nif){
        List<Flights> clients = new ArrayList<>();
        for (Flights flights : airline.getIndexFlights().values()){
            for (Passengers passengers : flights.getPassengers()){
                if (passengers.getNif().equalsIgnoreCase(nif)){
                    clients.add(flights);
                }
            }
        }
        return clients;
    }
}
