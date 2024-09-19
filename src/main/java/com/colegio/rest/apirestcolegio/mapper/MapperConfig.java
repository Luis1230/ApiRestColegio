package com.colegio.rest.apirestcolegio.mapper;

import com.colegio.rest.apirestcolegio.dto.matricula.guardarMatricula.RequestGuardarMatriculaDetalleDto;
import com.colegio.rest.apirestcolegio.dto.matricula.guardarMatricula.RequestGuardarMatriculaDto;
import com.colegio.rest.apirestcolegio.dto.matricula.guardarMatricula.ResponseGuardarMatriculaDetalleDto;
import com.colegio.rest.apirestcolegio.dto.matricula.guardarMatricula.ResponseGuardarMatriculaDto;
import com.colegio.rest.apirestcolegio.dto.matricula.listarMatricula.ResponseListarMatriculaDetalleDto;
import com.colegio.rest.apirestcolegio.dto.matricula.listarMatricula.ResponseListarMatriculaDto;
import com.colegio.rest.apirestcolegio.models.Matricula;
import com.colegio.rest.apirestcolegio.models.MatriculaDetalle;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean("defaultMapper")
    public ModelMapper defaultMapper()
    {
        return new ModelMapper();
    }

    @Bean("listarMatriculaMapper")
    public ModelMapper listarMatriculaMapper()
    {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        mapper.createTypeMap(Matricula.class, ResponseListarMatriculaDto.class)
                .addMapping(src -> src.getEstudiante().getNombres(),ResponseListarMatriculaDto::setNombresEstudiante)
                .addMapping(src -> src.getEstudiante().getApellidos(),ResponseListarMatriculaDto::setApellidosEstudiante)
                .addMapping(Matricula::isEstado,ResponseListarMatriculaDto::setEstadoMatricula);

        mapper.createTypeMap(MatriculaDetalle.class, ResponseListarMatriculaDetalleDto.class)
                .addMapping(src -> src.getCurso().getNombre(),ResponseListarMatriculaDetalleDto::setNombreCurso)
                .addMapping(src -> src.getCurso().getSiglas(),ResponseListarMatriculaDetalleDto::setSiglasCurso);

        return mapper;
    }

    @Bean("requestGuardarMatriculaMapper")
    public ModelMapper requestGuardarMatriculaMapper()
    {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        mapper.createTypeMap(RequestGuardarMatriculaDto.class, Matricula.class)
                .addMapping(src -> src.getIdEstudiante(),(dest,v) -> dest.getEstudiante().setIdEstudiante((Integer) v))
                .addMapping(src -> src.getFechamatricula(),Matricula::setFechamatricula)
                .addMapping(RequestGuardarMatriculaDto::isEstadoMatricula,Matricula::setEstado);


        mapper.createTypeMap(RequestGuardarMatriculaDetalleDto.class, MatriculaDetalle.class)
                .addMapping(src -> src.getAula(),MatriculaDetalle::setAula)
                .addMapping(src -> src.getIdCurso(),(dest,v) -> dest.getCurso().setIdCurso((Integer) v));


        return mapper;
    }

    @Bean("responseGuardarMatriculaMapper")
    public ModelMapper responseGuardarMatriculaMapper()
    {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        mapper.createTypeMap(Matricula.class, ResponseGuardarMatriculaDto.class)
                .addMapping(src -> src.getEstudiante().getNombres(),ResponseGuardarMatriculaDto::setNombresEstudiante)
                .addMapping(src -> src.getEstudiante().getApellidos(),ResponseGuardarMatriculaDto::setApellidosEstudiante)
                .addMapping(Matricula::isEstado,ResponseGuardarMatriculaDto::setEstadoMatricula);

        mapper.createTypeMap(MatriculaDetalle.class, ResponseGuardarMatriculaDetalleDto.class)
                .addMapping(src -> src.getCurso().getNombre(),ResponseGuardarMatriculaDetalleDto::setNombreCurso)
                .addMapping(src -> src.getCurso().getSiglas(),ResponseGuardarMatriculaDetalleDto::setSiglasCurso);

        return mapper;
    }

}
