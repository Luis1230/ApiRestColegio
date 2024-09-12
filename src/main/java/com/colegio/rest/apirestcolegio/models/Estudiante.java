package com.colegio.rest.apirestcolegio.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idEstudiante;

    @Column(nullable = false,length = 50)
    private String nombres;

    @Column(nullable = false,length = 50)
    private String apellidos;

    @Column(nullable = false,length = 8)
    private String dni;

    @Column(nullable = false)
    private Integer edad;
}
