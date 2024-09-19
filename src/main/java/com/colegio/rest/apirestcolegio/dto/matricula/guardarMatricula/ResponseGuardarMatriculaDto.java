package com.colegio.rest.apirestcolegio.dto.matricula.guardarMatricula;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseGuardarMatriculaDto {

    private Integer idMatricula;
    private String nombresEstudiante;
    private String apellidosEstudiante;
    private LocalDateTime fechamatricula;
    private boolean estadoMatricula;
    private List<ResponseGuardarMatriculaDetalleDto> matriculaDetalle;

}
