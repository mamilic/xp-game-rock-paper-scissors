# Introduction

Rock-Paper-Scissors game is computer driven,
which means the user can only observe for results
which will be displayed in console.
The game will end after 100 rounds.

There are 3 types of moves:

1. Rock
2. Paper
3. Scissors

The rules are:

- Rock beats Scissors
- Paper beats Rock
- Scissors beat Paper

If both players choose the same, then it is a Tie.

# Usage

There are a couple of entities that you will interact with.

- Player
- GameEngine
- GameStatistics

In order to start game you will have to create new players by
using PlayerFactory, where you need to provide player name, player Type,
and strategy.

```
Player playerOne =
        playerFactory.createPlayer("Player A", 
                                    PlayerType.COMPUTER, 
                                    new PaperStrategy());
Player playerTwo =
        playerFactory.createPlayer("Player B", 
                                    PlayerType.COMPUTER, 
                                    new PaperStrategy());
```

Then you can play the game by calling

```agsl
   List<RoundResult> roundResults = gameEngine.playGame(playerOne, playerTwo);
```

The RoundResults object contains round outcome, and can be used to get statistics 
by passing it like 

```agsl
    GameStatistics gameStatistics = new GameStatistics();
    gameStatistics.calculate(roundResults);

    PlayerStatistics playerOneStatistics = gameStatistics.getPlayerOneStatistics();
    PlayerStatistics playerTwoStatistics = gameStatistics.getPlayerTwoStatistics();

```

# Build and Test

The build tool is Maven.

In order to build app run  
```mvn clean package```

To run tests  
```mvn test```