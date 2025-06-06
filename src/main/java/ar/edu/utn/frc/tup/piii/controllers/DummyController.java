package ar.edu.utn.frc.tup.piii.controllers;

import ar.edu.utn.frc.tup.piii.dtos.DummyDto;
import ar.edu.utn.frc.tup.piii.models.Dummy;
import ar.edu.utn.frc.tup.piii.services.DummyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dummy")
public class DummyController {

    @Autowired
    private DummyService dummyService;

    @GetMapping("/{id}")
    public ResponseEntity<DummyDto> getDummyById(@PathVariable Long id) {
        Dummy dummy = dummyService.getDummyById(id);
        return null;
    }

    @GetMapping("")
    public ResponseEntity<DummyDto> getDummies() {
        List<Dummy> dummies = dummyService.getDummies();
        return null;
    }

    @PostMapping("")
    public ResponseEntity<DummyDto> postDummy(DummyDto dummyDto) {
        Dummy dummy = dummyService.postDummy(null);
        return null;
    }

    @PutMapping("")
    public ResponseEntity<DummyDto> putDummy(DummyDto dummyDto) {
        Dummy dummy = dummyService.putDummy(null, null);
        return null;
    }

    @DeleteMapping("")
    public ResponseEntity<DummyDto> deleteDummy(DummyDto dummyDto) {
        dummyService.deleteDummy(null);
        return null;
    }
}
