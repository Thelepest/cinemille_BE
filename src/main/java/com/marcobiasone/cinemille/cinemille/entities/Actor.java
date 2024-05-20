package com.marcobiasone.cinemille.cinemille.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "actor")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToMany(mappedBy = "actors")
    List<Movie> movies;

}
