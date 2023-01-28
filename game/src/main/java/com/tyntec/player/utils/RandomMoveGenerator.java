package com.tyntec.player.utils;

import com.tyntec.config.Config;
import com.tyntec.move.Move;

import java.security.SecureRandom;

public final class RandomMoveGenerator {

  public static Move generate() {
    SecureRandom random = new SecureRandom();

    int randomIndex = random.nextInt(Config.getInstance().getAllowedMoves().size());

    return Config.getInstance().getAllowedMoves().get(randomIndex);
  }
}
