package walking.game;

import walking.game.WalkingBoard;
import walking.game.player.Player;
import walking.game.player.MadlyRotatingBuccaneer;

import walking.game.util.Direction;

public class WalkingBoardWithPlayers extends WalkingBoard{
  private Player[] players;
  private int round;
  public final static int SCORE_EACH_STEP = 13;

  public WalkingBoardWithPlayers(int[][] board, int playerCount){
    super(board);
    if(playerCount < 2) throw new IllegalArgumentException();
    initPlayers(playerCount);
  }

  public WalkingBoardWithPlayers(int size, int playerCount){
    super(size);
    if(playerCount < 2) throw new IllegalArgumentException();
    initPlayers(playerCount);
  }

  private void initPlayers(int playerCount){
    players = new Player[playerCount];
    for(int i = 0; i < playerCount; i++){
      players[i] = i == 0 ? new MadlyRotatingBuccaneer() : new Player();
    }
  }

  public int[] walk(int... stepCounts){
    round = 0;
    int stepsTaken = 0;
    for (int i = 0; i < stepCounts.length; i++){
      stepsTaken = stepsTaken <= SCORE_EACH_STEP ? stepsTaken : SCORE_EACH_STEP;
      int actualPlayerIndex = i % players.length;
      int scoreToAdd = 0;

      // buccaneer
      if (actualPlayerIndex == 0){
        // round/players.length-szer került eddig sorra
        turnXTimes(players[0], round/players.length); 
        scoreToAdd += moveAndSetXTimes(players[0].getDirection(), stepsTaken, stepCounts[i]);
      }
      // normal player
      else {
        players[actualPlayerIndex].turn();
        scoreToAdd += moveAndSetXTimes(players[actualPlayerIndex].getDirection(), stepsTaken, stepCounts[i]);
      }

      // A tábláról felolvasott értékkel megnöveljük a játékos pontszámát. (amelyik tileokon járt, annak az értékét hozzáadja)
      players[actualPlayerIndex].addToScore(scoreToAdd);

      stepsTaken += stepCounts[i];
      round++;
    }

    // player scores
    int[] scores = new int[players.length];
    for(int i = 0; i < players.length; i++) scores[i] = players[i].getScore();
    return scores;
  }

  private int moveAndSetXTimes(Direction direction, int value, int x){
    int sum = 0;
    for(int i = 0; i < x; i++) sum += moveAndSet(direction, value);
    return sum;
  }
   private void turnXTimes(Player player, int x){
    for(int i = 0; i < x; i++) player.turn();
  }
}