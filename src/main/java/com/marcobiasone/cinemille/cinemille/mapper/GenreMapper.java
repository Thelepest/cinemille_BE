package com.marcobiasone.cinemille.cinemille.mapper;


import com.marcobiasone.cinemille.cinemille.entities.Genre;
import org.springframework.stereotype.Service;

@Service
public class GenreMapper {


    public String fromEntityToName(Genre genre) {
        return genre.getName();
    }
}
