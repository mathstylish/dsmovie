package com.devsuperior.dsmovie.services;

import com.devsuperior.dsmovie.dto.MovieDTO;
import com.devsuperior.dsmovie.entities.Movie;
import com.devsuperior.dsmovie.repositories.MovieRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class MovieService {

    private final MovieRepository repository;

    public MovieService(MovieRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public Page<MovieDTO> findAll(Pageable pageable) {
        final Page<Movie> movies = repository.findAll(pageable);
        return movies.map(movie -> new MovieDTO(movie));
    }

    @Transactional(readOnly = true)
    public MovieDTO findById(@PathVariable Long id) {
        final Movie movie = this.repository.findById(id).get();
        return new MovieDTO(movie);
    }
}
