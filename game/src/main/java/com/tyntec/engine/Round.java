package com.tyntec.engine;

import com.tyntec.player.Player;
import com.tyntec.result.PlayerMapper;
import com.tyntec.result.Result;
import com.tyntec.result.RoundResult;
import com.tyntec.rule.core.RuleChain;
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
