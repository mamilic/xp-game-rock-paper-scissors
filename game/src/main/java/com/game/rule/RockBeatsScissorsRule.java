package com.game.rule;

import com.game.move.Rock;
import com.game.result.Result;
import com.game.rule.core.Rule;
import com.game.move.Scissors;
import com.game.move.Move;

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
