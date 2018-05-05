package com.tw.marsRover;

public interface Command {
  public Position execute(Rover rover) throws RoverDiedException;
}
