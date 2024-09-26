package com.colegio.rest.apirestcolegio.dto.curso.guardarCurso;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestGuardarCursoDto {

    @NotNull
    @Size(min = 3, max = 50)
    private String nombre;

    @NotNull
    @Size(min = 3, max = 50)
    private String siglas;

    @NotNull
    private boolean estado;

}
