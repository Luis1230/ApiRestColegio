package com.colegio.rest.apirestcolegio.dto.estudiante.actualizarEstudiante;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestActualizarEstudianteDto {

    @NotNull
    @Min(value = 1)
    private Integer idEstudiante;

    @NotNull
    @Size(min = 3, max = 50)
    private String nombres;

    @NotNull
    @Size(min = 3, max = 50)
    private String apellidos;

    @NotNull
    @Size(min = 7, max = 8)
    private String dni;

    @NotNull
    @Min(value = 1)
    private Integer edad;

}
