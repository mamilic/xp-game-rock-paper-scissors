package com.game.engine;

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

@Getter
public class Config {

  private int numberOfRounds;
  private final RuleChain ruleChain;
  private final List<Move> allowedMoves;

  public Config(int numberOfRounds) {
    this.numberOfRounds = numberOfRounds;
    allowedMoves = List.of(new Rock(), new Paper(), new Scissors());
    ruleChain =
        new RuleChain()
            .addRule(new RockBeatsScissorsRule())
            .addRule(new ScissorsBeatPaperRule())
            .addRule(new PaperBeatsRockRule())
            .addRule(new TieRule());
  }

}
