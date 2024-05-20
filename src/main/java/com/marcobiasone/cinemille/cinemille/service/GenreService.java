package com.marcobiasone.cinemille.cinemille.service;

import com.marcobiasone.cinemille.cinemille.dtos.GenreDTO;
import com.marcobiasone.cinemille.cinemille.entities.Genre;
import com.marcobiasone.cinemille.cinemille.exceptions.GenreException;

import java.util.List;
public interface GenreService {

    /**
     * Save a genre.
     *
     * @param genreDTO the entity to save.
     * @return the persisted entity.
     */
    Genre save(GenreDTO genreDTO) throws GenreException;

    /**
     * Get the "id" genre.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Genre findOne(Long id);

    /**
     * Get the "name" genre.
     *
     * @param name the id of the entity.
     * @return the entity.
     */
    Genre findByName(String name);

    /**
     * Delete the "id" genre.
     *
     * @param id the id of the entity.
     */
    void delete(Long id) throws GenreException;

    /**
     * Partially updates a genre.
     *
     * @param id the entity id to update.
     * @param genreDTO the entity to update.
     * @return the persisted entity.
     */
    Genre update(Long id, GenreDTO genreDTO) throws GenreException;

    /**
     * Get all the genres.
     *
     * @return the list of entities.
     */
    List<Genre> findAll();
}
