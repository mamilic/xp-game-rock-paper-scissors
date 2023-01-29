package com.game.statistics;

public class StatisticsDisplay {

  public static void displayResults(
      int numberOfRounds,
      PlayerStatistics playerOneStatistics,
      PlayerStatistics playerTwoStatistics) {

    printWins(playerOneStatistics, numberOfRounds);
    printWins(playerTwoStatistics, numberOfRounds);

    printTies(playerOneStatistics.getNumberOfTies(), numberOfRounds);
  }

  private static void printWins(PlayerStatistics playerStatistics, int numberOfRounds) {
    System.out.println(
        playerStatistics.getName()
            + " wins "
            + playerStatistics.getNumberOfWins()
            + " of "
            + (numberOfRounds)
            + " games");
  }

  private static void printTies(int numberOfTies, int numberOfRounds) {
    System.out.println("Tie: " + (numberOfTies) + " of " + numberOfRounds + " games");
  }
}
