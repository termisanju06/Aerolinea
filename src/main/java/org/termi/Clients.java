package org.termi;

import lombok.*;

import java.util.Comparator;

@Data
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Clients {
    private String nif;
    private String name;
    private String surname;

}

