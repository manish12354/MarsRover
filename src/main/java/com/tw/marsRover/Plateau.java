package com.tw.marsRover;

import java.util.ArrayList;

public class Plateau {
  private final ArrayList <Position> positions;
  private final String range;
  private final ArrayList <Position> markedPositions;

  Plateau(String range) {
    this.markedPositions = new ArrayList<> (  );
    this.range = range;
    this.positions = new ArrayList<> (  );
    setUp(range);
  }

  private void setUp(String range) {
    String[] splittedRange = range.split ( " " );
    int maxXcoordinate = Integer.parseInt ( splittedRange[0] );
    int maxYCoordinate = Integer.parseInt ( splittedRange[1] );
    for (int i = 0; i !=maxXcoordinate; i++) {
      for (int j = 0; j != maxYCoordinate; j++) {
        positions.add ( new Position ( i,j,Direction.EAST ) );
      }
    }
  }
  public void addMarkedPosition(Position position){
    markedPositions.add ( position );
  }
}
