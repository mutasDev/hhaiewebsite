package com.hhaie.backend.service;

import com.hhaie.backend.model.Player;
import com.hhaie.backend.model.Team;
import com.hhaie.backend.model.enums.Game;
import com.hhaie.backend.repository.PlayerRepository;
import com.hhaie.backend.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamService {

    private final TeamRepository teamRepository;

    private final PlayerRepository playerRepository;

    public TeamService(TeamRepository teamRepository, PlayerRepository playerRepository) {
        this.teamRepository = teamRepository;
        this.playerRepository = playerRepository;
    }

    public Team createTeam(Team team) {
        if(team.getPlayers() == null) {
            team.setPlayers(new ArrayList<>());
        }
        return teamRepository.save(team);
    }

    public List<Team> getTeamsOfGame(Game game) {
        return teamRepository.findAllByGame(game);
    }

    public Team addPlayerToTeam(Long teamId, Long playerId) {
        Team team = UtilService.safeFindById(teamRepository, teamId);
        Player player = UtilService.safeFindById(playerRepository, playerId);
        List<Player> currentPlayers = team.getPlayers();
        currentPlayers.add(player);
        team.setPlayers(currentPlayers);
        return teamRepository.save(team);
    }

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public void clearTeams() {
        this.teamRepository.deleteAll();
    }
}
