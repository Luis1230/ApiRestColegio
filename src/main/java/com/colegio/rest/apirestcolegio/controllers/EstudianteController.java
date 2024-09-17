package com.colegio.rest.apirestcolegio.controllers;

import com.colegio.rest.apirestcolegio.dto.BaseResponse;
import com.colegio.rest.apirestcolegio.dto.estudiante.ObtenerEstudiante.RequestObtenerEstudianteDto;
import com.colegio.rest.apirestcolegio.dto.estudiante.ObtenerEstudiante.ResponseObtenerEstudianteDto;
import com.colegio.rest.apirestcolegio.dto.estudiante.actualizarEstudiante.RequestActualizarEstudianteDto;
import com.colegio.rest.apirestcolegio.dto.estudiante.actualizarEstudiante.ResponseActualizarEstudianteDto;
import com.colegio.rest.apirestcolegio.dto.estudiante.eliminarEstudiante.RequestEliminarEstudianteDto;
import com.colegio.rest.apirestcolegio.dto.estudiante.guardarEstudiante.RequestGuardarEstudianteDto;
import com.colegio.rest.apirestcolegio.dto.estudiante.guardarEstudiante.ResponseGuardarEstudianteDto;
import com.colegio.rest.apirestcolegio.dto.estudiante.listarEstudiante.ResponseListarEstudianteDto;
import com.colegio.rest.apirestcolegio.mapper.MapperUtil;
import com.colegio.rest.apirestcolegio.models.Estudiante;
import com.colegio.rest.apirestcolegio.services.IEstudianteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
@RequiredArgsConstructor
public class EstudianteController {

    private final IEstudianteService _estudianteService;
    private final MapperUtil _mapperUtil;

    @GetMapping
    public ResponseEntity<BaseResponse<ResponseListarEstudianteDto>> listarEstudiante() throws Exception
    {
        List<Estudiante> objEstudiante = _estudianteService.findAll();

        return new ResponseEntity<>( new BaseResponse<ResponseListarEstudianteDto>
                (
                        "0",
                        "Consulta ejecutada con exito",
                        "Consulta ejecutada con exito",
                        null,
                        _mapperUtil.mapList(objEstudiante,ResponseListarEstudianteDto.class,"")
                ),HttpStatus.OK);
    }

    @PostMapping("/obtenerEstudiante")
    public ResponseEntity<BaseResponse<ResponseObtenerEstudianteDto>> obtenerEstudiante(@RequestBody RequestObtenerEstudianteDto request) throws Exception
    {
        Estudiante objEstudiante = _mapperUtil.map(request,Estudiante.class,"");
        objEstudiante = _estudianteService.findById(objEstudiante.getIdEstudiante());

        if (objEstudiante == null) {
            return new ResponseEntity<>( new BaseResponse<ResponseObtenerEstudianteDto>
                    (
                            "E001",
                            "El usuario consultado no existe",
                            "El usuario consultado no existe",
                            null,
                            null
                    ),HttpStatus.BAD_REQUEST);
        }
        else
        {
            return new ResponseEntity<>( new BaseResponse<ResponseObtenerEstudianteDto>
                    (
                            "0",
                            "Consulta ejecutada con exito",
                            "Consulta ejecutada con exito",
                            _mapperUtil.map(objEstudiante,ResponseObtenerEstudianteDto.class,""),
                            null
                    ),HttpStatus.OK);
        }
    }

    @PostMapping("/guardarEstudiante")
    public ResponseEntity<BaseResponse<ResponseGuardarEstudianteDto>> guardarEstudiante(@RequestBody RequestGuardarEstudianteDto request) throws Exception
    {
        Estudiante objEstudiante = _mapperUtil.map(request,Estudiante.class,"");
        objEstudiante = _estudianteService.save(objEstudiante);

        if (objEstudiante == null) {
            return new ResponseEntity<>( new BaseResponse<ResponseGuardarEstudianteDto>
                    (
                            "E002",
                            "Ocurrio un error al guardar el estudiante",
                            "Ocurrio un error al guardar el estudiante",
                            null,
                            null
                    ),HttpStatus.BAD_REQUEST);
        }
        else
        {
            return new ResponseEntity<>( new BaseResponse<ResponseGuardarEstudianteDto>
                    (
                            "0",
                            "Estudiante guardado con exito",
                            "Estudiante guardado con exito",
                            _mapperUtil.map(objEstudiante,ResponseGuardarEstudianteDto.class,""),
                            null
                    ),HttpStatus.OK);
        }
    }

    @PostMapping("/actualizarEstudiante")
    public ResponseEntity<BaseResponse<ResponseActualizarEstudianteDto>> actualizarEstudiante(@RequestBody RequestActualizarEstudianteDto request) throws Exception
    {
        Estudiante objEstudiante = _estudianteService.findById(request.getIdEstudiante());

        if (objEstudiante == null)
        {
            return new ResponseEntity<>( new BaseResponse<ResponseActualizarEstudianteDto>
                    (
                            "E003",
                            "El estudiante no existe",
                            "El estudiante no existe",
                            null,
                            null
                    ),HttpStatus.BAD_REQUEST);
        }
        else
        {
            Estudiante objActualizarEstudiante = _mapperUtil.map(request,Estudiante.class,"");
            objActualizarEstudiante = _estudianteService.update(objActualizarEstudiante.getIdEstudiante(),objActualizarEstudiante);

            return new ResponseEntity<>( new BaseResponse<ResponseActualizarEstudianteDto>
                    (
                            "0",
                            "Datos del estudiante actualizados correctamente",
                            "Datos del estudiante actualizados correctamente",
                            _mapperUtil.map(objActualizarEstudiante,ResponseActualizarEstudianteDto.class,""),
                            null
                    ),HttpStatus.OK);
        }
    }
  
    @PostMapping("/eliminarEstudiante")
    public ResponseEntity<BaseResponse<String>> actualizarEstudiante(@RequestBody RequestEliminarEstudianteDto request) throws Exception
    {
        Estudiante objEstudiante = _estudianteService.findById(request.getIdEstudiante());

        if (objEstudiante == null)
        {
            return new ResponseEntity<>( new BaseResponse<String>
                    (
                            "E004",
                            "El estudiante no existe",
                            "El estudiante no existe",
                            null,
                            null
                    ),HttpStatus.BAD_REQUEST);
        }
        else
        {
            boolean eliminar =  _estudianteService.delete(request.getIdEstudiante());

            return new ResponseEntity<>( new BaseResponse<String>
                    (
                            "0",
                            "El estudiante fue eliminado correctamente",
                            "El estudiante fue eliminado correctamente",
                            null,
                            null
                    ),HttpStatus.OK);
        }
    }

    // Obteniendo los estudiantes ordenados de forma descendente por edad -- DerivedQueries
    @GetMapping("/DerivedQueriesEdadDesc")
    public ResponseEntity<BaseResponse<ResponseListarEstudianteDto>> DerivedQueriesEdadDesc() throws Exception
    {
        List<Estudiante> objEstudiante = _estudianteService.findByOrderByEdadDesc();

        return new ResponseEntity<>( new BaseResponse<ResponseListarEstudianteDto>
                (
                        "0",
                        "Consulta ejecutada con exito",
                        "Consulta ejecutada con exito",
                        null,
                        _mapperUtil.mapList(objEstudiante,ResponseListarEstudianteDto.class,"")
                ),HttpStatus.OK);
    }

    // Obteniendo los estudiantes ordenados de forma descendente por edad -- programacion funcional
    @GetMapping("/ProgFuncionalEdadDesc")
    public ResponseEntity<BaseResponse<ResponseListarEstudianteDto>> ProgFuncionalEdadDesc() throws Exception
    {
        List<Estudiante> objEstudiante = _estudianteService.estudiantesPorEdad();

        return new ResponseEntity<>( new BaseResponse<ResponseListarEstudianteDto>
                (
                        "0",
                        "Consulta ejecutada con exito",
                        "Consulta ejecutada con exito",
                        null,
                        _mapperUtil.mapList(objEstudiante,ResponseListarEstudianteDto.class,"")
                ),HttpStatus.OK);
    }
}
