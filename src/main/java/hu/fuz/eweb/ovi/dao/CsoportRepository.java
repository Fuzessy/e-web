package hu.fuz.eweb.ovi.dao;

import hu.fuz.eweb.entities.OviCsoportOcs;
import hu.fuz.eweb.entities.TanuloTan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CsoportRepository extends JpaRepository<OviCsoportOcs, Long> {
}
