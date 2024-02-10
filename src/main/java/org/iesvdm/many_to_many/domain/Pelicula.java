package org.iesvdm.many_to_many.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private long id;

    private String titulo;

    @ManyToMany
    private Set<Categoria> categorias = new HashSet<>();

    @ManyToMany (mappedBy = "peliculas")
    private Set<Actor> actores = new HashSet<>();

    @ManyToOne
    @ToString.Exclude
    private Idioma idioma;
}
