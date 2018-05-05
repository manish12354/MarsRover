package com.tw.marsRover;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws UnKnownCommandException, HeadingNotFoundException, RoverNotFoundException, RoverDiedException {
    ArrayList <String> allInstruction = new ArrayList <> ();
    Scanner scanner = new Scanner ( System.in );
    System.out.println ("enter range of plateau");
    String plateauInstruction = scanner.nextLine ();
    System.out.println ("enter first rover position");
    String[] firstRoverPosition = scanner.nextLine ().trim ().toUpperCase ().split ( " " );
    System.out.println ("enter first rover instruction");
    String firstRoverInstruction = scanner.nextLine ().trim ();
    System.out.println ("enter second rover position");
    String[] secondRoverPosition = scanner.nextLine ().trim ().toUpperCase ().split ( " " );
    System.out.println ("enter second rover instruction");
    String secondRoverInstruction = scanner.nextLine ().trim ();
    RoverController roverController = new RoverController (plateauInstruction);
    roverController.addRover (firstRoverInstruction,firstRoverPosition);
    roverController.addRover (secondRoverInstruction,secondRoverPosition);
    allInstruction.add ( firstRoverInstruction );
    allInstruction.add ( secondRoverInstruction );
    System.out.println (roverController.instruct (allInstruction));
  }
}
