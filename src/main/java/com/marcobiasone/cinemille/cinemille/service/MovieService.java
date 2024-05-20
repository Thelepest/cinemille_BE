package com.marcobiasone.cinemille.cinemille.service;

import com.marcobiasone.cinemille.cinemille.dtos.MovieDTO;
import com.marcobiasone.cinemille.cinemille.entities.Movie;
import com.marcobiasone.cinemille.cinemille.exceptions.MovieException;
import jakarta.persistence.NoResultException;

import java.util.Date;
import java.util.List;

public interface MovieService {

    /**
     * Save a movie.
     *
     * @param movieDTO the entity to save.
     * @return the persisted entity.
     */
    Movie save(MovieDTO movieDTO) throws MovieException;

    /**
     * Get the "id" movie.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Movie findOne(Long id) throws MovieException;

    /**
     * Delete the "id" movie.
     *
     * @param id the id of the entity.
     */
    void delete(Long id) throws MovieException;

    /**
     * Partially updates a movie.
     *
     * @param id the entity id to update.
     * @param movieDTO the entity to update.
     * @return the persisted entity.
     */
    Movie update(Long id, MovieDTO movieDTO) throws MovieException;

    /**
     * Get all the movies.
     *
     * @return the list of entities.
     */
    List<Movie> findAll() throws NoResultException,MovieException;

    /**
     * Get all the movies scheduled between two dates.
     * @param startingDate the given start date.
     * @param endingDate the movie's end date.
     * @return the list of entities.
     */
    List<Movie> findAllOnAirBetweenDates(Date startingDate, Date endingDate) throws MovieException;
    /**
     * Get all the movies already screened before a given date.
     * @param beforeDate the given date.
     * @return the list of entities.
     */
    List<Movie> findAllBeforeDate(Date beforeDate) throws MovieException;
}
