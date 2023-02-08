package com.game;

import com.game.engine.Config;
import com.game.engine.GameRunner;
import com.game.engine.RoundFactory;
import com.game.player.Player;
import com.game.player.PlayerFactory;
import com.game.result.PlayerMapper;
import com.game.result.RoundResult;
import com.game.statistics.GameStatistics;
import com.game.statistics.PlayerStatistics;
import com.game.statistics.StatisticsDisplay;

import java.util.List;

public class Application {

  public static void main(String[] args) {
    Config config = new Config(100);

    PlayerFactory playerFactory = new PlayerFactory(config);
    RoundFactory roundFactory = new RoundFactory(config, new PlayerMapper());

    GameRunner gameEngine = GameRunner.builder().config(config).roundFactory(roundFactory).build();

    Player playerOne = playerFactory.createPaperPlayer("Player A");
    Player playerTwo = playerFactory.createRandomPlayer("Player B");

    List<RoundResult> roundResults = gameEngine.playGame(playerOne, playerTwo);

    processResults(roundResults);
  }

  private static void processResults(List<RoundResult> roundResults) {

    GameStatistics gameStatistics = new GameStatistics();
    gameStatistics.calculate(roundResults);

    PlayerStatistics playerOneStatistics = gameStatistics.getPlayerOneStatistics();
    PlayerStatistics playerTwoStatistics = gameStatistics.getPlayerTwoStatistics();

    StatisticsDisplay.displayResults(roundResults.size(), playerOneStatistics, playerTwoStatistics);
  }
}
