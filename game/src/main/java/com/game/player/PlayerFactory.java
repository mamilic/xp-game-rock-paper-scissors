package com.game.player;

import com.game.engine.Config;
import com.game.player.strategy.MoveStrategy;
import com.game.player.strategy.PaperStrategy;
import com.game.player.strategy.RandomMoveStrategy;
import com.game.player.utils.RandomMoveGenerator;

public class PlayerFactory {

  private final Config config;

  public PlayerFactory(Config config) {
    this.config = config;
  }

  public Player createPlayer(String name, PlayerType type, MoveStrategy moveStrategy) {
    return new Player(name, type, moveStrategy);
  }

  public Player createPaperPlayer(String name) {
    return new Player(name, PlayerType.COMPUTER, new PaperStrategy());
  }

  public Player createRandomPlayer(String name) {
    return new Player(
        name, PlayerType.COMPUTER, new RandomMoveStrategy(new RandomMoveGenerator(config)));
  }
}
