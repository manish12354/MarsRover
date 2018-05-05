package com.tw.marsRover;

import java.util.HashMap;

public class Position {
  private int xCoordinate;
  private int yCoordinate;
  private final HashMap <Direction, Move> actions;
  private Direction currentDirection;

  public Position(int xCoordinate , int yCoordinate , Direction currentDirection) {
    this.xCoordinate = xCoordinate;
    this.yCoordinate = yCoordinate;
    this.currentDirection = currentDirection;
    this.actions = new HashMap<> ( );
    setUp();
  }

  private void setUp(){
    actions.put ( Direction.EAST,new MoveInEast());
    actions.put ( Direction.WEST,new MoveInWest());
    actions.put ( Direction.NORTH,new MoveInNorth());
    actions.put ( Direction.SOUTH,new MoveInSouth());
  }

  public Position left() {
    Direction nextDirection = currentDirection.turnLeft ();
    currentDirection = nextDirection;
    return new Position ( xCoordinate,yCoordinate, nextDirection );
  }

  public Position right() {
    Direction nextDirection = currentDirection.turnRight ();
    currentDirection = nextDirection;
    return new Position ( xCoordinate,yCoordinate, nextDirection );
  }

  public Position next(String range) throws RoverDiedException {
    Move action = actions.get ( currentDirection );
    Position position = action.move ( xCoordinate , yCoordinate , currentDirection );
    xCoordinate=position.xCoordinate;
    yCoordinate = position.yCoordinate;
    if (!isWithinRange (range))
      throw new RoverDiedException();
    return position;
  }

  private boolean isWithinRange(String range) {
    String[] splittedRange = range.trim ().split ( " " );
    int maxXCoordinate = Integer.parseInt ( splittedRange[0] );
    int maxYCoordinate = Integer.parseInt ( splittedRange[1] );
      return (xCoordinate<=maxXCoordinate&&xCoordinate>=0)&&(yCoordinate<=maxYCoordinate&&yCoordinate>=0);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Position)) return false;
    Position position = (Position) o;
    return xCoordinate == position.xCoordinate &&
            yCoordinate == position.yCoordinate &&
            currentDirection == position.currentDirection;
  }

  @Override
  public String toString() {
    return xCoordinate +
            " "+yCoordinate +" "+
            (""+ currentDirection).split ( "" )[0];
  }

  private class MoveInEast implements Move {
    @Override
    public Position move(int xPosition,int yPosition,Direction currentDirection){
      return new Position (xPosition+1 ,yCoordinate,currentDirection);
    }
  }

  private class MoveInWest implements Move{
    @Override
    public Position move(int xPosition,int yPosition,Direction currentDirection){
      return new Position (xPosition-1 ,yCoordinate,currentDirection);
    }
  }

  private class MoveInNorth implements Move {
    @Override
    public Position move(int xPosition,int yPosition,Direction currentDirection){
      return new Position (xPosition ,yCoordinate+1,currentDirection);
    }
  }

  private class MoveInSouth implements Move {
    @Override
    public Position move(int xPosition,int yPosition,Direction currentDirection){
      return new Position (xPosition ,yCoordinate-1,currentDirection);
    }
  }
}
