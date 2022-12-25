package com.ticketapp.sfmoviehouse.repository;

import com.ticketapp.sfmoviehouse.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findAllByTitle(String title);
    List<Movie> findAllByYear(String year);
    List<Movie> findAllByCategory(String category);
}
