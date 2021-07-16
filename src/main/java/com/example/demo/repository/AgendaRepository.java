package com.example.demo.repository;

import com.example.demo.models.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Okala III
 */

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Long> {
    @Override
    @Query("SELECT a FROM Agenda a ORDER BY timeCreated DESC")
    List<Agenda> findAll();

    List<Agenda> findByIsCompletedTrue();
}
