package org.termi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Getter
@Setter
public class IndexFlights {
    private int flightNumber;
    private String origin;
    private String destination;
    private String flightDate;
    private String[] passengers;
}
