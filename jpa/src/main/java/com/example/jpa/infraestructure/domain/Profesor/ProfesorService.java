package com.example.jpa.infraestructure.domain.Profesor;

import com.example.jpa.infraestructure.dto.input.ProfesorInputDto;
import com.example.jpa.infraestructure.dto.output.ProfesorOutputDto;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;


public interface ProfesorService {
    public List<ProfesorOutputDto> getAll();
    public ProfesorOutputDto getById(@PathVariable String id) throws Exception;
    public ProfesorOutputDto addProfesor(@Valid @RequestBody ProfesorInputDto u);
    public ProfesorOutputDto updateById(@PathVariable("id") String id, @Valid @RequestBody ProfesorInputDto u) throws Exception;
    public void deleteProfesorById(@PathVariable("id") String id);

}
