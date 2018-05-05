package com.tw.marsRover;

public class UnKnownCommandException extends Throwable {
  public UnKnownCommandException() {
    super("Command Not Found!");
  }
}
