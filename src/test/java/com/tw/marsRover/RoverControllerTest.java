package com.tw.marsRover;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class RoverControllerTest {
  RoverController roverController;
  private ArrayList <String> allInstruction;
  private String plateauInstruction;

  @Before
  public void setUp() {
    plateauInstruction = "5 5";
    roverController = new RoverController (plateauInstruction);
    allInstruction = new ArrayList<> ();
  }

  @Test(expected =UnKnownCommandException.class)
  public void shouldThrowExceptionIfUnknownCommandIsGiven() throws UnKnownCommandException, HeadingNotFoundException, RoverNotFoundException, RoverDiedException {
    String[] roverPosition = "1 2 e".trim ().toUpperCase ().split ( " " );
    String roverInstruction = "dm".trim ();
    roverController.addRover (roverInstruction,roverPosition);
    allInstruction.add ( roverInstruction );
    roverController.instruct (allInstruction);
  }

  @Test(expected =RoverDiedException.class)
  public void shouldThrowExceptionIfRoverReachesToEdgeOfPlatue() throws UnKnownCommandException, HeadingNotFoundException, RoverNotFoundException, RoverDiedException {
    String[] roverPosition = "1 2 e".trim ().toUpperCase ().split ( " " );
    String roverInstruction = "mmmmmmmmmmm".trim ();
    roverController.addRover (roverInstruction,roverPosition);
    allInstruction.add ( roverInstruction );
    roverController.instruct (allInstruction);
  }

  @Test(expected =RoverNotFoundException.class)
  public void shouldThrowExceptionIfRoverIsNotFound() throws UnKnownCommandException, HeadingNotFoundException, RoverNotFoundException, RoverDiedException {
    String roverInstruction = "dm".trim ();
    allInstruction.add ( roverInstruction );
    roverController.instruct (allInstruction);
  }

  @Test(expected = HeadingNotFoundException.class)
  public void shouldThrowExceptionIfUnknownHeadingIsGiven() throws UnKnownCommandException, HeadingNotFoundException, RoverNotFoundException, RoverDiedException {
    String instruction = "1 2 q";
    roverController.addRover ("lm",instruction.toUpperCase ().split ( " " ) );
    roverController.instruct ( allInstruction );
  }

  @Test
  public void shouldMoveInEast() throws HeadingNotFoundException, RoverNotFoundException, UnKnownCommandException, RoverDiedException {
    String[] roverPosition = "1 2 n".trim ().toUpperCase ().split ( " " );
    String roverInstruction = "rmm".trim ();
    roverController.addRover (roverInstruction,roverPosition);
    allInstruction.add ( roverInstruction );
    String result = roverController.instruct ( allInstruction );
    assertEquals(result,"3 2 E\n");
  }

  @Test
  public void shouldMoveInWest() throws HeadingNotFoundException, RoverNotFoundException, UnKnownCommandException, RoverDiedException {
    String[] roverPosition = "1 2 n".trim ().toUpperCase ().split ( " " );
    String roverInstruction = "lm".trim ();
    roverController.addRover (roverInstruction,roverPosition);
    allInstruction.add ( roverInstruction );
    String result = roverController.instruct ( allInstruction );
    assertEquals(result,"0 2 W\n");
  }

  @Test
  public void shouldMoveInNorth() throws HeadingNotFoundException, RoverNotFoundException, UnKnownCommandException, RoverDiedException {
    String[] roverPosition = "1 2 e".trim ().toUpperCase ().split ( " " );
    String roverInstruction = "lm".trim ();
    roverController.addRover (roverInstruction,roverPosition);
    allInstruction.add ( roverInstruction );
    String result = roverController.instruct ( allInstruction );
    assertEquals(result,"1 3 N\n");
  }

  @Test
  public void shouldMoveInSouth() throws HeadingNotFoundException, RoverNotFoundException, UnKnownCommandException, RoverDiedException {
    String[] roverPosition = "1 2 e".trim ().toUpperCase ().split ( " " );
    String roverInstruction = "rm".trim ();
    roverController.addRover (roverInstruction,roverPosition);
    allInstruction.add ( roverInstruction );
    String result = roverController.instruct ( allInstruction );
    assertEquals(result,"1 1 S\n");
  }
}
