package com.valeriiaholotiuk.qap_4.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valeriiaholotiuk.qap_4.model.Tournament;
import com.valeriiaholotiuk.qap_4.service.TournamentService;

@RestController
@RequestMapping("/api/tournaments")
public class TournamentController {

    private final TournamentService tournamentService;

    public TournamentController(TournamentService tournamentService) {
        this.tournamentService = tournamentService;
    }

    @PostMapping
    public Tournament createTournament(@RequestBody Tournament tournament) {
        return tournamentService.createTournament(tournament);
    }

    @GetMapping
    public Iterable<Tournament> getAllTournaments() {
        return tournamentService.getAllTournaments();
    }

    @GetMapping("/{id}")
    public Tournament getTournamentById(@PathVariable Long id) {
        return tournamentService.getTournamentById(id);
    }

    @PostMapping("/{tournamentId}/register/{memberId}")
    public Tournament registerMember(
            @PathVariable Long tournamentId,
            @PathVariable Long memberId
    ) {
        return tournamentService.registerMember(tournamentId, memberId);
    }
}
