package walking.game.player;

import walking.game.util.Direction;

public class Player{
  private int score = 0;
  protected Direction direction = Direction.UP;

  public Player(){

  }

  public int getScore(){
    return score;
  }


  public Direction getDirection(){
    return direction;
  }

  public void addToScore(int score){
    this.score += score;
  }

  public void turn(){
    direction = direction.next(direction);
  }
}