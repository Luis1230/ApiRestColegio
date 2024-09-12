package com.colegio.rest.apirestcolegio.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class MatriculaDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer idMatriculaDetalle;

    @ManyToOne
    @JoinColumn(nullable = false, name = "id_Matricula", foreignKey = @ForeignKey(name = "FK_Matriculadetalle_Matricula"))
    @JsonBackReference
    private Matricula matricula;

    @ManyToOne
    @JoinColumn(name = "id_curso", nullable = false, foreignKey = @ForeignKey(name = "FK_Matriculadetalle_Curso"))
    private Curso curso;

    @Column(nullable = false,length = 50)
    private String aula;

}
