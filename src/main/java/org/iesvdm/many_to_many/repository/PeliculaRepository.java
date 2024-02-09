package org.iesvdm.many_to_many.repository;

import org.iesvdm.many_to_many.domain.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {
}
