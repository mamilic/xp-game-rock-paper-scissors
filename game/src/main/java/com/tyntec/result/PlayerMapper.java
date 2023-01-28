package com.tyntec.result;

import com.tyntec.player.Player;

public class PlayerMapper {

  public RoundResult.Player map(Player player) {
    return RoundResult.Player.builder()
        .type(player.getType())
        .name(player.getName())
        .move(player.getMove())
        .build();
  }
}
