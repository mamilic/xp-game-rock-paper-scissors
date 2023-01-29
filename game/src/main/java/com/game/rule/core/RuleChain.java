package com.game.rule.core;

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

    Rule rule = optional.get();

    return rule.apply(first, second);
  }
}
