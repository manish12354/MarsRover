package com.tw.marsRover;

import java.util.ArrayList;
import java.util.HashMap;

public class RoverController {
  private final HashMap <String, Command> commands;
  private final HashMap <String, Direction> directions;
  private final HashMap <String,Rover> rovers;
  private final String roverRange;
  private final Plateau plateau;

  public RoverController(String range) {
    this.plateau = new Plateau(range);
    this.roverRange = range;
    this.directions = new HashMap<> (  );
    this.commands = new HashMap<> (  );
    this.rovers = new HashMap<> (  );
    setUp ();
  }

  private void setUp(){
    commands.put ("L",new TurnLeftCommand());
    commands.put ( "R", new TurnRightCommand() );
    commands.put ( "M",new MoveCommand(roverRange) );
    directions.put ( "E",Direction.EAST );
    directions.put ( "W",Direction.WEST );
    directions.put ( "N",Direction.NORTH );
    directions.put ( "S",Direction.SOUTH );
  }

  public String instruct(ArrayList<String> allInstructions) throws UnKnownCommandException, RoverNotFoundException, RoverDiedException {
    String finalOutput = "";
    for (String instruction : allInstructions) {
      Rover rover = rovers.get ( instruction.toUpperCase () );
      validateRover(rover);
      String[] splittedInstructions = instruction.toUpperCase ().split ( "" );
      String result1 = "";
      for (String command : splittedInstructions) {
        Command commandToExecute = commands.get ( command );
        validateCommand(commandToExecute);
        result1 = commandToExecute.execute ( rover ).toString ()+"\n";
      }
      finalOutput += result1;
    }
    return finalOutput;
  }

  private void validateCommand(Command commandToExecute) throws UnKnownCommandException {
    if (commandToExecute==null) {
      throw new UnKnownCommandException();
    }
  }

  private void validateRover(Rover rover) throws RoverNotFoundException {
    if (rover==null)
      throw new RoverNotFoundException();
  }

  private Direction getHeading(String heading) {
    return directions.get ( heading );
  }

  public void addRover(String instructions, String[] roverPosition) throws HeadingNotFoundException {
    String headingSymbol = roverPosition[2];
    int xCoordinate = Integer.parseInt ( roverPosition[0] );
    int yCoordinate = Integer.parseInt ( roverPosition[1] );
    Direction heading = getHeading ( headingSymbol );
    if (heading==null)
      throw new HeadingNotFoundException();
    Position position = new Position ( xCoordinate , yCoordinate , heading );
    rovers.put (instructions.toUpperCase (),new Rover ( position ));
  }


  //////commands

  private class TurnLeftCommand implements Command {
    @Override
    public Position execute(Rover rover) {
      return rover.turnLeft ();
    }
  }

  private class TurnRightCommand implements Command {
    @Override
    public Position execute(Rover rover) {
      return rover.turnRight ();
    }
  }

  private class MoveCommand implements Command {
    private final String range;
    public MoveCommand(String range) {
      this.range = range;
    }
    @Override
    public Position execute(Rover rover) throws RoverDiedException {
      return rover.moveForward (range);
    }
  }
}
