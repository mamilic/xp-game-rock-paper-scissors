package com.game.player;

import com.game.move.Move;
import com.game.player.strategy.MoveStrategy;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Player {

  private final String name;
  private final PlayerType type;
  private final MoveStrategy moveStrategy;

  public String getName() {
    return name;
  }

  public PlayerType getType() {
    return type;
  }

  public Move getMove() {
    return moveStrategy.getMove();
  }
}
