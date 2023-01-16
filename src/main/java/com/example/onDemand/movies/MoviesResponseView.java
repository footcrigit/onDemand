package com.example.onDemand.movies;

import lombok.Data;

import java.util.UUID;

@Data
public class MoviesResponseView
{
    UUID moviesId;
    String moviesName;
    String releaseYear;
    String rating;

    public MoviesResponseView(UUID moviesId, String moviesName, String releaseYear, String rating) {
        this.moviesId = moviesId;
        this.moviesName = moviesName;
        this.releaseYear = releaseYear;
        this.rating = rating;
    }
}
