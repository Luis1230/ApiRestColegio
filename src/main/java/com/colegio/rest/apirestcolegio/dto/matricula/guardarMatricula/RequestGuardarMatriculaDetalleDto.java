package com.colegio.rest.apirestcolegio.dto.matricula.guardarMatricula;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestGuardarMatriculaDetalleDto {

    private String aula;

    private Integer idCurso;

    @JsonBackReference
    public RequestGuardarMatriculaDto matricula;

}
