package org.iesvdm.many_to_many.repository;

import org.iesvdm.many_to_many.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
