package com.tw.marsRover;

public interface Move {
  Position move(int xPosition , int yPosition , Direction currentDirection);
}
