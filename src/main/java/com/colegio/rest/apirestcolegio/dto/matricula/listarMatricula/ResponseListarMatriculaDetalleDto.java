package com.colegio.rest.apirestcolegio.dto.matricula.listarMatricula;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseListarMatriculaDetalleDto {

    private String aula;
    private String nombreCurso;
    private String siglasCurso;

}
