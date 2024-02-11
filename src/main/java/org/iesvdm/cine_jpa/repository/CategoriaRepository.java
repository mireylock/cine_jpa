package org.iesvdm.cine_jpa.repository;

import org.iesvdm.cine_jpa.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
