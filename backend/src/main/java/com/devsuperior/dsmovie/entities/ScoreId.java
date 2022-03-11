package com.devsuperior.dsmovie.entities;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class ScoreId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Movie movie;

    public ScoreId() {
    }

    public ScoreId(User user, Movie movie) {
        this.user = user;
        this.movie = movie;
    }

    public User getUser() {
        return user;
    }

    public Movie getMovie() {
        return movie;
    }
}
