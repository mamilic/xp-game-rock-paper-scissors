package com.game.rule;

import com.game.move.Move;
import com.game.move.Paper;
import com.game.move.Rock;
import com.game.move.Scissors;
import com.game.result.Result;
import com.game.rule.PaperBeatsRockRule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PaperBeatsRockRuleTest {

  private PaperBeatsRockRule paperBeatsRockRule;

  @BeforeEach
  void setup() {
    paperBeatsRockRule = new PaperBeatsRockRule();
  }

  @Test
  void should_returnFalse_when_oneOfTheMovesIsScissors() {
    // Given
    Move scissors = new Scissors();
    Move paper = new Paper();

    // When
    Boolean canHandle = paperBeatsRockRule.canHandle(scissors, paper);

    // Then
    Assertions.assertFalse(canHandle);
  }

  @Test
  void should_returnFalse_when_oneBothMovesAreTheSame() {
    // Given
    Move paper = new Paper();

    // When
    Boolean canHandle = paperBeatsRockRule.canHandle(paper, paper);

    // Then
    Assertions.assertFalse(canHandle);
  }

  @Test
  void should_returnTrue_when_firstMoveIsPaperAndSecondRock() {
    // Given
    Move paper = new Paper();
    Move rock = new Rock();

    // When
    Boolean canHandle = paperBeatsRockRule.canHandle(paper, rock);

    // Then
    Assertions.assertTrue(canHandle);
  }

  @Test
  void should_returnTrue_when_firstMoveIsRockAndSecondPaper() {
    // Given
    Move paper = new Paper();
    Move rock = new Rock();

    // When
    Boolean canHandle = paperBeatsRockRule.canHandle(rock, paper);

    // Then
    Assertions.assertTrue(canHandle);
  }

  @Test
  void should_PaperBeatsRock_when_applyIsCalled() {
    // Given
    Move paper = new Paper();
    Move rock = new Rock();

    // When
    Result result = paperBeatsRockRule.apply(paper, rock);

    // Then
    Assertions.assertEquals(Paper.class, result.getClass());
  }
}
