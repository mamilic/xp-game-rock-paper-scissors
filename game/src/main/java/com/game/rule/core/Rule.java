package com.game.rule.core;

import com.game.move.Move;
import com.game.result.Result;

public interface Rule {

  Boolean canHandle(Move first, Move second);

  Result apply(Move first, Move second);
}
