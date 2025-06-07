package ar.edu.utn.frc.tup.piii.controllers;

import ar.edu.utn.frc.tup.piii.dtos.MatchDto;
import ar.edu.utn.frc.tup.piii.models.Match;
import ar.edu.utn.frc.tup.piii.models.MatchDifficulty;
import ar.edu.utn.frc.tup.piii.services.MatchService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("guess-number/matches")
public class MatchController {

    @Autowired
    private MatchService matchService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("{id}")
    public ResponseEntity<MatchDto> getMatch(@PathVariable Long id){
        Match match = matchService.getMatchById(id);
        MatchDto matchDto = modelMapper.map(match, MatchDto.class);
        return ResponseEntity.ok(matchDto);
    }

    @GetMapping("")
    public ResponseEntity<List<MatchDto>> getMatches() {
        List<Match> matches = matchService.getMatches();
        List<MatchDto> matchesDtos = matches.stream()
                .map(match -> modelMapper.map(match, MatchDto.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(matchesDtos);
    }

    @PostMapping("user/{id}/difficulty/{difficulty}")
    public ResponseEntity<MatchDto> postMatch(@PathVariable Long id, @PathVariable MatchDifficulty difficulty) {
        Match match = matchService.createMatch(id, difficulty);
        MatchDto matchDtoCreated = modelMapper.map(match, MatchDto.class);
        return ResponseEntity.ok(matchDtoCreated);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteMatch(@PathVariable Long id) {
        matchService.deleteMatch(id);
        return ResponseEntity.noContent().build();
    }
}
