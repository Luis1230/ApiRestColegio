package com.colegio.rest.apirestcolegio.controllers;

import com.colegio.rest.apirestcolegio.dto.BaseResponse;
import com.colegio.rest.apirestcolegio.dto.estudiante.guardarEstudiante.RequestGuardarEstudianteDto;
import com.colegio.rest.apirestcolegio.dto.estudiante.guardarEstudiante.ResponseGuardarEstudianteDto;
import com.colegio.rest.apirestcolegio.dto.estudiante.listarEstudiante.ResponseListarEstudianteDto;
import com.colegio.rest.apirestcolegio.dto.matricula.guardarMatricula.RequestGuardarMatriculaDto;
import com.colegio.rest.apirestcolegio.dto.matricula.guardarMatricula.ResponseGuardarMatriculaDto;
import com.colegio.rest.apirestcolegio.dto.matricula.listarMatricula.ResponseListarMatriculaDto;
import com.colegio.rest.apirestcolegio.mapper.MapperUtil;
import com.colegio.rest.apirestcolegio.models.Curso;
import com.colegio.rest.apirestcolegio.models.Estudiante;
import com.colegio.rest.apirestcolegio.models.Matricula;
import com.colegio.rest.apirestcolegio.models.MatriculaDetalle;
import com.colegio.rest.apirestcolegio.services.IMatriculaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/matriculas")
@RequiredArgsConstructor
public class MatriculaController {

    private final IMatriculaService _matriculaService;
    private final MapperUtil _mapperUtil;

    @GetMapping
    public ResponseEntity<BaseResponse<ResponseListarMatriculaDto>> listarMatricula() throws Exception
    {
        List<Matricula> objMatricula = _matriculaService.findAll();

        return new ResponseEntity<>( new BaseResponse<ResponseListarMatriculaDto>
                (
                        "0",
                        "Consulta ejecutada con exito",
                        "Consulta ejecutada con exito",
                        null,
                        _mapperUtil.mapList(objMatricula,ResponseListarMatriculaDto.class,"listarMatriculaMapper")
                ), HttpStatus.OK);
    }

    @PostMapping("/guardarMatricula")
    public ResponseEntity<BaseResponse<ResponseGuardarMatriculaDto>> guardarMatricula(@Valid @RequestBody RequestGuardarMatriculaDto request) throws Exception
    {
        Matricula objMatricula = _mapperUtil.map(request,Matricula.class,"requestGuardarMatriculaMapper");
        objMatricula = _matriculaService.save(objMatricula);

        if (objMatricula == null) {
            return new ResponseEntity<>( new BaseResponse<ResponseGuardarMatriculaDto>
                    (
                            "M002",
                            "Ocurrio un error al generar la matricula",
                            "Ocurrio un error al generar la matricula",
                            null,
                            null
                    ),HttpStatus.BAD_REQUEST);
        }
        else
        {
            return new ResponseEntity<>( new BaseResponse<ResponseGuardarMatriculaDto>
                    (
                            "0",
                            "Matricula generada con exito",
                            "Matricula generada con exito",
                            null,
                            null
                    ),HttpStatus.OK);
        }
    }

    @GetMapping("/alumnosMatriculadosxCurso")
    public ResponseEntity<Map<String,List<String>>> alumnosMatriculadosxCurso() throws Exception
    {
        Map<String,List<String>> byProduct = _matriculaService.obtenerAlumnosMatriculadosPorCurso();

        return ResponseEntity.ok(byProduct);
    }
}
