package com.colegio.rest.apirestcolegio.dto.matricula.guardarMatricula;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseGuardarMatriculaDetalleDto {

    private String aula;
    private String nombreCurso;
    private String siglasCurso;

}
