package com.marcobiasone.cinemille.cinemille.serviceImpl;

import com.marcobiasone.cinemille.cinemille.dtos.ActorDTO;
import com.marcobiasone.cinemille.cinemille.entities.Actor;
import com.marcobiasone.cinemille.cinemille.exceptions.ActorException;
import com.marcobiasone.cinemille.cinemille.repository.ActorRepository;
import com.marcobiasone.cinemille.cinemille.service.ActorService;
import jakarta.persistence.NoResultException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
@AllArgsConstructor
public class ActorServiceImpl implements ActorService {

    private final Logger log = LoggerFactory.getLogger(ActorServiceImpl.class);

    private final ActorRepository actorRepository;

    private final ModelMapper modelMapper;

    protected static final String ERR_ACTOR = "Getting out from find actor";

    @Override
    @Transactional
    public Actor save(ActorDTO actorDTO) throws ActorException {
        log.info("Rest request to Save an Actor {}",actorDTO);
        try{
            return actorRepository.save(modelMapper.map(actorDTO,Actor.class));
        } catch (Exception e){
            throw new ActorException("Error while saving actor :"+e);
        } finally {
            log.info("Getting out from actor save");
        }
    }

    @Override
    public Actor findOne(Long id) throws NoResultException {
        log.info("Rest request to find an Actor by id {}",id);
        try{
            return actorRepository.findById(id).get();
        } catch (Exception e){
            throw new NoResultException("No Actor Found with Id "+id);
        } finally {
            log.info(ERR_ACTOR);
        }
    }

    @Override
    public Actor findByName(String name) throws NoResultException{
        log.info("Rest request to find an Actor by name {}",name);
        try{
            return actorRepository.findByName(name).get();
        } catch (Exception e){
            throw new NoResultException("No Actor Found with name "+name);
        } finally {
            log.info(ERR_ACTOR);
        }
    }

    @Override
    public void delete(Long id) throws ActorException {
        log.info("Rest request to delete an Actor by id {}",id);
        try{
            actorRepository.delete(findOne(id));
        } catch (Exception e){
            throw new ActorException("Error while deleting actor :"+e);
        } finally {
            log.info("Getting out from actor deleting");
        }
    }

    @Override
    public Actor update(Long id, ActorDTO actorDTO) throws ActorException {
        log.info("Rest request to update actor id {}",id);
        try{
            Actor toSave = findOne(id);
            toSave.setName(actorDTO.getName());
            return actorRepository.save(toSave);
        } catch (Exception e){
            throw new ActorException("Can't update actor. Error:"+e);
        } finally {
            log.info("Getting out from actor updating");
        }
    }

    @Override
    public List<Actor> findAll() throws NoResultException{
        log.info("Rest request to find all actors");
        try{
            return actorRepository.findAll();
        } catch (Exception e){
            throw new NoResultException("No Actor Found");
        } finally {
            log.info(ERR_ACTOR);
        }
    }
}
