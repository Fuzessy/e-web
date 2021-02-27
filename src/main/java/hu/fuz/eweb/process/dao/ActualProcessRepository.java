package hu.fuz.eweb.process.dao;

import hu.fuz.eweb.entities.ProcessPr;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActualProcessRepository extends JpaRepository<ProcessPr, Long> {

}