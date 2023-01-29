package com.game.config;

import com.game.move.Rock;
import com.game.rule.RockBeatsScissorsRule;
import com.game.move.Move;
import com.game.move.Paper;
import com.game.move.Scissors;
import com.game.rule.PaperBeatsRockRule;
import com.game.rule.ScissorsBeatPaperRule;
import com.game.rule.TieRule;
import com.game.rule.core.RuleChain;
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
