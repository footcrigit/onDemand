package com.example.onDemand.movies;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MoviesController
{
    @Autowired
    MoviesService moviesService;

    @Operation(description = "This method to add movies details")
    @PostMapping(path = "v1/add/movies", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MoviesResponseView> addMoviesDetails(@RequestBody MovieRequestView movieRequestView)
    {
        MoviesResponseView moviesResponseView = moviesService.addMovies(movieRequestView);
        return ResponseEntity.ok(moviesResponseView);
    }
}
