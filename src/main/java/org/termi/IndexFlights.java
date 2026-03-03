package org.termi;

import lombok.*;

@Data
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class IndexFlights {
    private int flightNumber;
    private String origin;
    private String destination;
    private String flightDate;
    private String[] passengers;
}
