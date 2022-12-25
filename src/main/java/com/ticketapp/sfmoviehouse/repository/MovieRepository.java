package com.ticketapp.sfmoviehouse.repository;

import com.ticketapp.sfmoviehouse.entity.Movie;
import com.ticketapp.sfmoviehouse.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findAllByTitle(String title);
    List<Movie> findAllByYear(String year);
    List<Movie> findAllByCategory(String category);

}
