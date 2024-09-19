package com.colegio.rest.apirestcolegio.services;

import com.colegio.rest.apirestcolegio.models.Matricula;
import com.colegio.rest.apirestcolegio.repository.IMatriculaRepository;
import com.colegio.rest.apirestcolegio.repository.generic.IGenericRepository;
import com.colegio.rest.apirestcolegio.services.impl.CRUD;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.stream.Collectors;

@Configuration
@RequiredArgsConstructor
public class MatriculaService extends CRUD<Matricula,Integer> implements IMatriculaService {

    private final IMatriculaRepository _matriculaRepository;

    @Override
    protected IGenericRepository<Matricula, Integer> _repository() {
        return _matriculaRepository;
    }
}
