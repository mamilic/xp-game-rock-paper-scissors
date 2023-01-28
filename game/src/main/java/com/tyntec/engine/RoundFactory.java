package com.tyntec.engine;

import com.tyntec.config.Config;
import com.tyntec.player.Player;
import com.tyntec.result.PlayerMapper;
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
