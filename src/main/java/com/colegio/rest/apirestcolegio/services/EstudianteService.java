package com.colegio.rest.apirestcolegio.services;

import com.colegio.rest.apirestcolegio.models.Estudiante;
import com.colegio.rest.apirestcolegio.repository.IEstudianteRepository;
import com.colegio.rest.apirestcolegio.repository.generic.IGenericRepository;
import com.colegio.rest.apirestcolegio.services.impl.CRUD;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EstudianteService extends CRUD<Estudiante,Integer> implements IEstudianteService {

    private final IEstudianteRepository _estudianteRepository;

    @Override
    protected IGenericRepository<Estudiante, Integer> _repository() {
        return _estudianteRepository;
    }
}
