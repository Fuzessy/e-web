package hu.fuz.eweb.process.dao;

import hu.fuz.eweb.entities.FolyamatCsoportFcsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessRepository extends JpaRepository<FolyamatCsoportFcsEntity, Long> {

}
