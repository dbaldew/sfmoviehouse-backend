package com.ticketapp.sfmoviehouse.repository;

import com.ticketapp.sfmoviehouse.model.Movie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends CrudRepository <Movie, Long> {

}
