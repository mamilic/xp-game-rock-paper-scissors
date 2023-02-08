package com.game.engine;

import com.game.player.Player;
import com.game.result.PlayerMapper;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RoundFactory {

  private final Config config;
  private final PlayerMapper playerMapper;

  public Round createRound(Player playerOne, Player playerTwo) {
    return Round.builder()
        .playerOne(playerOne)
        .playerTwo(playerTwo)
        .ruleChain(config.getRuleChain())
        .playerMapper(playerMapper)
        .build();
  }
}
