package com.colegio.rest.apirestcolegio.dto.curso.actualizarCurso;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseActualizarCursoDto {

    private String nombre;
    private String siglas;
    private boolean estado;
}
