package org.iesvdm.many_to_many.repository;

import org.iesvdm.many_to_many.domain.Idioma;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IdiomaRepository extends JpaRepository<Idioma, Long> {
}
