package com.valeriiaholotiuk.qap_4.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.valeriiaholotiuk.qap_4.model.Member;
import com.valeriiaholotiuk.qap_4.model.Tournament;
import com.valeriiaholotiuk.qap_4.repository.MemberRepository;
import com.valeriiaholotiuk.qap_4.repository.TournamentRepository;

@Service
public class TournamentService {

    private final TournamentRepository tournamentRepository;
    private final MemberRepository memberRepository;

    public TournamentService(TournamentRepository tournamentRepository,
                             MemberRepository memberRepository) {
        this.tournamentRepository = tournamentRepository;
        this.memberRepository = memberRepository;
    }

    public Tournament createTournament(Tournament tournament) {
        return tournamentRepository.save(tournament);
    }

    public List<Tournament> getAllTournaments() {
        return tournamentRepository.findAll();
    }

    public Tournament getTournamentById(Long id) {
        return tournamentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tournament not found with id: " + id));
    }

    public Tournament registerMember(Long tournamentId, Long memberId) {
        Tournament tournament = tournamentRepository.findById(tournamentId)
                .orElseThrow(() -> new RuntimeException("Tournament not found with id: " + tournamentId));

        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("Member not found with id: " + memberId));

        tournament.addMember(member);  
        return tournamentRepository.save(tournament);
    }

c    public List<Tournament> searchTournaments(LocalDate startDate, String location) {
        if (startDate != null) {
            return tournamentRepository.findByStartDate(startDate);
        }
        if (location != null && !location.isBlank()) {
            return tournamentRepository.findByLocationContainingIgnoreCase(location);
        }

        return tournamentRepository.findAll();
    }
}

