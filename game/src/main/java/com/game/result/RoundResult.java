package com.game.result;

import com.game.move.Move;
import com.game.player.PlayerType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class RoundResult {
  public enum Type {
    TIE,
    WINNER,
    LOSER
  }

  private Player playerOne;
  private Player playerTwo;

  @Setter
  @Getter
  @Builder
  public static class Player {
    private final String name;
    private final PlayerType type;
    private final Move move;
    private Type resultType;

    public void setResult(Result result) {
      if (result.getClass().equals(Tie.class)) {
        resultType = Type.TIE;
        return;
      }

      resultType = isWinner(result) ? Type.WINNER : Type.LOSER;
    }

    private boolean isWinner(Result result) {
      return move.getClass().equals(result.getClass());
    }
  }
}
