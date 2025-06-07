package ar.edu.utn.frc.tup.piii.services;

import ar.edu.utn.frc.tup.piii.dtos.UserDto;
import ar.edu.utn.frc.tup.piii.models.Match;
import ar.edu.utn.frc.tup.piii.models.MatchDifficulty;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MatchService {
    Match createMatch(Long id, MatchDifficulty matchDifficulty);
    Match getMatchById(Long id);
    List<Match> getMatches();
    void deleteMatch(Long id);
}
