// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.drive.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.sensors.RomiGyro;

public class Drivebase extends SubsystemBase {
  
  private final Spark leftMotor;
  private final Spark rightMotor;

  private final Encoder leftEncoder;
  private final Encoder rightEncoder;

  private final RomiGyro gyro;

  private final DifferentialDrive diffDrive;

  private static final double kCountsPerRevolution = 1440.0;
  private static final double kWheelDiameterInch = 2.75591; // 70 mm

  private final BuiltInAccelerometer accelerometer;
  
  /** Creates a new Drivebase. */
  public Drivebase() {
    leftMotor = new Spark(Constants.LEFT_MOTOR);
    rightMotor = new Spark(Constants.RIGHT_MOTOR);
    
    leftEncoder  = new Encoder(4, 5);
    rightEncoder = new Encoder(6, 7);

    gyro = new RomiGyro();

    accelerometer = new BuiltInAccelerometer();

    diffDrive = new DifferentialDrive(leftMotor, rightMotor);

    leftEncoder.setDistancePerPulse((Math.PI * kWheelDiameterInch) / kCountsPerRevolution);
    rightEncoder.setDistancePerPulse((Math.PI * kWheelDiameterInch) / kCountsPerRevolution);
    resetEncoders();
  }
  public void resetEncoders() {
    leftEncoder.reset();
    rightEncoder.reset();
  }

  public void arcadeDrive(double power, double turn) {
    diffDrive.arcadeDrive(power, turn);
    SmartDashboard.putNumber("Forward Speed", power);
  }

  public void tankDrive(double left, double right) {

    SmartDashboard.putNumber("Left Speed", left);
    SmartDashboard.putNumber("Right Speed", right);

    diffDrive.tankDrive(left, right, false);
  }

  public double getLeftDistanceInch() {
    return leftEncoder.getDistance();
  }

  public double getRightDistanceInch() {
    return rightEncoder.getDistance();
  }

  public double getLeftSpeed() {
    return leftEncoder.getRate();
  }

  public double getGyroAngleZ() {
    return gyro.getAngleZ();
  }

  /** Reset the gyro. */
  public void resetGyro() {
    gyro.reset();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Left Encoder", getLeftDistanceInch());
    SmartDashboard.putNumber("Right Encoder", getRightDistanceInch());
    SmartDashboard.putNumber("Encoder Speed", getLeftSpeed());
  }
}
