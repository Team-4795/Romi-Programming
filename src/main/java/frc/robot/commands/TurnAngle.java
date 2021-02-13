// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivebase;


public class TurnAngle extends CommandBase {
  private final double m_angle;
  private final double m_speed;
  private final Drivebase m_drivebase;

  /** Creates a new TurnAngle. */
  public TurnAngle(double angle, double speed, Drivebase drivebase) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drivebase);
    m_angle = angle;
    m_speed = speed;
    m_drivebase = drivebase;
    
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_drivebase.arcadeDrive(0,0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_drivebase.arcadeDrive(0, m_speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_drivebase.arcadeDrive(0,0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    //return false;
    return (m_drivebase.getGyroAngleZ() >= m_angle);
  }
}
