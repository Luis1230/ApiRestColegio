package com.colegio.rest.apirestcolegio.dto.matricula.guardarMatricula;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestGuardarMatriculaDto {

    private Integer idEstudiante;
    private LocalDateTime fechamatricula;
    private boolean estadoMatricula;

    @JsonManagedReference
    private List<RequestGuardarMatriculaDetalleDto> matriculaDetalle;

}
