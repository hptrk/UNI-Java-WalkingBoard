package walking.game.player;

import walking.game.util.Direction;

public class MadlyRotatingBuccaneer extends Player{
  private int turnCount;

  public MadlyRotatingBuccaneer(){
    super();
  }

  public void turn(){
     direction = direction.next(direction);
  }
}