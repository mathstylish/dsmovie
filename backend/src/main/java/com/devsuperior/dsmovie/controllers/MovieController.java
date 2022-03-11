package com.devsuperior.dsmovie.controllers;

import com.devsuperior.dsmovie.dto.MovieDTO;
import com.devsuperior.dsmovie.services.MovieService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

    private final MovieService service;

    public MovieController(MovieService service) {
        this.service = service;
    }

    @GetMapping
    public Page<MovieDTO> findAll(Pageable pageable) {
        return this.service.findAll(pageable);
    }

    @GetMapping(value = "/{id}")
    public MovieDTO findById(@PathVariable Long id) {
        return this.service.findById(id);
    }
}
