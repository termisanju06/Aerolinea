package org.termi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Getter
@Setter
public class Passengers {
    private String nif;
    private String seatNumber;
    private String[] luggages;
}
