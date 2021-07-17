package com.example.demo.controller;

import com.example.demo.dto.AgendaDto;
import com.example.demo.response.JsonResponse;
import com.example.demo.services.impl.AgendaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Okala III
 */

@Slf4j
@RestController
@RequestMapping("api/agenda")
@CrossOrigin

public class AgendaController {

    @Autowired
    private AgendaService agendaService;


    @PostMapping("/create")
    public ResponseEntity<?> createAgenda(@RequestBody AgendaDto dto){
        System.out.println(dto);
        agendaService.create(dto);
        return new ResponseEntity<>(new JsonResponse("Agenda created Successfully"), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateAgenda(@RequestBody AgendaDto dto){
        System.out.println(dto);
        agendaService.update(dto);
        return new ResponseEntity<>(new JsonResponse("Item Updated"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAgenda(@PathVariable(name = "id") Long id){
        agendaService.delete(id);
        return new ResponseEntity<>(new JsonResponse("Agenda Deleted"), HttpStatus.OK);
    }

    @GetMapping("/get-all")
    public ResponseEntity<?> findAll(){
        log.info("entered....Get all");
        return new ResponseEntity<>(new JsonResponse(agendaService.findAll()), HttpStatus.OK);
    }

 @GetMapping("/get-all/completed")
    public ResponseEntity<?> findAllCompleted(){
        log.info("entered....Get all...completed");
        return new ResponseEntity<>(new JsonResponse(agendaService.findAllCompleted()), HttpStatus.OK);
    }



}
