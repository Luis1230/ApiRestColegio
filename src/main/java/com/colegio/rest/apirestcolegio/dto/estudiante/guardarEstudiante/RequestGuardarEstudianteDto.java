package com.colegio.rest.apirestcolegio.dto.estudiante.guardarEstudiante;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestGuardarEstudianteDto {

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
