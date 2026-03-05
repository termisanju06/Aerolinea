package org.termi;

import lombok.*;

import java.util.Comparator;
import java.util.List;

@Data
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Passengers {
    private String nif;
    private Integer seatNumber;
    private List<Luggages> luggages;
}
