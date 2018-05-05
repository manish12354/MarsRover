package com.tw.marsRover;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PositionTest {

  private Position northPos;
  private Position eastPos;
  private Position westPos;
  private Position southPos;

  @Before
  public void setUp() {
    northPos = new Position ( 0,0,Direction.NORTH );
    eastPos = new Position ( 0,0,Direction.EAST );
    westPos = new Position ( 0,0,Direction.WEST );
    southPos = new Position ( 0,0,Direction.SOUTH );
  }

  @Test
  public void shouldMoveInEast() throws RoverDiedException {
    Position nextPosition = eastPos.next ("5 5");
    Position expected = new Position ( 1,0,Direction.EAST );
    assertEquals( expected ,nextPosition);
  }

  @Test
  public void shouldMoveInWest() throws RoverDiedException {
    westPos = new Position ( 4,4,Direction.WEST );
    Position nextPosition = westPos.next ("5 5");
    Position expected = new Position ( 3,4,Direction.WEST );
    assertEquals( expected ,nextPosition);
  }

  @Test
  public void shouldMoveInNorth() throws RoverDiedException {
    Position nextPosition = northPos.next ("5 5");
    Position expected = new Position ( 0,1,Direction.NORTH );
    assertEquals( expected ,nextPosition);
  }

  @Test
  public void shouldMoveInSouth() throws RoverDiedException {
    southPos = new Position ( 5,5,Direction.SOUTH );
    Position nextPosition = southPos.next ("6 6");
    Position expected = new Position ( 5,4,Direction.SOUTH );
    assertEquals( expected ,nextPosition);
  }

  @Test
  public void shouldTurnRightFromNorth() {
    Position nextPosition = northPos.right ();
    assertEquals ( eastPos ,nextPosition);
  }

  @Test
  public void shouldTurnLeftFromNorth() {
    Position nextPosition = northPos.left ();
    assertEquals ( westPos ,nextPosition);
  }

  @Test
  public void shouldTurnRightFromEast() {
    Position nextPosition = eastPos.right ();
    assertEquals ( southPos ,nextPosition);
  }

  @Test
  public void shouldTurnLeftFromEast() {
    Position nextPosition = eastPos.left ();
    assertEquals ( northPos,nextPosition);
  }

  @Test
  public void shouldTurnRightFromWest() {
    Position nextPosition = westPos.right ();
    assertEquals ( northPos,nextPosition);
  }

  @Test
  public void shouldTurnLeftFromWest() {
    Position nextPosition = westPos.left ();
    assertEquals ( southPos,nextPosition);
  }

  @Test
  public void shouldTurnRightFromSouth() {
    Position nextPosition = southPos.right ();
    assertEquals ( westPos,nextPosition);
  }

  @Test
  public void shouldTurnLeftFromSouth() {
    Position nextPosition = southPos.left ();
    assertEquals ( eastPos,nextPosition);
  }
}
