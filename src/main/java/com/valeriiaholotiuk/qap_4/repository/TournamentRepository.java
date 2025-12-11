package com.valeriiaholotiuk.qap_4.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.valeriiaholotiuk.qap_4.model.Tournament;

public interface TournamentRepository extends JpaRepository<Tournament, Long> {
}
