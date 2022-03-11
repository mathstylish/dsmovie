package com.devsuperior.dsmovie.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_score")
public class Score {

    @EmbeddedId
    private ScoreId id;
    private Double value;

    public Score() {
    }

    public Score(ScoreId id, Double value) {
        this.id = id;
        this.value = value;
    }

    public ScoreId getId() {
        return id;
    }

    public Double getValue() {
        return value;
    }
}
