package frc.robot;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class Constants {
  public static class PortsAndIDsAndStuff {
    public static final int joystickPort = 0;
    public static final int controllerPort = 2;

    public static final int frontRightID = 4;
    public static final int frontLeftID = 2;
    public static final int backRightID = 1;
    public static final int backLeftID = 3;

    public static final int rightElevatorID = 8;
    public static final int leftElevatorID = 9;

    public static final int right550ID = 6;
    public static final int left550ID = 5;

    public static final int rightClimberID = 10;
    public static final int leftClimberID = 11;

    public static final int elevatorButtonUp = 12;
    public static final int elevatorButtonDown = 11;
    public static final int climbDownButton = 3;
    public static final int climbUpButton = 5;

    public static final int x = 3;
    public static final int a = 1;
    public static final int b = 2;
    public static final int y = 4;

    public static final int lb = 5;
    public static final int rb = 6;
    //public static final int lt = 7;
    //public static final int rt = 8;
    public static final int back = 7;
    public static final int start = 8;
  }

  public static class speedsAndOtherStuff {
    public static final double moveSpeed = 1.0;

    // tolerance is in encoder counts
    public static final double elevatorMoveTolerance = 0.1;
    public static final double elevatorSlowSpeedTolerance = 3;
    public static final double elevatorSpeed = 0.35;
    public static final double elevatorSlowSpeed = 0.03;

    public static final double shootSpeed = 0.45;
    public static final double intakeSpeed = 0.05;

    public static final double climbSpeed = 0.05;

    // auto stuff
    public static final double autoMoveSpeed = 0.01;
    public static final double autoEncoderDistance = 20;
    public static final double gyroTolerance = 2;
    public static final double gyroTurnSpeed = 0.05;
    public static final double autoTurnSpeed = 0.2;
    public static final double autoTurnTolerance = 4;

    // determine experimentally
    public static final double shootCurrentWhenIntaking = 0.1;
    public static boolean intaking = false;
    public static double timeToIntake = 2.0;
    public static boolean loaded = false;

    // this is a hashmap which returns the elevator position in encoder counts for each position
    public static Map<Integer, Double> elevatorPositions = new HashMap<Integer, Double>();
    public static Map<Integer, Integer> buttonToLevel = new HashMap<Integer, Integer>();

    static {
      // map the elevator positions to absoloute encoder counts
        Map<Integer, Double> positions = new HashMap<>();
        positions.put(0, 0.0);
        positions.put(1, 43.28525924682617);

        positions.put(2, 86.8844985961914);
        positions.put(3, 50.0);
        elevatorPositions = Collections.unmodifiableMap(positions);

        //-- 1 pin ﻿﻿﻿﻿﻿﻿ -43.28525924682617 ﻿
        // 2 ﻿﻿﻿﻿﻿﻿ -86.8844985961914 ﻿





      // map the elevator positions to absoloute encoder counts
        Map<Integer, Integer> buttons = new HashMap<>();
        buttons.put(7, 1);
        buttons.put(8, 2);
        buttons.put(9, 3);
        buttons.put(10, -1);
        buttonToLevel = Collections.unmodifiableMap(buttons);
    }

    // elevator level starts at 0 then goes up to the tallest position, 
    // -1 means that the level is not being used ie. manual mode
    public static int elevatorLevel = -1;
  }
}
