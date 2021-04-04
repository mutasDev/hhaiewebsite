package com.hhaie.backend.service;


import com.hhaie.backend.model.Player;
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

    public List<Player> changePlayerPicture(Long playerId, String fileId) {
        Player player = UtilService.safeFindById(playerRepository, playerId);
        List<Player> sameNames = playerRepository.findAllByNickName(player.getNickName());
        for(Player elem : sameNames) {
            elem.setPictureId(fileId);
        }
        playerRepository.saveAll(sameNames);
        return sameNames;
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }
}
