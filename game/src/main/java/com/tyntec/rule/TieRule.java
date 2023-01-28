package com.tyntec.rule;

import com.tyntec.rule.core.Rule;
import com.tyntec.move.Move;
import com.tyntec.result.Result;
import com.tyntec.result.Tie;

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
