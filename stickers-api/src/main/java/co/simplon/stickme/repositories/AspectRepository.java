package co.simplon.stickme.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import co.simplon.stickme.dtos.AspectView;
import co.simplon.stickme.entities.Aspect;

public interface AspectRepository
	extends JpaRepository<Aspect, Long> {

    Collection<AspectView> findAllProjectedBy();

}
