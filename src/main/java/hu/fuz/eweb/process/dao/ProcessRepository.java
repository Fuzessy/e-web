package hu.fuz.eweb.process.dao;

import hu.fuz.eweb.entities.FolyamatCsoportFcs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessRepository extends JpaRepository<FolyamatCsoportFcs, Long> {

}
