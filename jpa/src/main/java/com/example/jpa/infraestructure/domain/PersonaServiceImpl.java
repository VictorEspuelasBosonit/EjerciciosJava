package com.example.jpa.infraestructure.domain;

import com.example.jpa.infraestructure.dto.input.UsuarioInputDto;
import com.example.jpa.infraestructure.dto.output.UsuarioOutputDto;
import com.example.jpa.infraestructure.repository.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class PersonaServiceImpl implements PersonaService{
    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    @Override
    public List<UsuarioOutputDto> getAll() {
        List<Usuario> usuarioList = usuarioRepositorio.findAll();
        List<UsuarioOutputDto> usuarioOutputDtoList = new ArrayList<>();
        for (Usuario uaxu : usuarioList) {
            UsuarioOutputDto usuarioOutputDto = new UsuarioOutputDto();
            usuarioOutputDto.setActive(uaxu.getActive());
            usuarioOutputDto.setCity(uaxu.getCity());
            usuarioOutputDto.setCompany_email(uaxu.getCompany_email());
            usuarioOutputDto.setName(uaxu.getName());
            usuarioOutputDto.setSurname(uaxu.getSurname());
            usuarioOutputDto.setUser(uaxu.getUser());
            usuarioOutputDto.setPersonal_email(uaxu.getPersonal_email());
            usuarioOutputDto.setPassword(uaxu.getPassword());
            usuarioOutputDto.setCreated_date(uaxu.getCreated_date());
            usuarioOutputDtoList.add(usuarioOutputDto);
        }
        return usuarioOutputDtoList;
    }

    @Override
    public UsuarioOutputDto getById(Integer id) throws Exception {
        Usuario usuario = usuarioRepositorio.findById(id).orElseThrow(() -> new Exception("No encontrado"));
        UsuarioOutputDto usuarioOutputDto = new UsuarioOutputDto();
        usuarioOutputDto.setActive(usuario.getActive());
        usuarioOutputDto.setCity(usuario.getCity());
        usuarioOutputDto.setCompany_email(usuario.getCompany_email());
        usuarioOutputDto.setName(usuario.getName());
        usuarioOutputDto.setSurname(usuario.getSurname());
        usuarioOutputDto.setUser(usuario.getUser());
        usuarioOutputDto.setPersonal_email(usuario.getPersonal_email());
        usuarioOutputDto.setPassword(usuario.getPassword());
        usuarioOutputDto.setCreated_date(usuario.getCreated_date());
        return usuarioOutputDto;
    }

    @Override
    public List<UsuarioOutputDto> getByName(String name) throws Exception {
        List<Usuario> usuarioList = usuarioRepositorio.getByName(name);
        //Preguntar como hacer con streams
        List<UsuarioOutputDto> usuarioOutputDtoList = new ArrayList<>();
        for (Usuario uaxu : usuarioList) {
            UsuarioOutputDto usuarioOutputDto = new UsuarioOutputDto();
            usuarioOutputDto.setActive(uaxu.getActive());
            usuarioOutputDto.setCity(uaxu.getCity());
            usuarioOutputDto.setCompany_email(uaxu.getCompany_email());
            usuarioOutputDto.setName(uaxu.getName());
            usuarioOutputDto.setSurname(uaxu.getSurname());
            usuarioOutputDto.setUser(uaxu.getUser());
            usuarioOutputDto.setPersonal_email(uaxu.getPersonal_email());
            usuarioOutputDto.setPassword(uaxu.getPassword());
            usuarioOutputDto.setCreated_date(uaxu.getCreated_date());
            usuarioOutputDtoList.add(usuarioOutputDto);
        }
        return usuarioOutputDtoList;
    }

    @Override
    public UsuarioOutputDto addUsuario(UsuarioInputDto u) {
        Usuario usuario = new Usuario(u);
        usuarioRepositorio.saveAndFlush(usuario);
        UsuarioOutputDto usuarioOutputDto = new UsuarioOutputDto(usuario);
        return usuarioOutputDto;
    }

    @Override
    public UsuarioOutputDto updateById(Integer id, UsuarioInputDto u) throws Exception {
        Usuario usuario = usuarioRepositorio.findById(id).orElseThrow(() -> new Exception("No encontrado"));
        if (usuario != null) {
            usuario.setActive(u.getActive());
            usuario.setCity(u.getCity());
            usuario.setCompany_email(u.getCompany_email());
            usuario.setName(u.getName());
            usuario.setSurname(u.getSurname());
            usuario.setUser(u.getUser());
            usuario.setPersonal_email(u.getPersonal_email());
            usuario.setPassword(u.getPassword());
            usuario.setCreated_date(u.getCreated_date());
        }
        usuarioRepositorio.saveAndFlush(usuario);

        UsuarioOutputDto usuarioOutputDto = new UsuarioOutputDto();
        usuarioOutputDto.setActive(usuario.getActive());
        usuarioOutputDto.setCity(usuario.getCity());
        usuarioOutputDto.setCompany_email(usuario.getCompany_email());
        usuarioOutputDto.setName(usuario.getName());
        usuarioOutputDto.setSurname(usuario.getSurname());
        usuarioOutputDto.setUser(usuario.getUser());
        usuarioOutputDto.setPersonal_email(usuario.getPersonal_email());
        usuarioOutputDto.setPassword(usuario.getPassword());
        usuarioOutputDto.setCreated_date(usuario.getCreated_date());
        return usuarioOutputDto;
    }

    @Override
    public void deleteUsuarioById(Integer id) {
        usuarioRepositorio.delete(usuarioRepositorio.getById(id));
    }
}
