package ar.edu.utn.frc.tup.piii.services.impl;

import ar.edu.utn.frc.tup.piii.models.Dummy;
import ar.edu.utn.frc.tup.piii.repositories.DummyRepository;
import ar.edu.utn.frc.tup.piii.services.DummyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DummyServiceImpl implements DummyService {

    @Autowired
    private DummyRepository dummyRepository;

    @Override
    public Dummy getDummyById(Long id) {
        return null;
    }

    @Override
    public List<Dummy> getDummies() {
        return List.of();
    }

    @Override
    public Dummy postDummy(Dummy dummy) {
        return null;
    }

    @Override
    public Dummy putDummy(Dummy dummy, Long id) {
        return null;
    }

    @Override
    public void deleteDummy(Long id) {

    }
}
