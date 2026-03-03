package org.termi;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Airline {
    private String name;
    private IndexFlights[] indexFlights;
    private Clients[] clients;


}
