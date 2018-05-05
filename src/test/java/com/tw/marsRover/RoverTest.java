package com.tw.marsRover;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RoverTest {

  private Rover rover;

  @Before
  public void setUp() {
    Position position = new Position ( 0 , 0 , Direction.NORTH );
    rover = new Rover (position);
  }

  @Test
  public void shouldTurnLeft() {
    Position nextPosition = rover.turnLeft();
    Position expected = new Position ( 0,0,Direction.WEST );
    assertEquals(nextPosition,expected);
  }

  @Test
  public void shouldTurnRight() {
    Position nextPosition = rover.turnRight();
    Position expected = new Position ( 0,0,Direction.EAST );
    assertEquals ( expected,nextPosition);
  }

  @Test
  public void shouldMoveForward() throws RoverDiedException {
    Position nextPosition = rover.moveForward ("4 4");
    Position expected = new Position ( 0,1,Direction.NORTH );
    assertEquals ( nextPosition,expected );
  }
}
