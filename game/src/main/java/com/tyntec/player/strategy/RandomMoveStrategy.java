package com.tyntec.player.strategy;

import com.tyntec.move.Move;
import com.tyntec.player.utils.RandomMoveGenerator;

public class RandomMoveStrategy implements MoveStrategy {

  @Override
  public Move getMove() {
    return RandomMoveGenerator.generate();
  }
}
