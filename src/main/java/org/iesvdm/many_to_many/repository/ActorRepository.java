package org.iesvdm.many_to_many.repository;

import org.iesvdm.many_to_many.domain.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Long> {
}
