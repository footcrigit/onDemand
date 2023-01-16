package com.example.onDemand.movies;

import com.example.onDemand.entities.Movies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MoviesService
{
    @Autowired
    MoviesRepository moviesRepository;

    public MoviesResponseView addMovies(MovieRequestView movieRequestView)
    {
        MovieId movieId = new MovieId(UUID.randomUUID());
        Movies movies = new Movies(movieId,
                movieRequestView.moviesName,
                movieRequestView.releaseYear,
                movieRequestView.rating);
        Movies moviesResponse = moviesRepository.saveAndFlush(movies);
        MoviesResponseView moviesResponseView = new MoviesResponseView(
                moviesResponse.getMovieId().getValue(),
                moviesResponse.getMovieName(),
                moviesResponse.getReleaseYear(),
                moviesResponse.getRating()
        );
        return moviesResponseView;
    }
}
