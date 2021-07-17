package com.example.demo.services.impl;

import com.example.demo.dto.AgendaDto;
import com.example.demo.models.Agenda;
import com.example.demo.repository.AgendaRepository;
import com.example.demo.services.CRUDService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author Okala III
 */

@Service
public class AgendaService implements CRUDService<Agenda, AgendaDto> {

    @Autowired
    private AgendaRepository agendaRepository;

    private Agenda agenda;

    @Override
    public Agenda create(AgendaDto dto) {

        if (dto.getDate().toString().isBlank())
            throw new IllegalArgumentException("Invalid Agenda Date");

        if (dto.getDetails().isBlank())
            throw new IllegalArgumentException("Details field can not be empty");

        if (dto.getName().isBlank())
            throw new IllegalArgumentException("Name field can not be empty");

        if (dto.getTitle().isBlank())
            throw new IllegalArgumentException("title field can not be empty");
        agenda = new Agenda();
        BeanUtils.copyProperties(dto, agenda);

        Agenda savedAgenda = agendaRepository.save(agenda);
        return savedAgenda;

    }

    @Override
    public List<Agenda> create(List<AgendaDto> dto) {
        return null;
    }

    @Override
    public Agenda update(AgendaDto dto) {
        if (dto.getId() == null || dto.getId() == 0)
            throw new IllegalArgumentException("Invalid Agenda Id");
        
        if (!agendaRepository.existsById(dto.getId())) 
            throw new NoSuchElementException("Invalid Agenda ID");
        
        if (dto.getDate().toString().isBlank())
            throw new IllegalArgumentException("Invalid Agenda Date");

        if (dto.getDetails().isBlank())
            throw new IllegalArgumentException("Details field can not be empty");

        if (dto.getName().isBlank())
            throw new IllegalArgumentException("Name field can not be empty");

        if (dto.getTitle().isBlank())
            throw new IllegalArgumentException("title field can not be empty");

        agenda = agendaRepository.findById(dto.getId()).orElseThrow(() -> new IllegalArgumentException("Invalid Agenda Id"));
        BeanUtils.copyProperties(dto, agenda);

        Agenda updatedAgenda = agendaRepository.save(agenda);
        return updatedAgenda;
    }

    @Override
    public List<Agenda> update(List<AgendaDto> dto) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        if (!agendaRepository.existsById(id)) {
            throw new NoSuchElementException("Invalid Agenda Id");
        }
        agendaRepository.deleteById(id);
        return true;
    }

    @Override
    public List<Agenda> findAll() {
        return agendaRepository.findAll();
    }

    @Override
    public Agenda findById(long id) {
        if (id <= 0 )
            throw new IllegalArgumentException("Invalid Agenda Id");

        if (!agendaRepository.existsById(id))
            throw new NoSuchElementException("Invalid Agenda ID");
        return agendaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("invalid Agenda Id"));
    }

    public List<Agenda> findAllCompleted() {
        return agendaRepository.findByIsCompletedTrue();
    }
}
