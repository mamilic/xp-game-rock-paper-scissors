package com.tyntec.rule;

import com.tyntec.rule.core.Rule;
import com.tyntec.move.Rock;
import com.tyntec.move.Scissors;
import com.tyntec.move.Move;
import com.tyntec.result.Result;

public class RockBeatsScissorsRule implements Rule {

  @Override
  public Boolean canHandle(Move first, Move second) {
    return (first instanceof Rock && second instanceof Scissors)
        || (first instanceof Scissors && second instanceof Rock);
  }

  @Override
  public Result apply(Move first, Move second) {
    return new Rock();
  }
}
