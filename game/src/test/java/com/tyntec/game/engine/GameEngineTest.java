package com.tyntec.game.engine;

import com.tyntec.config.Config;
import com.tyntec.engine.GameEngine;
import com.tyntec.engine.Round;
import com.tyntec.engine.RoundFactory;
import com.tyntec.player.Player;
import com.tyntec.player.PlayerType;
import com.tyntec.player.strategy.MoveStrategy;
import com.tyntec.player.strategy.PaperStrategy;
import com.tyntec.result.RoundResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class GameEngineTest {

  @Mock private RoundFactory roundFactory;
  @Mock private Config config;
  @Mock private Round round;

  private GameEngine gameEngine;

  @BeforeEach
  void setup() {
    gameEngine = new GameEngine(config, roundFactory);
  }

  @Test
  void should_roundResultsSizeBeFive_when_gameIsFinished() {
    // Given
    int numberOfRounds = 5;
    Mockito.when(config.getNumberOfRounds()).thenReturn(numberOfRounds);
    Mockito.when(roundFactory.createRound(ArgumentMatchers.any(), ArgumentMatchers.any()))
        .thenReturn(round);
    Player playerOne = new MockPlayer(new PaperStrategy());
    Player playerTwo = new MockPlayer(new PaperStrategy());

    // When
    List<RoundResult> roundResults = gameEngine.playGame(playerOne, playerTwo);

    // Then
    Assertions.assertEquals(numberOfRounds, roundResults.size());
  }

  @Test
  void should_playRoundBeCalled5Times_when_gameIsFinished() {
    // Given
    int numberOfRounds = 5;
    Mockito.when(config.getNumberOfRounds()).thenReturn(numberOfRounds);
    Mockito.when(roundFactory.createRound(ArgumentMatchers.any(), ArgumentMatchers.any()))
            .thenReturn(round);
    Player playerOne = new MockPlayer(new PaperStrategy());
    Player playerTwo = new MockPlayer(new PaperStrategy());

    // When
    gameEngine.playGame(playerOne, playerTwo);

    // Then
    Mockito.verify(round, Mockito.times(numberOfRounds)).playRound();
  }

  class MockPlayer extends Player {

    public MockPlayer(MoveStrategy moveStrategy) {
      super("John", PlayerType.COMPUTER, moveStrategy);
    }
  }
}
