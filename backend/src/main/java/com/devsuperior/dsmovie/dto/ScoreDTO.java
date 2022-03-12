package com.devsuperior.dsmovie.dto;

public class ScoreDTO {
    private final Long movieId;
    private final String email;
    private final double score;

    public ScoreDTO(Long movieId, String email, double score) {
        this.movieId = movieId;
        this.email = email;
        this.score = score;
    }

    public Long getMovieId() {
        return movieId;
    }

    public String getEmail() {
        return email;
    }

    public double getScore() {
        return score;
    }
}
