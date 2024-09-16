package com.colegio.rest.apirestcolegio.dto.curso.listarCurso;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseListarCursoDto {

    private String nombre;
    private String siglas;
    private boolean estado;

}
