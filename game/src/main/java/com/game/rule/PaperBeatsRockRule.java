package com.game.rule;

import com.game.move.Move;
import com.game.move.Paper;
import com.game.move.Rock;
import com.game.result.Result;
import com.game.rule.core.Rule;

public class PaperBeatsRockRule implements Rule {

  @Override
  public Boolean canHandle(Move first, Move second) {
    return (first instanceof Paper && second instanceof Rock)
        || (first instanceof Rock && second instanceof Paper);
  }

  @Override
  public Result apply(Move first, Move second) {
    return new Paper();
  }
}
