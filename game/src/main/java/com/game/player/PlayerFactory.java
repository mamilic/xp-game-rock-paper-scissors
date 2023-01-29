package com.game.player;

import com.game.player.strategy.MoveStrategy;

public class PlayerFactory {

  public Player createPlayer(String name, PlayerType type, MoveStrategy moveStrategy) {
    return new Player(name, type, moveStrategy);
  }
}
