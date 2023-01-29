package com.game.engine;

import com.game.config.Config;
import com.game.player.Player;
import com.game.result.RoundResult;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Builder
public class GameEngine {

  private final Config config;
  private final RoundFactory roundFactory;

  public GameEngine(Config config, RoundFactory roundFactory) {
    this.config = config;
    this.roundFactory = roundFactory;
  }

  public List<RoundResult> playGame(Player playerOne, Player playerTwo) {
    List<RoundResult> roundResults = new ArrayList<>();

    IntStream.range(0, config.getNumberOfRounds())
        .mapToObj(r -> roundFactory.createRound(playerOne, playerTwo))
        .forEach(
            round -> {
              RoundResult roundResult = round.playRound();
              roundResults.add(roundResult);
            });

    return roundResults;
  }
}
