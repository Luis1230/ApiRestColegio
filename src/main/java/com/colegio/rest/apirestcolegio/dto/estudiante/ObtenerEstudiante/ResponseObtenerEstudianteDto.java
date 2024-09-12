package com.colegio.rest.apirestcolegio.dto.estudiante.ObtenerEstudiante;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseObtenerEstudianteDto {

    private String nombres;
    private String apellidos;
    private String dni;
    private Integer edad;

}
