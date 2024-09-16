package com.colegio.rest.apirestcolegio.dto.curso.obtenerCurso;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseObtenerCursoDto {

    private String nombre;
    private String siglas;
    private boolean estado;

}
