package com.example.demo.services.impl;

import com.example.demo.dto.AgendaDto;
import com.example.demo.models.Agenda;
import com.example.demo.repository.AgendaRepository;
import com.example.demo.services.CRUDService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        //todo validate objects
        agenda = new Agenda();
        BeanUtils.copyProperties(dto,agenda);

        Agenda savedAgenda = agendaRepository.save(agenda);
        return savedAgenda;

    }

    @Override
    public List<Agenda> create(List<AgendaDto> d) {
        return null;
    }

    @Override
    public Agenda update(AgendaDto d) {
        //todo validate objects
        agenda = agendaRepository.findById(d.getId()).orElseThrow(()-> new IllegalArgumentException("Invalid Agenda Id"));
        BeanUtils.copyProperties(d,agenda);

        Agenda updatedAgenda = agendaRepository.save(agenda);
        return updatedAgenda;
    }

    @Override
    public List<Agenda> update(List<AgendaDto> d) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
            // todo check if Id exist
    agendaRepository.deleteById(id);
    return true;
    }

    @Override
    public List<Agenda> findAll() {
        return agendaRepository.findAll();
    }

    @Override
    public Agenda findById(long id) {
        return agendaRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("invalid Agenda Id"));
    }

    public List<Agenda> findAllCompleted() {
        return agendaRepository.findByIsCompletedTrue();
    }
}
