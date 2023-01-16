package com.example.onDemand.entities;

import com.example.onDemand.movies.MovieId;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "movies")
@Data
public class Movies
{
    @EmbeddedId
    MovieId movieId;

    @Column(name = "movie_name")
    String movieName;

    @Column(name = "release_year")
    String releaseYear;

    @Column(name = "rating")
    String rating;

    public Movies(MovieId movieId, String movieName, String releaseYear, String rating) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.releaseYear = releaseYear;
        this.rating = rating;
    }
}
