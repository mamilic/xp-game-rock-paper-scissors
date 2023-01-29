package com.game.engine;

import com.game.result.PlayerMapper;
import com.game.result.Result;
import com.game.player.Player;
import com.game.result.RoundResult;
import com.game.rule.core.RuleChain;
import lombok.Builder;

public class Round {

  private final Player playerOne;
  private final Player playerTwo;

  private final RuleChain ruleChain;
  private final PlayerMapper playerMapper;

  @Builder
  public Round(Player playerOne, Player playerTwo, RuleChain ruleChain, PlayerMapper playerMapper) {
    this.playerOne = playerOne;
    this.playerTwo = playerTwo;
    this.ruleChain = ruleChain;
    this.playerMapper = playerMapper;
  }

  public RoundResult playRound() {
    RoundResult.Player playerOne = playerMapper.map(this.playerOne);
    RoundResult.Player playerTwo = playerMapper.map(this.playerTwo);

    Result result = ruleChain.handle(playerOne.getMove(), playerTwo.getMove());

    playerOne.setResult(result);
    playerTwo.setResult(result);

    return RoundResult.builder().playerOne(playerOne).playerTwo(playerTwo).build();
  }
}
