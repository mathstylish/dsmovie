package com.devsuperior.dsmovie.services;

import com.devsuperior.dsmovie.dto.MovieDTO;
import com.devsuperior.dsmovie.dto.ScoreDTO;
import com.devsuperior.dsmovie.entities.Movie;
import com.devsuperior.dsmovie.entities.Score;
import com.devsuperior.dsmovie.entities.ScoreId;
import com.devsuperior.dsmovie.entities.User;
import com.devsuperior.dsmovie.repositories.MovieRepository;
import com.devsuperior.dsmovie.repositories.ScoreRepository;
import com.devsuperior.dsmovie.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class ScoreService {

    private final UserRepository userRepository;
    private final MovieRepository movieRepository;
    private final ScoreRepository scoreRepository;

    public ScoreService(UserRepository userRepository, MovieRepository movieRepository,
                        ScoreRepository scoreRepository) {
        this.userRepository = userRepository;
        this.movieRepository = movieRepository;
        this.scoreRepository = scoreRepository;
    }

    @Transactional
    public MovieDTO saveScore(ScoreDTO scoreDTO) {
        User user = userRepository.findByEmail(scoreDTO.getEmail());
        if (user == null) {
            user = new User(scoreDTO.getEmail());
            user = userRepository.saveAndFlush(user);
        }

        Movie movie = movieRepository.findById(scoreDTO.getMovieId()).get();

        Score score = new Score(new ScoreId(user, movie), scoreDTO.getScore());
        score = scoreRepository.saveAndFlush(score);
        final Set<Score> scores = movie.getScores();

        double sum = 0.0;
        for (Score sc : scores) {
            sum += sc.getValue();
        }

        double average = sum / scores.size();

        movie.setScore(average);
        movie.setCount(scores.size());
        movie = movieRepository.save(movie);

        return new MovieDTO(movie);
    }
}
