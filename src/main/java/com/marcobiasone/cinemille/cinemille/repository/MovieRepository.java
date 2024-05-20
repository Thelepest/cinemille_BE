package com.marcobiasone.cinemille.cinemille.repository;

import com.marcobiasone.cinemille.cinemille.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {

    List<Movie> findByOnAirToBetween(Date startDate, Date endDate);

    List<Movie> findByOnAirToBefore(Date beforeDate);
}
