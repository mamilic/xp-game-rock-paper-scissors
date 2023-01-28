package com.tyntec.rule.core;

import com.tyntec.move.Move;
import com.tyntec.result.Result;

public interface Rule {

  Boolean canHandle(Move first, Move second);

  Result apply(Move first, Move second);
}
