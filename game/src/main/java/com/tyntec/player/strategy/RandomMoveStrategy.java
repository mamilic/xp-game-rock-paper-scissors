package com.tyntec.player.strategy;

import com.tyntec.move.Move;
import com.tyntec.player.utils.RandomMoveGenerator;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RandomMoveStrategy implements MoveStrategy {

  private final RandomMoveGenerator randomMoveGenerator;

  @Override
  public Move getMove() {
    return randomMoveGenerator.generate();
  }
}
