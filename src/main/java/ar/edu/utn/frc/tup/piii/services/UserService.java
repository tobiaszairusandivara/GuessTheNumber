package ar.edu.utn.frc.tup.piii.services;

import ar.edu.utn.frc.tup.piii.dtos.UserDto;
import ar.edu.utn.frc.tup.piii.models.Match;
import ar.edu.utn.frc.tup.piii.models.MatchDifficulty;
import ar.edu.utn.frc.tup.piii.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User createUser(UserDto userDto);
    Match createUserMatch(Long id, MatchDifficulty difficulty);
    User getUserById(Long id);
    List<User> getUsers();
    User updateUser(UserDto userDto, Long id);
    void deleteUser(Long id);
}
