package com.marcobiasone.cinemille.cinemille.serviceImpl;

import com.marcobiasone.cinemille.cinemille.dtos.MovieDTO;
import com.marcobiasone.cinemille.cinemille.entities.Movie;
import com.marcobiasone.cinemille.cinemille.exceptions.MovieException;
import com.marcobiasone.cinemille.cinemille.mapper.MovieMapper;
import com.marcobiasone.cinemille.cinemille.repository.MovieRepository;
import com.marcobiasone.cinemille.cinemille.service.MovieService;
import jakarta.persistence.NoResultException;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final Logger log = LoggerFactory.getLogger(MovieServiceImpl.class);

    private final MovieRepository movieRepository;

    private final MovieMapper movieMapper;

    @Override
    public Movie save(MovieDTO movieDTO) throws MovieException {
        log.info("Rest request to Save a Movie {}",movieDTO);
        try{
            return movieRepository.save(movieMapper.toEntity(movieDTO));
        } catch (Exception e){
            log.error("Error while saving movie : %s",e);
            throw new MovieException("Error while saving movie");
        } finally {
            log.info("Getting out from movie save");
        }
    }

    @Override
    public Movie findOne(Long id) throws NoResultException, MovieException {
        log.info("Rest request to find a Movie by id {}",id);
        try{
            return movieRepository.findById(id).get();
        } catch (NoResultException a){
            throw new NoResultException("No movie found with given id");
        }
        catch (Exception e){
            log.error("Error occurred finding movie with given id : %",e);
            throw new MovieException("Error occurred finding movie with given id");
        } finally {
            log.info("Getting out from find a movie");
        }
    }

    @Override
    public void delete(Long id) throws MovieException {
        log.info("Rest request to delete an movie by id {}",id);
        try{
            movieRepository.delete(findOne(id));
        } catch (Exception e){
            log.error("Error while deleting movie : %s",e);
            throw new MovieException("Error while deleting movie.");
        } finally {
            log.info("Getting out from genre deleting");
        }
    }

    @Override
    public Movie update(Long id, MovieDTO movieDTO) throws MovieException {
        return null;
    }

    @Override
    public List<Movie> findAll() throws NoResultException, MovieException{
        log.info("Rest request to find all movies");
        try{
            return movieRepository.findAll();
        } catch (NoResultException a){
            throw new NoResultException("No Movie Found");
        }
        catch (Exception e){
            log.error("Error occurred while finding all movies : %s",e);
            throw new MovieException("Error occurred while finding all movies");
        } finally {
            log.info("Getting out from find a movie");
        }
    }

    @Override
    public List<Movie> findAllOnAirBetweenDates(Date startingDate, Date endingDate) throws MovieException,NoResultException {
        log.info("Rest request to find all movies between {} and {}",startingDate,endingDate);
        try{
            return movieRepository.findByOnAirToBetween(startingDate,endingDate);
        } catch (NoResultException a){
            throw new NoResultException("No result found with given dates");
        }
        catch (Exception e){
            log.error("Error occurred finding all movies between two dates : %s",e);
            throw new MovieException("Error occurred finding all movies between two dates.");
        }
        finally {
            log.info("Getting out from find movies between two dates");
        }
    }

    @Override
    public List<Movie> findAllBeforeDate(Date beforeDate) throws MovieException,NoResultException {
        log.info("Rest request to find all movies before {}",beforeDate);
        try{
            return movieRepository.findByOnAirToBefore(beforeDate);
        } catch (NoResultException a){
            throw new NoResultException("No result found with given date");
        }
        catch (Exception e){
            log.error("Error occurred finding all movies before given date : %s",e);
            throw new MovieException("Error occurred finding all movies before given date");
        }
        finally {
            log.info("Getting out from finding all movies before a date");
        }
    }
}
