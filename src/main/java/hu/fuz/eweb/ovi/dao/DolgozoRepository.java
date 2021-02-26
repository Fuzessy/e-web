package hu.fuz.eweb.ovi.dao;

import hu.fuz.eweb.entities.DolgozoDol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DolgozoRepository extends JpaRepository<DolgozoDol, Long> {
}
