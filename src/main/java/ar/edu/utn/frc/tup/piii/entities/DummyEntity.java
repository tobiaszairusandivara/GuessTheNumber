package ar.edu.utn.frc.tup.piii.entities;

import jakarta.persistence.*;

@Entity
public class DummyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    private String name;
}
