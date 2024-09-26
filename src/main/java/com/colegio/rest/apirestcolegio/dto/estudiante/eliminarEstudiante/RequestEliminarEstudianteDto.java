package com.colegio.rest.apirestcolegio.dto.estudiante.eliminarEstudiante;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestEliminarEstudianteDto {

    @NotNull
    @Min(value = 1)
    private Integer idEstudiante;

}
