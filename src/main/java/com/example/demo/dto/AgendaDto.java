package com.example.demo.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author Okala III
 */

@Data
public class AgendaDto {

    private Long id;

    private String name;

    private String title;


    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE, pattern = "yyyy-MM-dd")
    private LocalDate date;

    private String details;

    private Boolean isCompleted ;



}
