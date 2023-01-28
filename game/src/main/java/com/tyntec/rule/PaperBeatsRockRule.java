package com.tyntec.rule;

import com.tyntec.rule.core.Rule;
import com.tyntec.move.Paper;
import com.tyntec.move.Rock;
import com.tyntec.move.Move;
import com.tyntec.result.Result;

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
