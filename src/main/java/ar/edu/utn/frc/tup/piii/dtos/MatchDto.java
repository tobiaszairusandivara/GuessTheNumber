package ar.edu.utn.frc.tup.piii.dtos;

import ar.edu.utn.frc.tup.piii.models.MatchDifficulty;
import ar.edu.utn.frc.tup.piii.models.MatchStatus;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MatchDto {

    private Long id;
    private MatchDifficulty difficulty;
    private Long remainingTries;
}
