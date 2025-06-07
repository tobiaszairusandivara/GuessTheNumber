package ar.edu.utn.frc.tup.piii.services.impl;

import ar.edu.utn.frc.tup.piii.entities.MatchEntity;
import ar.edu.utn.frc.tup.piii.entities.UserEntity;
import ar.edu.utn.frc.tup.piii.models.Match;
import ar.edu.utn.frc.tup.piii.models.MatchDifficulty;
import ar.edu.utn.frc.tup.piii.models.MatchStatus;
import ar.edu.utn.frc.tup.piii.repositories.MatchRepository;
import ar.edu.utn.frc.tup.piii.repositories.UserRepository;
import ar.edu.utn.frc.tup.piii.services.MatchService;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class MatchServiceImpl implements MatchService {

    @Autowired
    private MatchRepository matchRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepository userRepository;

    @Override
    public Match createMatch(Long userId, MatchDifficulty difficulty) {
        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + userId));

        MatchEntity matchEntity = new MatchEntity();
        matchEntity.setUser(userEntity);
        matchEntity.setDifficulty(difficulty);
        switch (difficulty) {
            case EASY -> matchEntity.setRemainingTries(10);
            case MEDIUM -> matchEntity.setRemainingTries(8);
            case HARD -> matchEntity.setRemainingTries(5);
        }
        Random random = new Random();
        matchEntity.setNumberToGuess(random.nextInt(101));
        matchEntity.setStatus(MatchStatus.PLAYING);
        matchEntity.setCreatedAt(LocalDateTime.now());
        matchEntity.setUpdatedAt(LocalDateTime.now());
        MatchEntity matchEntitySaved = matchRepository.save(matchEntity);
        return modelMapper.map(matchEntitySaved, Match.class);
    }

    @Override
    public Match getMatchById(Long id) {
        MatchEntity matchEntity = matchRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Match not found with id: " + id));
        return modelMapper.map(matchEntity, Match.class);
    }

    @Override
    public List<Match> getMatches() {
        List<MatchEntity> entities = matchRepository.findAll();
        return entities.stream()
                .map(matchEntity -> modelMapper.map(matchEntity, Match.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteMatch(Long id) {
        MatchEntity matchEntity = matchRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Match not found with id: " + id));
        matchRepository.delete(matchEntity);
    }
}
