package com.example.jpa.infraestructure.domain.Profesor;

import com.example.jpa.infraestructure.dto.UserNotFoundException;
import com.example.jpa.infraestructure.dto.input.ProfesorInputDto;
import com.example.jpa.infraestructure.dto.output.ProfesorOutputDto;
import com.example.jpa.infraestructure.dto.output.UsuarioOutputDto;
import com.example.jpa.infraestructure.repository.ProfesorRepositorio;
import com.example.jpa.infraestructure.repository.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProfesorServiceImpl implements ProfesorService{

    @Autowired
    ProfesorRepositorio profesorRepositorio;

    @Override
    public List<ProfesorOutputDto> getAll() {
        List<Profesor> profesorList = profesorRepositorio.findAll();
        List<ProfesorOutputDto> profesorOutputDtoList = new ArrayList<>();
        for (Profesor uaxu : profesorList){
            ProfesorOutputDto profesorOutputDto = new ProfesorOutputDto();
            profesorOutputDto.setId_profesor(uaxu.getId_profesor());
            profesorOutputDto.setBranch(uaxu.getBranch());
            profesorOutputDto.setComents(uaxu.getComents());
        }
        return profesorOutputDtoList;
    }

    @Override
    public ProfesorOutputDto getById(String id_profesor) throws Exception {
        Profesor profesor = profesorRepositorio.findById(id_profesor).orElseThrow(() -> new Exception("No encontrado"));;
        ProfesorOutputDto profesorOutputDto = new ProfesorOutputDto();
        profesorOutputDto.setComents(profesor.getComents());
        profesorOutputDto.setId_profesor(profesor.getId_profesor());
        profesorOutputDto.setBranch(profesor.getBranch());
        return profesorOutputDto;
    }

    @Override
    public ProfesorOutputDto addProfesor(ProfesorInputDto u) {
        Profesor profesor = new Profesor(u);
        profesorRepositorio.saveAndFlush(profesor);
        ProfesorOutputDto profesorOutputDto = new ProfesorOutputDto(profesor);
        return profesorOutputDto;
    }

    @Override
    public ProfesorOutputDto updateById(String id, ProfesorInputDto u) throws Exception {
        return null;
    }

    @Override
    public void deleteProfesorById(String id) {

    }
}
