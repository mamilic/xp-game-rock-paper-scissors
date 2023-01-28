package com.tyntec.config;

import com.tyntec.move.Move;
import com.tyntec.move.Paper;
import com.tyntec.move.Rock;
import com.tyntec.move.Scissors;
import com.tyntec.rule.PaperBeatsRockRule;
import com.tyntec.rule.RockBeatsScissorsRule;
import com.tyntec.rule.ScissorsBeatPaperRule;
import com.tyntec.rule.TieRule;
import com.tyntec.rule.core.RuleChain;
import lombok.Getter;

import java.util.List;
import java.util.Objects;

@Getter
public class Config {

  private static Config INSTANCE;

  private final int numberOfRounds;
  private final RuleChain ruleChain;
  private final List<Move> allowedMoves;

  public Config() {
    numberOfRounds = 100;
    allowedMoves = List.of(new Rock(), new Paper(), new Scissors());
    ruleChain =
        new RuleChain()
            .addRule(new RockBeatsScissorsRule())
            .addRule(new ScissorsBeatPaperRule())
            .addRule(new PaperBeatsRockRule())
            .addRule(new TieRule());
  }

  public static Config getInstance() {
    if (Objects.isNull(INSTANCE)) {
      INSTANCE = new Config();
    }

    return INSTANCE;
  }
}
