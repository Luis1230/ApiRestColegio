package com.colegio.rest.apirestcolegio.dto.estudiante.listarEstudiante;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseListarEstudianteDto {

    private String nombres;
    private String apellidos;
    private String dni;
    private Integer edad;

}
