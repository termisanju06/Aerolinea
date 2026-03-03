package org.termi;

import lombok.*;

import java.util.Comparator;

@Data
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Passengers {
    private String nif;
    private String seatNumber;
    private Luggages[] luggages;
}
