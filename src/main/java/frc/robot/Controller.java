// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/** Add your docs here. */

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.drive.Vector2d;


public class Controller {
  private static final double DEADZONE = 0.05;
  private static double removeDeadzone(double value) {
    return Math.abs(value) > DEADZONE
      ? (Math.copySign(Math.abs(value) - DEADZONE, value) / (1.0 - DEADZONE))
      : 0.0;
  }
  
  private int type;
  private Joystick raw;

  public Controller(int port) {
    raw = new Joystick(port);
    if (raw.getButtonCount() == 13 && raw.getAxisCount() == 4) {
      type = 0; // Air Flow
    } else if (raw.getButtonCount() == 10 && raw.getAxisCount() == 6) {
      type = 1; // Rock Candy
    } else if (raw.getButtonCount() > 13) {
      type = 2;
    } else {
      type = 1; // Rock Candy
      // throw new Error("Unknown controller found with " + raw.getButtonCount() + " buttons and " + raw.getAxisCount() + " axes.");
    }
  }
  public Vector2d leftJoystick() {
    return new Vector2d(removeDeadzone(raw.getRawAxis(0)), removeDeadzone(raw.getRawAxis(1)));
  }
  public Vector2d rightJoystick() {
    return new Vector2d(
      // removeDeadzone(raw.getRawAxis(type > 0 ? (type > 1 ? 2 : 4) : 3)),
      // removeDeadzone(raw.getRawAxis(type > 0 ? (type > 1 ? 5 : 5) : 2)));
      removeDeadzone(raw.getRawAxis(type == 0 ? 3 : 4)),
      removeDeadzone(raw.getRawAxis(type == 0 ? 2 : 5)));
  }
  public double leftTrigger() {
    return type == 0 ? raw.getRawButton(7) ? 1 : 0 : removeDeadzone(raw.getRawAxis(2));
  }
  public double rightTrigger() {
    return type == 0 ? raw.getRawButton(8) ? 1 : 0 : removeDeadzone(raw.getRawAxis(3));
  }
  public boolean getA() {
    return raw.getRawButton(1);
  }
  public boolean pressedA() {
    return raw.getRawButtonPressed(1);
  }
  public boolean getB() {
    return raw.getRawButton(2);
  }
  public boolean pressedB() {
    return raw.getRawButtonPressed(2);
  }
  public boolean getX() {
    return raw.getRawButton(3);
  }
  public boolean pressedX() {
    return raw.getRawButtonPressed(3);
  }
  public boolean getY() {
    return raw.getRawButton(4);
  }
  public boolean pressedY() {
    return raw.getRawButtonPressed(4);
  }
  public boolean releasedY() {
    return raw.getRawButtonReleased(4);
  }
  public boolean leftBumper() {
    return raw.getRawButton(5);
  }
  public boolean leftBumperPressed() {
    return raw.getRawButtonPressed(5);
  }
  public boolean rightBumper() {
    return raw.getRawButton(6);
  }
  public boolean rightBumperPressed() {
    return raw.getRawButtonPressed(6);
  }
  public boolean backButton() {
    return raw.getRawButton(type == 0 ? 9 : 7);
  }
  public boolean backButtonPressed() {
    return raw.getRawButtonPressed(type == 0 ? 9 : 7);
  }
  public boolean startButton() {
    return raw.getRawButton(type == 0 ? 10 : 8);
  }
  public boolean startButtonPressed() {
    return raw.getRawButtonPressed(type == 0 ? 10 : 8);
  }
  public int dPad() {
    return raw.getPOV();
  }
}

