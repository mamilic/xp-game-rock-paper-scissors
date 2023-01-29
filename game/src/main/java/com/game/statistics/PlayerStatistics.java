package com.game.statistics;

import lombok.Getter;

@Getter
public class PlayerStatistics {

  private String name;
  private int numberOfWins = 0;
  private int numberOfLosses = 0;
  private int numberOfTies = 0;

  public PlayerStatistics(String name) {
    this.name = name;
  }

  // RoundMoves
  // etc...

  public synchronized void incrementWin() {
    numberOfWins++;
  }

  public synchronized void incrementLose() {
    numberOfLosses++;
  }

  public synchronized void incrementTie() {
    numberOfTies++;
  }
}
