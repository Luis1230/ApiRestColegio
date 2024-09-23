package com.colegio.rest.apirestcolegio.services;

import com.colegio.rest.apirestcolegio.models.Curso;
import com.colegio.rest.apirestcolegio.models.Estudiante;
import com.colegio.rest.apirestcolegio.models.Matricula;
import com.colegio.rest.apirestcolegio.models.MatriculaDetalle;
import com.colegio.rest.apirestcolegio.services.impl.ICRUD;

import java.util.List;
import java.util.Map;

public interface IMatriculaService extends ICRUD<Matricula,Integer> {

    Map<String,List<String>> obtenerAlumnosMatriculadosPorCurso();

}
