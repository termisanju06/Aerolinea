package org.termi;

import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
}
