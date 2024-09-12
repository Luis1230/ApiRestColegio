package com.colegio.rest.apirestcolegio.dto.estudiante.guardarEstudiante;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseGuardarEstudianteDto {
    private String nombres;
    private String apellidos;
    private String dni;
    private Integer edad;
}
