package com.tw.marsRover;

public class RoverNotFoundException extends Throwable {
  public RoverNotFoundException() {
    super("Rover not found !");
  }
}
