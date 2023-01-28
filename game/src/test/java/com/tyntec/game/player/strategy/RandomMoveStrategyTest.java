package com.tyntec.game.player.strategy;

import com.tyntec.move.Move;
import com.tyntec.move.Rock;
import com.tyntec.player.strategy.RandomMoveStrategy;
import com.tyntec.player.utils.RandomMoveGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RandomMoveStrategyTest {

  private RandomMoveStrategy randomMoveStrategy;

  @BeforeEach
  void setup() {
    randomMoveStrategy = new RandomMoveStrategy(new MockMoveGenerator());
  }

  @Test
  void should_returnRock_when_getMoveIsCalled() {
    // Given

    // When
    Move move = randomMoveStrategy.getMove();

    // Then
    Assertions.assertEquals(Rock.class, move.getClass());
  }

  static class MockMoveGenerator extends RandomMoveGenerator {

    @Override
    public Move generate() {
      return new Rock();
    }
  }
}
