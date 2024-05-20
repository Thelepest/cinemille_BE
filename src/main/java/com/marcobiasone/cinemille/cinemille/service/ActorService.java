package com.marcobiasone.cinemille.cinemille.service;

import com.marcobiasone.cinemille.cinemille.dtos.ActorDTO;
import com.marcobiasone.cinemille.cinemille.entities.Actor;
import com.marcobiasone.cinemille.cinemille.exceptions.ActorException;

import java.util.List;

public interface ActorService {

    /**
     * Save an actor.
     *
     * @param actorDTO the entity to save.
     * @return the persisted entity.
     */
    Actor save(ActorDTO actorDTO) throws ActorException;

    /**
     * Get the "id" actor.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Actor findOne(Long id);

    /**
     * Get the "name" actor.
     *
     * @param name the id of the entity.
     * @return the entity.
     */
    Actor findByName(String name);
    /**
     * Delete the "id" actor.
     *
     * @param id the id of the entity.
     */
    void delete(Long id) throws ActorException;

    /**
     * Partially updates an actor.
     *
     * @param id the entity id to update.
     * @param actorDTO the entity to update.
     * @return the persisted entity.
     */
    Actor update(Long id, ActorDTO actorDTO) throws ActorException;

    /**
     * Get all the actors.
     *
     * @return the list of entities.
     */
    List<Actor> findAll();


}
