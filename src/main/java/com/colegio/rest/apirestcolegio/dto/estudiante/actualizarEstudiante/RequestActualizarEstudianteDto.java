package com.colegio.rest.apirestcolegio.dto.estudiante.actualizarEstudiante;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestActualizarEstudianteDto {

    private Integer idEstudiante;
    private String nombres;
    private String apellidos;
    private String dni;
    private Integer edad;

}
