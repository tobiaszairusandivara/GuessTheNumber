package ar.edu.utn.frc.tup.piii.entities;

import ar.edu.utn.frc.tup.piii.models.MatchDifficulty;
import ar.edu.utn.frc.tup.piii.models.MatchStatus;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "matches")
public class MatchEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @JoinColumn(name = "user_id")
    @ManyToOne
    private UserEntity user;

    @Column(name = "difficulty", nullable = false)
    @Enumerated(EnumType.STRING)
    private MatchDifficulty difficulty;

    @Column(name = "numberToGuess", nullable = false)
    private Integer numberToGuess;

    @Column(name = "remainingTries", nullable = false)
    private Integer remainingTries;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private MatchStatus status;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
