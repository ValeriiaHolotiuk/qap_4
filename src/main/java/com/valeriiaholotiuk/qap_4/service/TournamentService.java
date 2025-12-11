package com.valeriiaholotiuk.qap_4.service;

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
                .orElseThrow(() -> new RuntimeException("Tournament not found"));
    }

    public Tournament registerMember(Long tournamentId, Long memberId) {
        Tournament tournament = getTournamentById(tournamentId);
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("Member not found"));

        tournament.getMembers().add(member);
        return tournamentRepository.save(tournament);
    }
}

