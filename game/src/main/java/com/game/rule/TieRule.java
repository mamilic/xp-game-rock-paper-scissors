package com.game.rule;

import com.game.move.Move;
import com.game.result.Result;
import com.game.result.Tie;
import com.game.rule.core.Rule;

public class TieRule implements Rule {

  @Override
  public Boolean canHandle(Move first, Move second) {
    return first.getClass().equals(second.getClass());
  }

  @Override
  public Result apply(Move first, Move second) {
    return new Tie();
  }
}
