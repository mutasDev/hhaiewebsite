package com.hhaie.backend.service;


import com.hhaie.backend.model.Player;
import com.hhaie.backend.model.dto.PlayerDto;
import com.hhaie.backend.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Player addPlayer(Player player) {
        return playerRepository.save(player);
    }

    public Player changePlayerPicture(Long playerId, String fileId) {
        Player player = UtilService.safeFindById(playerRepository, playerId);
        player.setPictureId(fileId);
        playerRepository.save(player);
        return player;
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }
}
