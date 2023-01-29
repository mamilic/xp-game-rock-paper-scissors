package com.game.statistics;

import com.game.result.RoundResult;
import lombok.Getter;

import java.util.List;

@Getter
public class GameStatistics {

  private PlayerStatistics playerOneStatistics;
  private PlayerStatistics playerTwoStatistics;

  public void calculate(List<RoundResult> roundResults) {

    playerOneStatistics = new PlayerStatistics(roundResults.get(0).getPlayerOne().getName());
    playerTwoStatistics = new PlayerStatistics(roundResults.get(1).getPlayerOne().getName());

    roundResults.forEach(
        roundResult -> {
          handleResults(roundResult.getPlayerOne().getResultType(), playerOneStatistics);
          handleResults(roundResult.getPlayerTwo().getResultType(), playerTwoStatistics);
        });
  }

  private void handleResults(RoundResult.Type type, PlayerStatistics playerStatistics) {
    switch (type) {
      case WINNER -> playerStatistics.incrementWin();
      case LOSER -> playerStatistics.incrementLose();
      case TIE -> playerStatistics.incrementTie();
    }
  }
}
