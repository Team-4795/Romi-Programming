// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivebase;

public class DriveDistance extends CommandBase {

  private final Drivebase m_drivebase;
  private final double m_speed;
  private final double m_distance;

  /** Creates a new DriveDistance. */
  public DriveDistance(double speed, double distance, Drivebase drivebase) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drivebase);
    m_drivebase = drivebase;
    m_speed = speed;
    m_distance = distance;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_drivebase.arcadeDrive(0,0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_drivebase.arcadeDrive(m_speed, 0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drivebase.arcadeDrive(0,0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (m_drivebase.getLeftDistanceInch() >= m_distance && m_drivebase.getRightDistanceInch() >= m_distance);
  }
}
