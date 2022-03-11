package com.devsuperior.dsmovie.dto;

import com.devsuperior.dsmovie.entities.Movie;

public class MovieDTO {
    private final Long id;
    private final String title;
    private final Double score;
    private final Integer count;
    private final String image;

    public MovieDTO(Movie movie) {
        this.id = movie.getId();
        this.title = movie.getTitle();
        this.score = movie.getScore();
        this.count = movie.getCount();
        this.image = movie.getImage();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Double getScore() {
        return score;
    }

    public Integer getCount() {
        return count;
    }

    public String getImage() {
        return image;
    }
}
