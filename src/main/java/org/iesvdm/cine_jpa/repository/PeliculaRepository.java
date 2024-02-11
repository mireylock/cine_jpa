package org.iesvdm.cine_jpa.repository;

import org.iesvdm.cine_jpa.domain.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {
}
