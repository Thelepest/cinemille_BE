package com.marcobiasone.cinemille.cinemille.serviceImpl;

import com.marcobiasone.cinemille.cinemille.dtos.GenreDTO;
import com.marcobiasone.cinemille.cinemille.entities.Genre;
import com.marcobiasone.cinemille.cinemille.exceptions.GenreException;
import com.marcobiasone.cinemille.cinemille.repository.GenreRepository;
import com.marcobiasone.cinemille.cinemille.service.GenreService;
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
public class GenreServiceImpl implements GenreService {

    private final Logger log = LoggerFactory.getLogger(GenreServiceImpl.class);

    private final GenreRepository genreRepository;

    private final ModelMapper modelMapper;

    protected static final String ERR_GENRE = "Getting out from find genre";


    @Override
    @Transactional
    public Genre save(GenreDTO genreDTO) throws GenreException {
        log.info("Rest request to Save a Genre {}",genreDTO);
        try{
            return genreRepository.save(modelMapper.map(genreDTO,Genre.class));
        } catch (Exception e){
            throw new GenreException("Error while saving genre :"+e);
        } finally {
            log.info("Getting out from genre save");
        }
    }

    @Override
    public Genre findOne(Long id) throws NoResultException {
        log.info("Rest request to find a Genre by id {}",id);
        try{
            return genreRepository.findById(id).get();
        } catch (Exception e){
            throw new NoResultException("No Genre Found with Id "+id);
        } finally {
            log.info(ERR_GENRE);
        }
    }

    @Override
    public Genre findByName(String name) throws NoResultException{
        log.info("Rest request to find a Genre by name {}",name);
        try{
            return genreRepository.findByName(name).get();
        } catch (Exception e){
            throw new NoResultException("No Genre Found with name "+name);
        } finally {
            log.info(ERR_GENRE);
        }
    }

    @Override
    public void delete(Long id) throws GenreException {
        log.info("Rest request to delete an Actor by id {}",id);
        try{
            genreRepository.delete(findOne(id));
        } catch (Exception e){
            throw new GenreException("Error while deleting genre :"+e);
        } finally {
            log.info("Getting out from genre deleting");
        }
    }

    @Override
    public Genre update(Long id, GenreDTO genreDTO) throws GenreException {
        log.info("Rest request to update genre id {}",id);
        try{
            Genre toSave = findOne(id);
            toSave.setName(genreDTO.getName());
            return genreRepository.save(toSave);
        } catch (Exception e){
            throw new GenreException("Can't update genre. Error:"+e);
        } finally {
            log.info("Getting out from genre updating");
        }
    }

    @Override
    public List<Genre> findAll() throws NoResultException{
        log.info("Rest request to find all actors");
        try{
            return genreRepository.findAll();
        } catch (Exception e){
            throw new NoResultException("No Genre Found");
        } finally {
            log.info(ERR_GENRE);
        }
    }
}
