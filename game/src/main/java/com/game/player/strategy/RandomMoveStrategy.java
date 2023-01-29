package com.game.player.strategy;

import com.game.move.Move;
import com.game.player.utils.RandomMoveGenerator;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RandomMoveStrategy implements MoveStrategy {

  private final RandomMoveGenerator randomMoveGenerator;

  @Override
  public Move getMove() {
    return randomMoveGenerator.generate();
  }
}
