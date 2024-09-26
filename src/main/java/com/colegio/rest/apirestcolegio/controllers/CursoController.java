package com.colegio.rest.apirestcolegio.controllers;

import com.colegio.rest.apirestcolegio.dto.BaseResponse;
import com.colegio.rest.apirestcolegio.dto.curso.actualizarCurso.RequestActualizarCursoDto;
import com.colegio.rest.apirestcolegio.dto.curso.actualizarCurso.ResponseActualizarCursoDto;
import com.colegio.rest.apirestcolegio.dto.curso.eliminarCurso.RequestEliminarCursoDto;
import com.colegio.rest.apirestcolegio.dto.curso.guardarCurso.RequestGuardarCursoDto;
import com.colegio.rest.apirestcolegio.dto.curso.guardarCurso.ResponseGuardarCursoDto;
import com.colegio.rest.apirestcolegio.dto.curso.listarCurso.ResponseListarCursoDto;
import com.colegio.rest.apirestcolegio.dto.curso.obtenerCurso.RequestObtenerCursoDto;
import com.colegio.rest.apirestcolegio.dto.curso.obtenerCurso.ResponseObtenerCursoDto;
import com.colegio.rest.apirestcolegio.dto.estudiante.actualizarEstudiante.RequestActualizarEstudianteDto;
import com.colegio.rest.apirestcolegio.dto.estudiante.actualizarEstudiante.ResponseActualizarEstudianteDto;
import com.colegio.rest.apirestcolegio.dto.estudiante.eliminarEstudiante.RequestEliminarEstudianteDto;
import com.colegio.rest.apirestcolegio.dto.estudiante.guardarEstudiante.RequestGuardarEstudianteDto;
import com.colegio.rest.apirestcolegio.dto.estudiante.guardarEstudiante.ResponseGuardarEstudianteDto;
import com.colegio.rest.apirestcolegio.mapper.MapperUtil;
import com.colegio.rest.apirestcolegio.models.Curso;
import com.colegio.rest.apirestcolegio.models.Estudiante;
import com.colegio.rest.apirestcolegio.services.ICursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
@RequiredArgsConstructor
public class CursoController {

    private final ICursoService _cursoService;
    private final MapperUtil _mapperUtil;

    @GetMapping
    public ResponseEntity<BaseResponse<ResponseListarCursoDto>> listarCurso() throws Exception
    {
        List<Curso> objCurso = _cursoService.findAll();

        return new ResponseEntity<>( new BaseResponse<ResponseListarCursoDto>
                (
                        "0",
                        "Consulta ejecutada con exito",
                        "Consulta ejecutada con exito",
                        null,
                        _mapperUtil.mapList(objCurso,ResponseListarCursoDto.class,"")
                ), HttpStatus.OK);
    }

    @PostMapping("/obtenerCurso")
    public ResponseEntity<BaseResponse<ResponseObtenerCursoDto>> obtenerCurso(@RequestBody RequestObtenerCursoDto request) throws Exception
    {
        Curso objCurso = _mapperUtil.map(request,Curso.class,"");
        objCurso = _cursoService.findById(objCurso.getIdCurso());

        if (objCurso == null) {
            return new ResponseEntity<>( new BaseResponse<ResponseObtenerCursoDto>
                    (
                            "C001",
                            "El curso consultado no existe",
                            "El curso consultado no existe",
                            null,
                            null
                    ),HttpStatus.BAD_REQUEST);
        }
        else
        {
            return new ResponseEntity<>( new BaseResponse<ResponseObtenerCursoDto>
                    (
                            "0",
                            "Consulta ejecutada con exito",
                            "Consulta ejecutada con exito",
                            _mapperUtil.map(objCurso,ResponseObtenerCursoDto.class,""),
                            null
                    ),HttpStatus.OK);
        }
    }

    @PostMapping("/guardarCurso")
    public ResponseEntity<BaseResponse<ResponseGuardarCursoDto>> guardarCurso(@RequestBody RequestGuardarCursoDto request) throws Exception
    {
        Curso objCurso = _mapperUtil.map(request,Curso.class,"");
        objCurso = _cursoService.save(objCurso);

        if (objCurso == null) {
            return new ResponseEntity<>( new BaseResponse<ResponseGuardarCursoDto>
                    (
                            "C002",
                            "Ocurrio un error al guardar el Curso",
                            "Ocurrio un error al guardar el Curso",
                            null,
                            null
                    ),HttpStatus.BAD_REQUEST);
        }
        else
        {
            return new ResponseEntity<>( new BaseResponse<ResponseGuardarCursoDto>
                    (
                            "0",
                            "Curso guardado con exito",
                            "Curso guardado con exito",
                            _mapperUtil.map(objCurso,ResponseGuardarCursoDto.class,""),
                            null
                    ),HttpStatus.OK);
        }
    }

    @PostMapping("/actualizarCurso")
    public ResponseEntity<BaseResponse<ResponseActualizarCursoDto>> actualizarCurso(@RequestBody RequestActualizarCursoDto request) throws Exception
    {
        Curso objCurso = _cursoService.findById(request.getIdCurso());

        if (objCurso == null)
        {
            return new ResponseEntity<>( new BaseResponse<ResponseActualizarCursoDto>
                    (
                            "C003",
                            "El Curso no existe",
                            "El Curso no existe",
                            null,
                            null
                    ),HttpStatus.BAD_REQUEST);
        }
        else
        {
            Curso objActualizarCurso = _mapperUtil.map(request,Curso.class,"");
            objActualizarCurso = _cursoService.update(objActualizarCurso.getIdCurso(),objActualizarCurso);

            return new ResponseEntity<>( new BaseResponse<ResponseActualizarCursoDto>
                    (
                            "0",
                            "Datos del Curso actualizados correctamente",
                            "Datos del Curso actualizados correctamente",
                            _mapperUtil.map(objActualizarCurso,ResponseActualizarCursoDto.class,""),
                            null
                    ),HttpStatus.OK);
        }
    }

    @PostMapping("/eliminarCurso")
    public ResponseEntity<BaseResponse<String>> actualizarCurso(@RequestBody RequestEliminarCursoDto request) throws Exception
    {
        _cursoService.delete(request.getIdCurso());

        return new ResponseEntity<>( new BaseResponse<String>
                (
                        "0",
                        "El Curso fue eliminado correctamente",
                        "El Curso fue eliminado correctamente",
                        null,
                        null
                ),HttpStatus.OK);
    }
    
}
