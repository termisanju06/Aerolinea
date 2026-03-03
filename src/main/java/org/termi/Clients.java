package org.termi;

import lombok.*;

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
