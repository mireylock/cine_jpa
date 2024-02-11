package org.iesvdm.cine_jpa.repository;

import org.iesvdm.cine_jpa.domain.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Long> {
}
