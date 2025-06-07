package ar.edu.utn.frc.tup.piii.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class User {
    private Long id;
    private String userName;
    private String email;
}
