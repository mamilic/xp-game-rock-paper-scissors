package com.tyntec.player.utils;

import com.tyntec.config.Config;
import com.tyntec.move.Move;

import java.security.SecureRandom;

public class RandomMoveGenerator {

  private final SecureRandom random;
  private final Config config;

  public RandomMoveGenerator(Config config) {
    this.config = config;
    random = new SecureRandom();
  }

  public Move generate() {
    int randomIndex = random.nextInt(Config.getInstance().getAllowedMoves().size());

    return Config.getInstance().getAllowedMoves().get(randomIndex);
  }
}
