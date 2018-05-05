package com.tw.marsRover;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DirectionTest {
  Direction east;
  Direction west;
  Direction north;
  Direction south;
  @Before
  public void setUp() {
    east = Direction.EAST;
    west = Direction.WEST;
    north = Direction.NORTH;
    south = Direction.SOUTH;
  }

  @Test
  public void shouldBeAbleToTurnInNorthFromEast() {
    Direction nextDirection = east.turnLeft ();
    assertThat(nextDirection,is(Direction.NORTH));
  }

  @Test
  public void shouldBeAbleToTurnInSouthFromEast() {
    Direction nextDirection = east.turnRight ();
    assertThat(nextDirection,is(Direction.SOUTH));
  }

  @Test
  public void shouldBeAbleToTurnInWestFromSouth() {
    Direction nextDirection = south.turnRight ();
    assertThat(nextDirection,is(Direction.WEST));
  }

  @Test
  public void shouldBeAbleToTurnInEastFromSouth() {
    Direction nextDirection = south.turnLeft ();
    assertThat(nextDirection,is(Direction.EAST));
  }

  @Test
  public void shouldBeAbleToTurnInEastFromNorth() {
    Direction nextDirection = north.turnRight ();
    assertThat(nextDirection,is(Direction.EAST));
  }

  @Test
  public void shouldBeAbleToTurnInWestFromNorth() {
    Direction nextDirection = north.turnLeft ();
    assertThat(nextDirection,is(Direction.WEST));
  }

  @Test
  public void shouldBeAbleToTurnInSouthFromWest() {
    Direction nextDirection = west.turnLeft ();
    assertThat(nextDirection,is(Direction.SOUTH));
  }

  @Test
  public void shouldBeAbleToTurnInNorthFromWest() {
    Direction nextDirection = west.turnRight ();
    assertThat(nextDirection,is(Direction.NORTH));
  }
}
