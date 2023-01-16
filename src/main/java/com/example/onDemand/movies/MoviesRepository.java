package com.example.onDemand.movies;

import com.example.onDemand.entities.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MoviesRepository extends JpaRepository<Movies, MovieId>, JpaSpecificationExecutor<Movies>
{
}
