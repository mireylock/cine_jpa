package org.iesvdm.cine_jpa;

import org.iesvdm.cine_jpa.domain.Actor;
import org.iesvdm.cine_jpa.domain.Categoria;
import org.iesvdm.cine_jpa.domain.Idioma;
import org.iesvdm.cine_jpa.domain.Pelicula;
import org.iesvdm.cine_jpa.repository.ActorRepository;
import org.iesvdm.cine_jpa.repository.CategoriaRepository;
import org.iesvdm.cine_jpa.repository.IdiomaRepository;
import org.iesvdm.cine_jpa.repository.PeliculaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

@SpringBootTest
class CineJpaTests {

    @Autowired
    PeliculaRepository peliculaRepository;

    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    IdiomaRepository idiomaRepository;

    @Autowired
    ActorRepository actorRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void guardarCategoriaPeliActor() {
        //Guarda many to many de película y categoría y película y actor
        Pelicula pelicula1 = new Pelicula();
        pelicula1.setTitulo("Titulo peli1");
        peliculaRepository.save(pelicula1);

        Pelicula pelicula2 = new Pelicula();
        pelicula2.setTitulo("Titulo peli2");
        peliculaRepository.save(pelicula2);

        Categoria categoria1 = new Categoria(0,"Categoria1", new HashSet<>());
        categoriaRepository.save(categoria1);

        Categoria categoria2 = new Categoria(0,"Categoria2", new HashSet<>());
        categoriaRepository.save(categoria2);

        pelicula1.getCategorias().add(categoria1);
        categoria1.getPeliculas().add(pelicula1);
        pelicula1.getCategorias().add(categoria2);
        categoria2.getPeliculas().add(pelicula1);

        pelicula2.getCategorias().add(categoria2);

        Actor actor1 = new Actor();
        actor1.setNombre("Actor1");
        actorRepository.save(actor1);
        Actor actor2 = new Actor();
        actor2.setNombre("Actor2");
        actorRepository.save(actor2);

        pelicula1.getActores().add(actor1);
        pelicula1.getActores().add(actor2);
        pelicula2.getActores().add(actor1);
        pelicula2.getActores().add(actor2);
        peliculaRepository.save(pelicula1);
        peliculaRepository.save(pelicula2);

    }

    @Test
    void guardarIdiomaPeli() {
        //Guarda oneToMany de idioma en película
        Idioma idioma = new Idioma();
        idioma.setNombre("Inglés");
        idiomaRepository.save(idioma);

        Pelicula pelicula3 = new Pelicula();
        pelicula3.setTitulo("Titulo peli3");
        pelicula3.setIdioma(idioma);

        Pelicula pelicula4 = new Pelicula();
        pelicula4.setTitulo("Titulo peli4");
        pelicula4.setIdioma(idioma);

        Set<Pelicula> peliculas = new HashSet<>();
        peliculas.add(pelicula3);
        peliculas.add(pelicula4);

        peliculaRepository.save(pelicula3);
        peliculaRepository.save(pelicula4);
    }

}
