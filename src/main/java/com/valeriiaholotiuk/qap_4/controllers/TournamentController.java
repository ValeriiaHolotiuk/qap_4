package com.valeriiaholotiuk.qap_4.controllers;

import com.valeriiaholotiuk.qap_4.model.Tournament;
import com.valeriiaholotiuk.qap_4.service.TournamentService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

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
    public List<Tournament> getAllTournaments() {
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


    @GetMapping("/search")
    public List<Tournament> searchTournaments(
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam(required = false) String location
    ) {
        return tournamentService.searchTournaments(startDate, location);
    }
}
