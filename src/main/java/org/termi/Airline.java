package org.termi;

import lombok.*;

@Data
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Airline {
    private String name;
    private IndexFlights[] indexFlights;
    private Clients[] clients;

    private Passengers[] passengersByFlight(int flightNumber){
        for (var indexflight : indexFlights){
            if (indexflight.getFlightNumber() == flightNumber){
                return indexflight.getPassengers();
            }
        }
        return null;
    }
}
