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

public class WalkingBoardTest{
  @ParameterizedTest
  @CsvSource({
    "5",
    "6",
    "7"
  })
  public void testSimpleInit(int size){
    WalkingBoard board = new WalkingBoard(size);

    // méret
    int[][] testBoard = board.getTiles();
    assertEquals(size, testBoard.length);
    assertEquals(size, testBoard[0].length);
    
    // base_tile_score értékük van-e
    for (int i = 0; i < size; i++) {
        for (int j = 0; j < size; j++) {
            assertEquals(WalkingBoard.BASE_TILE_SCORE, testBoard[i][j]);
        }
    }
  }

  @ParameterizedTest
  @CsvSource({
    "0,2,3",
    "2,1,5",
    "1,1,8"
    })
  public void testCustomInit(int x, int y, int expected){
    int[][] customBoard = {
        {1, 4, 2, 2},
        {7, 8},
        {1, 5, 2}
    };

    WalkingBoard board = new WalkingBoard(customBoard);

    customBoard[x][y] = 0;
    int[][] copyBoard = board.getTiles();
    copyBoard[x][y] = 0;

    // megmaradt-e a helyes érték
    assertEquals(expected, board.getTile(x,y));
  }

  @Test
  public void testMoves(){
    int[][] expected = {
      {1,1,7,3,3},
      {5,3,3,3,3},
      {6,3,3,3,3},
      {3,3,3,3,3},
      {3,3,3,3,3}
    };
    WalkingBoard board = new WalkingBoard(5);
    assertEquals(3, board.moveAndSet(Direction.RIGHT, 8));
    assertEquals(3, board.moveAndSet(Direction.RIGHT, 7));
    assertEquals(8, board.moveAndSet(Direction.LEFT, 1));
    assertEquals(3, board.moveAndSet(Direction.LEFT, 1));
    assertEquals(3, board.moveAndSet(Direction.DOWN, 5));
    assertEquals(0, board.moveAndSet(Direction.LEFT, 5)); // kilépünk a táblából
    assertEquals(3, board.moveAndSet(Direction.DOWN, 6));
    int[][] copyBoard = board.getTiles();

    for (int i = 0; i < expected.length; i++) {
      for(int j = 0; j < expected[i].length; j++){
            assertEquals(expected[i][j], copyBoard[i][j]);
          }
        }
  }

}