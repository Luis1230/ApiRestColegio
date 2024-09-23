package com.colegio.rest.apirestcolegio.services;

import com.colegio.rest.apirestcolegio.models.Curso;
import com.colegio.rest.apirestcolegio.models.Estudiante;
import com.colegio.rest.apirestcolegio.models.Matricula;
import com.colegio.rest.apirestcolegio.models.MatriculaDetalle;
import com.colegio.rest.apirestcolegio.repository.IMatriculaRepository;
import com.colegio.rest.apirestcolegio.repository.generic.IGenericRepository;
import com.colegio.rest.apirestcolegio.services.impl.CRUD;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class MatriculaService extends CRUD<Matricula,Integer> implements IMatriculaService {

    private final IMatriculaRepository _matriculaRepository;

    @Override
    protected IGenericRepository<Matricula, Integer> _repository() {
        return _matriculaRepository;
    }


    @Override
    public Map<String,List<String>> obtenerAlumnosMatriculadosPorCurso() {

        List<Matricula> matriculaList = _matriculaRepository.findAll();

        Map<String,List<String>> cursosEstudiante = matriculaList.stream()
                .flatMap(matricula -> matricula.getMatriculaDetalle().stream())
                .collect(Collectors.groupingBy(curso -> curso.getCurso().getNombre()
                        ,Collectors.mapping(
                                detalle -> detalle.getMatricula().getEstudiante().getNombres() + " " + detalle.getMatricula().getEstudiante().getApellidos()
                                ,Collectors.toList()
                        )));

        return cursosEstudiante;
    }
}
