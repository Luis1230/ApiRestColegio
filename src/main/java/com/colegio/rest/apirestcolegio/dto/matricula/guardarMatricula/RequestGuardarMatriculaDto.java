package com.colegio.rest.apirestcolegio.dto.matricula.guardarMatricula;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestGuardarMatriculaDto {

    @NotNull
    @Min(value = 1)
    private Integer idEstudiante;

    @NotNull
    private LocalDateTime fechamatricula;

    @NotNull
    private boolean estadoMatricula;

    @JsonManagedReference
    private List<RequestGuardarMatriculaDetalleDto> matriculaDetalle;

}
