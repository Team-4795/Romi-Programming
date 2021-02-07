// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivebase extends SubsystemBase {
  /** Creates a new Drivebase. */
  private final Spark leftMotor; 
  private final Spark rightMotor; 
  private final DifferentialDrive diffDrive; 

  public Drivebase() {
    leftMotor = new Spark(Constants.LEFT_MOTOR);
    rightMotor = new Spark(Constants.RIGHT_MOTOR); 
    diffDrive = new DifferentialDrive(leftMotor, rightMotor);
  }
  public void arcadeDrive(double power, double turn){
    diffDrive.arcadeDrive(power, turn); 
  }
  // public void drive (double power, double turn) {
  //   leftMotor.set(power + turn); 
  //   rightMotor.set(power - turn);
  // }
  @Override
  public void periodic() {

    // This method will be called once per scheduler run
  }
}
