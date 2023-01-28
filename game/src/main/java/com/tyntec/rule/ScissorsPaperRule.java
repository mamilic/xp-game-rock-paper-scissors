package com.tyntec.rule;

import com.tyntec.rule.core.Rule;
import com.tyntec.move.Paper;
import com.tyntec.move.Scissors;
import com.tyntec.move.Move;
import com.tyntec.result.Result;

public class ScissorsPaperRule implements Rule {

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
