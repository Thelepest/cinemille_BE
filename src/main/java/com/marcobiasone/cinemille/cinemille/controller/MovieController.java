package com.marcobiasone.cinemille.cinemille.controller;

import com.marcobiasone.cinemille.cinemille.dtos.MovieDTO;
import com.marcobiasone.cinemille.cinemille.entities.Movie;
import com.marcobiasone.cinemille.cinemille.exceptions.MovieException;
import com.marcobiasone.cinemille.cinemille.mapper.MovieMapper;
import com.marcobiasone.cinemille.cinemille.service.MovieService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.persistence.NoResultException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/movies")
@AllArgsConstructor
//@CrossOrigin(origins = "http://localhost:4200/**")
public class MovieController {

    private final MovieService movieService;

    private final MovieMapper movieMapper;

    protected static final String ERR_REQUEST = "The request hasn't been received correctly :";

    protected static final String ERR_INTERNAL = "There is a server problem with your request. Try again later";



    @GetMapping
    @Operation(summary = "Get All Movies", description = "This endpoint gets all Movies.")
    public ResponseEntity getAllMovies() {
        try{
            List<Movie> toConvert = movieService.findAll();
            List<MovieDTO> toReturn = new ArrayList<>();
            for (Movie movie : toConvert) {
                toReturn.add(movieMapper.fromEntitytoDTO(movie));
            }
            return ResponseEntity.ok(toReturn);
        } catch (NoResultException e){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No Movie Found");
        }
        catch (MovieException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ERR_REQUEST+e.getMessage());
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ERR_INTERNAL);
        }
    }

    @GetMapping("/expired")
    @Operation(summary = "Get Expired Movies", description = "This method gets all expired Movies.")
    public ResponseEntity getPastMovies(){
        try{
            List<Movie> toCovert = movieService.findAllBeforeDate(Date.valueOf(LocalDate.now()));
            List<MovieDTO> toReturn = new ArrayList<>();
            for(Movie movie : toCovert){
                toReturn.add(movieMapper.fromEntitytoDTO(movie));
            }
            return ResponseEntity.ok(toReturn);
        } catch (NoResultException a){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No Expired movies found");
        }
        catch (MovieException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ERR_REQUEST+e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ERR_INTERNAL);
        }
    }

    @GetMapping("/between/{startDate}/{endDate}")
    @Operation(summary = "Get Scheduled movies", description = "This method gets all Movies scheduled between a given dates range.")
    public ResponseEntity getActiveMoviesBetweeenDates(@PathVariable(value="startDate") String startDate,
                                                       @PathVariable(value="endDate") String endDate){
        try{
            List<Movie> toConvert = movieService.findAllOnAirBetweenDates(Date.valueOf(startDate),Date.valueOf(endDate));
            List<MovieDTO> toReturn = new ArrayList<>();
            for(Movie movie : toConvert){
                toReturn.add(movieMapper.fromEntitytoDTO(movie));
            }
            return ResponseEntity.ok(toReturn);
        }  catch (NoResultException a){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("No movies found between "+startDate+" and "+endDate);
        }
        catch (MovieException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ERR_REQUEST+e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ERR_INTERNAL);
        }
    }
}
