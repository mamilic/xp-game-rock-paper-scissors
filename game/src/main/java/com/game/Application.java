package com.game;

import com.game.engine.GameEngine;
import com.game.result.PlayerMapper;
import com.game.statistics.GameStatistics;
import com.game.statistics.PlayerStatistics;
import com.game.config.Config;
import com.game.engine.RoundFactory;
import com.game.player.Player;
import com.game.player.PlayerFactory;
import com.game.player.PlayerType;
import com.game.player.strategy.PaperStrategy;
import com.game.player.strategy.RandomMoveStrategy;
import com.game.player.utils.RandomMoveGenerator;
import com.game.result.RoundResult;
import com.game.statistics.StatisticsDisplay;

import java.util.List;

public class Application {

  public static void main(String[] args) {
    Config config = new Config();

    PlayerFactory playerFactory = new PlayerFactory();
    RoundFactory roundFactory = new RoundFactory(config, new PlayerMapper());

    GameEngine gameEngine = GameEngine.builder().config(config).roundFactory(roundFactory).build();

    Player playerOne =
        playerFactory.createPlayer("Player A", PlayerType.COMPUTER, new PaperStrategy());

    RandomMoveStrategy randomMoveStrategy = new RandomMoveStrategy(new RandomMoveGenerator(config));
    Player playerTwo =
        playerFactory.createPlayer("Player B", PlayerType.COMPUTER, randomMoveStrategy);

    List<RoundResult> roundResults = gameEngine.playGame(playerOne, playerTwo);

    GameStatistics gameStatistics = new GameStatistics();
    gameStatistics.calculate(roundResults);

    PlayerStatistics playerOneStatistics = gameStatistics.getPlayerOneStatistics();
    PlayerStatistics playerTwoStatistics = gameStatistics.getPlayerTwoStatistics();

    StatisticsDisplay.displayResults(
        config.getNumberOfRounds(), playerOneStatistics, playerTwoStatistics);
  }
}
