package com.colegio.rest.apirestcolegio.dto.curso.guardarCurso;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestGuardarCursoDto {

    private String nombre;
    private String siglas;
    private boolean estado;

}
