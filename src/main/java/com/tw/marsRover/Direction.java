package com.tw.marsRover;

interface Directions {
  Direction turnLeft();
  Direction turnRight();
}

public enum Direction implements Directions {
  EAST{
    @Override
    public Direction turnLeft(){
      return Direction.NORTH;
    }

    @Override
    public Direction turnRight(){
      return Direction.SOUTH;
    }
  },WEST{
    @Override
    public Direction turnLeft(){
      return Direction.SOUTH;
    }
    @Override
    public Direction turnRight(){
      return Direction.NORTH;
    }
  },NORTH{
    @Override
    public Direction turnLeft(){
      return Direction.WEST;
    }
    @Override
    public Direction turnRight(){
      return Direction.EAST;
    }
  },SOUTH{
    @Override
    public Direction turnLeft(){
      return Direction.EAST;
    }
    @Override
    public Direction turnRight(){
      return Direction.WEST;
    }
  }
}

