package com.hhaie.backend.repository;

import com.hhaie.backend.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    List<Player> findAllByNickName(String nickName);
}
