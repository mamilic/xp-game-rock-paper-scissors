package com.game.player.strategy;

import com.game.move.Move;
import com.game.move.Rock;
import com.game.player.utils.RandomMoveGenerator;
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
    // When
    Move move = randomMoveStrategy.getMove();

    // Then
    Assertions.assertEquals(Rock.class, move.getClass());
  }

  static class MockMoveGenerator extends RandomMoveGenerator {

    public MockMoveGenerator() {
      super(null);
    }

    @Override
    public Move generate() {
      return new Rock();
    }
  }
}
