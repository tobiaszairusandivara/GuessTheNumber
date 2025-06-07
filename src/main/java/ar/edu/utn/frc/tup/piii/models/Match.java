package ar.edu.utn.frc.tup.piii.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
public class Match {
    private Long id;
    private Long userId;
    private MatchDifficulty difficulty;
    private Long numberToGuess;
    private Long remainingTries;
    private MatchStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
