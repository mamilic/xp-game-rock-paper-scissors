package com.game.rule.core;

import com.game.exception.GameConfigException;
import com.game.move.Move;
import com.game.result.Result;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RuleChain {

  private final List<Rule> rules;

  public RuleChain() {
    this.rules = new ArrayList<>();
  }

  public RuleChain addRule(Rule rule) {
    rules.add(rule);

    return this;
  }

  public Result handle(Move first, Move second) {
    Optional<Rule> optional =
        rules.stream().filter(rule -> rule.canHandle(first, second)).findFirst();

    if (optional.isEmpty()) {
      throw new GameConfigException("RuleChain can not be empty, please add rules to RuleChain");
    }

    return doHandle(first, second, optional.get());
  }

  private Result doHandle(Move first, Move second, Rule rule) {
    return rule.apply(first, second);
  }
}
