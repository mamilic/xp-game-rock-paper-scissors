package com.game.rule;

import com.game.move.Move;
import com.game.move.Paper;
import com.game.result.Result;
import com.game.rule.core.Rule;
import com.game.move.Scissors;

public class ScissorsBeatPaperRule implements Rule {

  @Override
  public Boolean canHandle(Move first, Move second) {
    return (first instanceof Scissors && second instanceof Paper)
        || (second instanceof Scissors && first instanceof Paper);
  }

  @Override
  public Result apply(Move first, Move second) {
    return new Scissors();
  }
}
