package com.marcobiasone.cinemille.cinemille.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MovieDTO {

    @NotNull
    private String name;

    private Date onAirFrom;

    private Date onAirTo;

    private List<String> actorNames;

    private List<String> allGenres;

    private boolean hasExpired;
}
