package walking.game;

import static check.CheckThat.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.api.extension.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import check.*;
import walking.game.WalkingBoard;
import walking.game.util.Direction;
import walking.game.player.Player;

public class WalkingBoardWithPlayersTest{
  @Test
  public void walk1(){
    WalkingBoardWithPlayers board = new WalkingBoardWithPlayers(5, 2);
    Player player1 = new Player();
    Player player2 = new Player();

    int stepCounts[] = {1,3,2,1,2,2}; 
    int[] points = board.walk(stepCounts);

    // tábla állapota
    int[][] expected = {
      {3,1,1,1,4},
      {9,9,7,7,6},
      {3,3,3,3,3},
      {3,3,3,3,3},
      {3,3,3,3,3},
    };
    int[][] copyBoard = board.getTiles();

    for (int i = 0; i < expected.length; i++) {
      for(int j = 0; j < expected[i].length; j++){
            assertEquals(expected[i][j], copyBoard[i][j]);
          }
        }

    // pontszámok
    assertEquals(9,points[0]);
    assertEquals(18,points[1]);
  }

  @Test
  public void walk2(){
    WalkingBoardWithPlayers board = new WalkingBoardWithPlayers(5, 3);
    Player player1 = new Player();
    Player player2 = new Player();
    Player player3 = new Player();

    int stepCounts[] = {1,2,2,3,1,3,2,4,3};
    int[] points = board.walk(stepCounts);

    // tábla állapota
    int[][] expected = {
      {3,1,1,3,3},
      {3,3,3,3,8},
      {3,3,3,3,9},
      {3,3,3,3,9},
      {13,13,12,12,9},
    };
    int[][] copyBoard = board.getTiles();

    for (int i = 0; i < expected.length; i++) {
      for(int j = 0; j < expected[i].length; j++){
            assertEquals(expected[i][j], copyBoard[i][j]);
          }
        }

    // pontszámok
    assertEquals(6,points[0]);
    assertEquals(15,points[1]);
    assertEquals(15,points[2]);
  }
}
// LEJÁTSZÁSOK:
// p: pozíció

// ************************walk1************************
// ------------------------
// round = 0; stepstaken = 0;

// 3p3 3 3 3
// 3 3 3 3 3
// 3 3 3 3 3
// 3 3 3 3 3
// 3 3 3 3 3

// player 1: fel
// 0 pont

// ------------------------
// round = 1; stepstaken = 1;

// 3 1 1 1p3
// 3 3 3 3 3
// 3 3 3 3 3
// 3 3 3 3 3
// 3 3 3 3 3

// player 2: jobb
// 9 pont

// ------------------------
// round = 2; stepstaken = 4;

// 3 1 1 1 4p
// 3 3 3 3 3
// 3 3 3 3 3
// 3 3 3 3 3
// 3 3 3 3 3

// player 1: jobb 
// 3 pont

// ------------------------
// round = 3; stepstaken = 6;

// 3 1 1 1 4
// 3 3 3 3 6p
// 3 3 3 3 3
// 3 3 3 3 3
// 3 3 3 3 3

// player 2: le
// pont 12pont

// ------------------------
// round = 4; stepstaken = 7;

// 3 1 1 1 4
// 3 3 7p7 6
// 3 3 3 3 3
// 3 3 3 3 3
// 3 3 3 3 3

// player 1: bal
// 9 pont

// ------------------------
// round = 5; stepstaken = 9;

// 3 1 1 1 4
// 9p9 7 7 6
// 3 3 3 3 3
// 3 3 3 3 3
// 3 3 3 3 3

// player 2:
// 18 pont

// player 1: 9 pont
// player 2: 18 pont

// ************************walk2************************

// ------------------------
// round = 0; stepstaken = 0;

// 3p3 3 3 3
// 3 3 3 3 3
// 3 3 3 3 3
// 3 3 3 3 3
// 3 3 3 3 3

// player 1: fel 
// 0 pont

// ------------------------
// round = 1; stepstaken = 1;

// 3 1 1p3 3
// 3 3 3 3 3
// 3 3 3 3 3
// 3 3 3 3 3
// 3 3 3 3 3

// player 2: jobb
// 6 pont

// ------------------------
// round = 2; stepstaken = 3;

// 3 1 1 3 3p
// 3 3 3 3 3
// 3 3 3 3 3
// 3 3 3 3 3
// 3 3 3 3 3

// player 3: jobb  
// 6 pont

// ------------------------
// round = 3; stepstaken = 5;

// 3 1 1 3 3p
// 3 3 3 3 3
// 3 3 3 3 3
// 3 3 3 3 3
// 3 3 3 3 3

// player 1: jobb
// 0 pont

// ------------------------
// round = 4; stepstaken = 8;

// 3 1 1 3 3
// 3 3 3 3 8p
// 3 3 3 3 3
// 3 3 3 3 3
// 3 3 3 3 3

// player 2: le
// 9 pont

// ------------------------
// round = 5; stepstaken = 9;

// 3 1 1 3 3
// 3 3 3 3 8
// 3 3 3 3 9
// 3 3 3 3 9
// 3 3 3 3 9p

// player 3: le  
// 15 pont

// ------------------------
// round = 6; stepstaken = 12;

// 3 1 1 3 3
// 3 3 3 3 8
// 3 3 3 3 9
// 3 3 3 3 9
// 3 3 12p12 9

// player 1: bal
// 6 pont

// ------------------------
// round = 7; stepstaken = 14;

// 3 1 1 3 3
// 3 3 3 3 8
// 3 3 3 3 9
// 3 3 3 3 9
// 13p 13 12 12 9

// player 2: bal
// 15 pont

// ------------------------
// round = 8; stepstaken = 18;

// 3 1 1 3 3
// 3 3 3 3 8
// 3 3 3 3 9
// 3 3 3 3 9
// 13p 13 12 12 9

// player 3: bal
// 15 pont


// player 1: 6 pont
// player 2: 15 pont
// player 3: 15 pont
