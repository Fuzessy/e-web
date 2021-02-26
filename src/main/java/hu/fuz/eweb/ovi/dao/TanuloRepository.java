package hu.fuz.eweb.ovi.dao;

import hu.fuz.eweb.entities.TanuloTan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TanuloRepository extends JpaRepository<TanuloTan, Long> {

}
