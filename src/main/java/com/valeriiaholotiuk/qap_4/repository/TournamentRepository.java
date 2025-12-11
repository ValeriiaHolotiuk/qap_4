package com.valeriiaholotiuk.qap_4.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valeriiaholotiuk.qap_4.model.Tournament;

public interface TournamentRepository extends JpaRepository<Tournament, Long> {


    List<Tournament> findByStartDate(LocalDate startDate);

    List<Tournament> findByLocationContainingIgnoreCase(String location);
}
