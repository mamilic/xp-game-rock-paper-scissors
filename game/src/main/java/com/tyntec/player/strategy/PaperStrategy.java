package com.tyntec.player.strategy;

import com.tyntec.move.Paper;
import com.tyntec.move.Move;

public class PaperStrategy implements MoveStrategy {

  @Override
  public Move getMove() {
    return new Paper();
  }
}
