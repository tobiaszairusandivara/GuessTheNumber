package ar.edu.utn.frc.tup.piii.services;

import ar.edu.utn.frc.tup.piii.models.Dummy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DummyService {
    Dummy getDummyById(Long id);
    List<Dummy> getDummies();
    Dummy postDummy(Dummy dummy);
    Dummy putDummy(Dummy dummy, Long id);
    void deleteDummy(Long id);
}
