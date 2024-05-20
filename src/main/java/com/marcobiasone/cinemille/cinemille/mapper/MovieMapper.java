package com.marcobiasone.cinemille.cinemille.mapper;

import com.marcobiasone.cinemille.cinemille.dtos.MovieDTO;
import com.marcobiasone.cinemille.cinemille.entities.Actor;
import com.marcobiasone.cinemille.cinemille.entities.Genre;
import com.marcobiasone.cinemille.cinemille.entities.Movie;
import com.marcobiasone.cinemille.cinemille.exceptions.MovieException;
import com.marcobiasone.cinemille.cinemille.service.ActorService;
import com.marcobiasone.cinemille.cinemille.service.GenreService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class MovieMapper {

    private final Logger log = LoggerFactory.getLogger(MovieMapper.class);
    private final ModelMapper modelMapper;

    private final ActorMapper actorMapper;

    private final GenreMapper genreMapper;

    private final ActorService actorService;
    private final GenreService genreService;

    public Movie toEntity(MovieDTO movieDTO) throws MovieException {
        log.info("Mapping Movie DTO to entity");
        try{
            Movie toReturn = modelMapper.map(movieDTO,Movie.class);
            List<Actor> actorsToSet = new ArrayList<>();
            List<Genre> genresToSet = new ArrayList<>();
            movieDTO.getActorNames().forEach(
                    actorName -> actorsToSet.add(actorService.findByName(actorName))

            );
            movieDTO.getAllGenres().forEach(
                    genre -> genresToSet.add(genreService.findByName(genre))
            );
            if(!actorsToSet.isEmpty()){
                toReturn.setActors(actorsToSet);
            }
            if(!genresToSet.isEmpty()){
                toReturn.setGenres(genresToSet);
            }
            return toReturn;
        } catch (Exception e){
            log.error("Error while mapping movieDTO into entity : %s",e);
            throw new MovieException("Error occurred while converting DTO to Entity.");
        } finally {
            log.info("Getting out from movie mapper");
        }
    }


    public MovieDTO fromEntitytoDTO(Movie movie) throws MovieException {
        log.info("Request to map movie entity to DTO");
        try{
            MovieDTO toReturn = modelMapper.map(movie,MovieDTO.class);
            List<String> actors = new ArrayList<>();
            List<String> genres = new ArrayList<>();
            movie.getActors().forEach(
                    actor -> actors.add(actorMapper.fromEntityToName(actor))
            );
            movie.getGenres().forEach(
                    genre -> genres.add(genreMapper.fromEntityToName(genre))
            );
            toReturn.setActorNames(actors);
            toReturn.setAllGenres(genres);
            toReturn.setHasExpired(movie.getOnAirTo().before(Date.valueOf(LocalDate.now())));
            return toReturn;
        } catch (Exception e){
            log.error("Error while mapping movie into DTO : %s",e);
            throw new MovieException("Error while mapping Movie into DTO");
        } finally {
            log.info("Getting out from entity model into DTO");
        }
    }
}
