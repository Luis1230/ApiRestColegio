package com.colegio.rest.apirestcolegio.services;

import com.colegio.rest.apirestcolegio.models.Estudiante;
import com.colegio.rest.apirestcolegio.services.impl.ICRUD;

import java.util.List;

public interface IEstudianteService extends ICRUD<Estudiante,Integer> {

    List<Estudiante> findByOrderByEdadDesc();
    List<Estudiante> estudiantesPorEdad();
}
