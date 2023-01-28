package com.tyntec;

import com.tyntec.config.Config;
import com.tyntec.engine.GameEngine;
import com.tyntec.engine.RoundFactory;
import com.tyntec.player.Player;
import com.tyntec.player.PlayerFactory;
import com.tyntec.player.PlayerType;
import com.tyntec.player.strategy.PaperStrategy;
import com.tyntec.player.strategy.RandomMoveStrategy;
import com.tyntec.result.PlayerMapper;
import com.tyntec.result.RoundResult;
import com.tyntec.statistics.GameStatistics;
import com.tyntec.statistics.PlayerStatistics;
import com.tyntec.statistics.StatisticsDisplay;

import java.util.List;

public class Application {

  public static void main(String[] args) {
    Config config = new Config();

    PlayerFactory playerFactory = new PlayerFactory();
    RoundFactory roundFactory = new RoundFactory(config, new PlayerMapper());

    GameEngine gameEngine = GameEngine.builder().config(config).roundFactory(roundFactory).build();

    Player playerOne =
        playerFactory.createPlayer("Player A", PlayerType.COMPUTER, new PaperStrategy());
    Player playerTwo =
        playerFactory.createPlayer("Player B", PlayerType.COMPUTER, new RandomMoveStrategy());

    List<RoundResult> roundResults = gameEngine.playGame(playerOne, playerTwo);

    GameStatistics gameStatistics = new GameStatistics();
    gameStatistics.calculate(roundResults);

    PlayerStatistics playerOneStatistics = gameStatistics.getPlayerOneStatistics();
    PlayerStatistics playerTwoStatistics = gameStatistics.getPlayerTwoStatistics();

    StatisticsDisplay.displayResults(
        config.getNumberOfRounds(), playerOneStatistics, playerTwoStatistics);
  }
}
