package com.mindtree.repository;

import com.mindtree.entity.Player;
import com.mindtree.utility.InterfaceDto;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface CovidDataRepository extends JpaRepository<Player, Long> {

   List<Player> findByState(String state, Sort sort);

    @Query("SELECT c.localDate AS date, c.state AS state, COUNT(c.tested) AS testedTotal, COUNT(c.confirmed) AS confirmedTotal, COUNT(c.recovered) AS recoveredTotal " +
            "FROM Player AS c WHERE c.localDate BETWEEN ?1 AND ?2 " +
            "GROUP BY c.localDate, c.state " +
            "ORDER BY c.localDate asc")
    List<InterfaceDto> findDataOfStateInDateRange(LocalDate startDate, LocalDate endDate);

    @Query("SELECT c.localDate AS date, c.state AS state, COUNT(c.tested) AS testedTotal, COUNT(c.confirmed) AS confirmedTotal, COUNT(c.recovered) AS recoveredTotal " +
            "FROM Player AS c WHERE c.state = ?1 AND " +
            "(c.localDate BETWEEN ?2 AND ?3) " +
            "GROUP BY c.localDate, c.state " +
            "ORDER BY c.localDate asc")
    List<InterfaceDto> findDataOfParticularStateInDateRange(String state, LocalDate startDate, LocalDate endDate);
}
