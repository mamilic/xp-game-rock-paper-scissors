package com.game.player.strategy;

import com.game.move.Move;
import com.game.move.Paper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PaperStrategyTest {

  private PaperStrategy paperStrategy;

  @BeforeEach
  void setup() {
    paperStrategy = new PaperStrategy();
  }

  @Test
  void should_returnPaper_when_getMoveIsCalled() {
    // When
    Move move = paperStrategy.getMove();

    // Then
    Assertions.assertEquals(Paper.class, move.getClass());
  }
}
