package com.game.player.strategy;

import com.game.move.Move;
import com.game.move.Paper;

public class PaperStrategy implements MoveStrategy {

  @Override
  public Move getMove() {
    return new Paper();
  }
}
