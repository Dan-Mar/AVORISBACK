package es.avoris.boats.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.avoris.boats.model.Boat;

@Repository
public interface BoatRepository extends JpaRepository<Boat, Long> {


}
