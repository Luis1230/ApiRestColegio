package com.colegio.rest.apirestcolegio.dto.matricula.guardarMatricula;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestGuardarMatriculaDetalleDto {

    @NotNull
    @Size(min = 3, max = 50)
    private String aula;

    @NotNull
    @Min(value = 1)
    private Integer idCurso;

    @JsonBackReference
    public RequestGuardarMatriculaDto matricula;

}
