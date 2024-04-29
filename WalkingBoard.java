package walking.game;
import java.util.Arrays;
import walking.game.util.Direction;

public class WalkingBoard{
  private int[][] tiles;
  private int x = 0;
  private int y = 0;
  public final static int BASE_TILE_SCORE = 3;

  public WalkingBoard(int size){
    tiles = new int[size][size];
    for (int i = 0; i < size; i++){
      for (int j = 0; j < size; j++){
        tiles[i][j] = BASE_TILE_SCORE;
      }
    }
  }
  public WalkingBoard(int[][] tiles){
    this.tiles = new int[tiles.length][tiles[0].length];
    for (int i = 0; i < tiles.length; i++){
      for (int j = 0; j < tiles[i].length; j++){
        this.tiles[i][j] = BASE_TILE_SCORE < tiles[i][j] ? tiles[i][j] : BASE_TILE_SCORE;
      }
    }
  }

  public int[][] getTiles(){
    int[][] deepCopy = new int[tiles.length][];
    for (int i = 0; i < tiles.length; i++) {
        deepCopy[i] = Arrays.copyOf(tiles[i], tiles[i].length);
    }
    return deepCopy;
  }

  public int[] getPosition(){
    return new int[] {x,y};
  }

  public boolean isValidPosition(int x, int y){
    return x >= 0 && x < tiles.length && y >= 0 && y < tiles[0].length;
  }

  public int getTile(int x, int y){
    if (!isValidPosition(x,y)) throw new IllegalArgumentException("Invalid position");
    return tiles[x][y];
  }

  public static int getXStep(Direction direction){
    switch(direction){
    case LEFT: case RIGHT: return 0;
    case UP: return -1;
    case DOWN: return 1;
    default: throw new IllegalArgumentException("Invalid direction");
   }
  }

  public static int getYStep(Direction direction){
   switch(direction){
    case UP: case DOWN: return 0;
    case LEFT: return -1;
    case RIGHT: return 1;
    default: throw new IllegalArgumentException("Invalid direction");
   }
  }

  public int moveAndSet(Direction direction, int value){
    if (!isValidPosition(x+getXStep(direction), y+getYStep(direction))) return 0;
    x+=getXStep(direction);
    y+=getYStep(direction);
    int oldValue = tiles[x][y]; 
    tiles[x][y] = value;
    return oldValue;
  }
}