package com.marcobiasone.cinemille.cinemille.mapper;

import com.marcobiasone.cinemille.cinemille.entities.Actor;
import org.springframework.stereotype.Service;

@Service
public class ActorMapper {

    public String fromEntityToName(Actor actor) {
        return actor.getName();
    }
}
