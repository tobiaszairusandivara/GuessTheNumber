package ar.edu.utn.frc.tup.piii.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {

    private Long id;

    @JsonProperty("username")
    @NotBlank
    private String userName;

    @Email
    @NotBlank
    private String email;
}
