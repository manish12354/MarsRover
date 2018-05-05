package com.tw.marsRover;

public class Rover {
  private final Position initialPosition;

  public Rover(Position position) {
    this.initialPosition = position;
  }

  public Position turnLeft() {
    return initialPosition.left ( );
  }

  public Position turnRight() {
    return initialPosition.right ();
  }

  public Position moveForward(String range) throws RoverDiedException {
    return initialPosition.next (range);
  }
}
