package com.colegio.rest.apirestcolegio.dto.curso.eliminarCurso;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestEliminarCursoDto {

    @NotNull
    @Min(value = 1)
    private Integer idCurso;
}
