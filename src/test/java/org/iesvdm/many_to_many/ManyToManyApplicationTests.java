package org.iesvdm.many_to_many;

import org.iesvdm.many_to_many.domain.Categoria;
import org.iesvdm.many_to_many.domain.Pelicula;
import org.iesvdm.many_to_many.repository.CategoriaRepository;
import org.iesvdm.many_to_many.repository.PeliculaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;

@SpringBootTest
class ManyToManyApplicationTests {

    @Autowired
    PeliculaRepository peliculaRepository;

    @Autowired
    CategoriaRepository categoriaRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void guardarManyToMany() {
        Pelicula pelicula1 = new Pelicula(0, "Peli1", new HashSet<>());
        peliculaRepository.save(pelicula1);

        Categoria categoria1 = new Categoria(0,"Categoria1", new HashSet<>());
        categoriaRepository.save(categoria1);

        Categoria categoria2 = new Categoria(0,"Categoria2", new HashSet<>());
        categoriaRepository.save(categoria2);

        pelicula1.getCategorias().add(categoria1);
        categoria1.getPeliculas().add(pelicula1);
        pelicula1.getCategorias().add(categoria2);
        categoria2.getPeliculas().add(pelicula1);


        peliculaRepository.save(pelicula1);
        categoriaRepository.save(categoria1);
        categoriaRepository.save(categoria2);



    }

}
