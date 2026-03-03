package org.termi;

import lombok.*;

@Data
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Airline {
    private String name;
    private String[] indexFlights;
    private String[] clients;
}
