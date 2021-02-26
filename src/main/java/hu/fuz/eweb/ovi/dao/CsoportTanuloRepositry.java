package hu.fuz.eweb.ovi.dao;

import hu.fuz.eweb.entities.OviCsoportTanuloCst;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CsoportTanuloRepositry  extends JpaRepository<OviCsoportTanuloCst, Long> {
}
