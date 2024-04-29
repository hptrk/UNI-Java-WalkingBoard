package walking.game.util;

public enum Direction{
   UP, RIGHT, DOWN, LEFT;

   public Direction next(Direction direction){
      return Direction.values()[(direction.ordinal() + 1) % 4];
   }
}