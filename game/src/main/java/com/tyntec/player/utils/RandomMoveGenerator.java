package com.tyntec.player.utils;

import com.tyntec.config.Config;
import com.tyntec.move.Move;

import java.security.SecureRandom;

public class RandomMoveGenerator {

  private final Config config;
  private final SecureRandom random;

  public RandomMoveGenerator(Config config) {
    this.config = config;
    random = new SecureRandom();
  }

  public Move generate() {
    int randomIndex = random.nextInt(config.getAllowedMoves().size());

    return config.getAllowedMoves().get(randomIndex);
  }
}
