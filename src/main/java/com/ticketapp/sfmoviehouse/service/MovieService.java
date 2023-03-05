package com.ticketapp.sfmoviehouse.service;

import com.ticketapp.sfmoviehouse.dto.MovieDTO;
import com.ticketapp.sfmoviehouse.exception.RecordNotFoundException;
import com.ticketapp.sfmoviehouse.entity.Movie;
import com.ticketapp.sfmoviehouse.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<MovieDTO> findAllMovies() {
        List<Movie> movieList = movieRepository.findAll();
        List<MovieDTO> MovieDTOList = movieList.stream().map(MovieDTO::fromMovie)
                .collect(Collectors.toList());
        return MovieDTOList;
    }

    public List<MovieDTO> findAllMoviesByTitle(String title) {
        List<Movie> movieList = movieRepository.findAllByTitle(title);
        List<MovieDTO> MovieDTOLIst = movieList.stream().map(MovieDTO::fromMovie)
                .collect(Collectors.toList());
        return MovieDTOLIst;
    }


    public List<MovieDTO> findAllMoviesByYear(String year) {
        List<Movie> movieList = movieRepository.findAllByYear(year);
        List<MovieDTO> MovieDTOList = movieList.stream().map(MovieDTO::fromMovie)
                .collect(Collectors.toList());
        return MovieDTOList;
    }

    public List<MovieDTO> findAllMoviesByCategory(String category) {
        List<Movie> movieList = movieRepository.findAllByCategory(category);
        List<MovieDTO> MovieDTOList = movieList.stream().map(MovieDTO::fromMovie)
                .collect(Collectors.toList());
        return MovieDTOList;
    }

    public MovieDTO findMovieById(long id) {
        Optional<Movie> movieOptional = movieRepository.findById(id);
        if (movieOptional.isPresent()) {
            Movie m = movieOptional.get();
            return MovieDTO.fromMovie(m);
        } else {
            throw new RecordNotFoundException();
        }
    }

    public MovieDTO save(MovieDTO movieDTO) {
        Movie m = movieDTO.toMovie();
        movieRepository.save(m);
        return MovieDTO.fromMovie(m);
    }

    public void deleteById(Long id) {
        Optional<Movie> movieOptional = movieRepository.findById(id);
        if (movieOptional.isPresent()) {
            movieRepository.deleteById(id);
        } else {
            throw new RecordNotFoundException();
        }
    }

    public MovieDTO updateMovie(Long id, MovieDTO toUpdateMovieDTO) {
        Optional<Movie> movieOptional = movieRepository.findById(id);
        if (movieOptional.isPresent()) {
            Movie m = movieRepository.findById(id).orElseThrow();
            m.setTitle(toUpdateMovieDTO.getTitle());
            m.setYear(toUpdateMovieDTO.getYear());
            m.setCategory(toUpdateMovieDTO.getCategory());
            m.setSummary(toUpdateMovieDTO.getSummary());
            m.setDescription(toUpdateMovieDTO.getDescription());
            movieRepository.save(m);

            return MovieDTO.fromMovie(m);

        } else {
            throw new RecordNotFoundException();

        }
    }

}