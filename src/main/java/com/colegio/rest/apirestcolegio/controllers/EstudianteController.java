package com.colegio.rest.apirestcolegio.controllers;

import com.colegio.rest.apirestcolegio.models.Estudiante;
import com.colegio.rest.apirestcolegio.services.IEstudianteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
@RequiredArgsConstructor
public class EstudianteController {

    private final IEstudianteService _estudianteService;

    @GetMapping
    public ResponseEntity<List<Estudiante>> listarEstudiante() throws Exception
    {
        return new ResponseEntity<>(_estudianteService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> obtenerEstudiante(@PathVariable("id") Integer id) throws Exception{
        return new ResponseEntity<>(_estudianteService.findById(id), HttpStatus.OK);
    }



    @PostMapping("/guardarEstudiante")
    public ResponseEntity<Estudiante> guardarEstudiante(@RequestBody Estudiante estudiante) throws Exception
    {
        return new ResponseEntity<>(_estudianteService.save(estudiante), HttpStatus.OK);
    }



}
